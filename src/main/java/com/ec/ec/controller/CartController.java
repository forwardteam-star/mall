package com.ec.ec.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ec.ec.Vo.DataVo;
import com.ec.ec.entity.Cart;
import com.ec.ec.entity.User;
import com.ec.ec.service.CartService;

@RestController
@CrossOrigin(allowCredentials="true",allowedHeaders="*")
@RequestMapping("cart")
public class CartController {
    /**
     * 服务对象
     */
    @Resource
    private CartService cartService;

    /**
     * 得到该用户购物车
     * @return
     */
    @GetMapping("getAllCart")
    public DataVo getAllCart(HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user==null){
            DataVo dataVo=new DataVo();
            dataVo.setCode(404);
            return dataVo;
        }
        return this.cartService.getAllCart(user.getId());
    }

    /**
     * 通过商品id和用户openid查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Cart selectOne(Integer id) {
        return this.cartService.queryById(id);
    }
    /**
     * 通过商品id和用户openid查询单条数据
     *
     * @return 单条数据
     */
    /**
     * 添加到购物车
     * @param issuesId
     * @param num
     * @return
     */
    @GetMapping("insert")
    public Cart insertOrUpdata(  Integer issuesId, Integer num, HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user==null){
            return null;
        }
        Cart cart = new Cart(user.getId(), issuesId, num, new Date());
        return this.cartService.insert(cart);
    }
    /**
     * 删除该购物车项
     * @param id
     */
    @GetMapping("delete")
    public void delete(Integer id) {
        this.cartService.deleteById(id);
    }


}