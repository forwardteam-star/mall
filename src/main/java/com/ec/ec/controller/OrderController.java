package com.ec.ec.controller;

import com.ec.ec.Vo.CartVo;
import com.ec.ec.Vo.OrderVo;
import com.ec.ec.entity.*;
import com.ec.ec.service.CartService;
import com.ec.ec.service.IssuesService;
import com.ec.ec.service.ItemService;
import com.ec.ec.service.OrderService;
import com.ec.ec.util.Util;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@RestController
@CrossOrigin(allowCredentials="true",allowedHeaders="*")
@RequestMapping("order")
public class OrderController {
    /**
     * 服务对象
     */
    @Resource
    private OrderService orderService;

    @Resource
    private CartService cartService;

    @Resource
    private IssuesService issuesService;
    @Resource
    private ItemService itemService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Order selectOne(Integer id) {
        return this.orderService.queryById(id);
    }

    /**
     * 把当前商品从购物车删除，并且生成订单和订单项
     * @return
     */
    @GetMapping("CreateOrder")
    public OrderVo CreateOrder(String[] cardId, HttpServletRequest request,String name,String address,String phone) {

        System.out.println(cardId);
        double total=0.00;
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user==null){
            return null;
        }
        Long orderNum= Long.valueOf(Util.getOrderIdByTime());
        System.out.println("订单号："+orderNum);
        List<CartVo> cartVos=new ArrayList<>();
        cardId[0]=cardId[0].replace("[","");
        cardId[cardId.length-1]=cardId[cardId.length-1].replace("]","");
        for (String j:cardId  ) {
            int i= Integer.parseInt(j);
            Cart cart=cartService.queryById(i);
            cartService.deleteById(i);
            Issues issues=issuesService.queryById(cart.getIssuesId());

            Item item=new Item(orderNum,user.getId(),cart.getIssuesId(),cart.getNum(), Util.encode(address), cart.getNum()*issues.getIssuesPrice(), "确认收货",  new Date());
            total+= cart.getNum()*issues.getIssuesPrice();

            itemService.insert(item);
            CartVo cartVo=new CartVo(issues);
            cartVo.setId(cart.getId());
            cartVo.setNum(cart.getNum());
            cartVos.add(cartVo);
        }
        Order order=new Order( orderNum,  user.getId(),  total,  user.getAddress(),  new Date(), "确认收货");
        orderService.insert(order);
        OrderVo orderVo=new OrderVo(cartVos,orderNum);
        return orderVo;

    }


    /**
     * 订单结账
     * @param orderNum
     * @return
     */
    @GetMapping("Bill")
    public String Bill(String orderNum) {
        return this.orderService.Bill(orderNum);
    }
    @GetMapping("deleteById")
    public void deleteById(long id) {
         this.orderService.deleteById(id);
    }


}