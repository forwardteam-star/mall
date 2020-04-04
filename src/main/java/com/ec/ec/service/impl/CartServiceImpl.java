package com.ec.ec.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ec.ec.Vo.CartVo;
import com.ec.ec.Vo.DataVo;
import com.ec.ec.dao.CartDao;
import com.ec.ec.dao.IssuesDao;
import com.ec.ec.entity.Cart;
import com.ec.ec.entity.Issues;
import com.ec.ec.service.CartService;

/**
 * (Cart)表服务实现类
 *
 */
@Service("cartService")
public class CartServiceImpl implements CartService {
    @Resource
    private CartDao cartDao;
    @Resource
    private IssuesDao issuesDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Cart queryById(long id) {
        return this.cartDao.getOne(id);
    }


    @Override
    public DataVo getAllCart(long openId) {
        List<Cart> carts=cartDao.findByOpenId(openId);
        List<CartVo> cartVos=new ArrayList<>();
        for (Cart cart:carts
             ) {
            //先通过id查询商品详情，然后把
            Issues issues=issuesDao.getOne(cart.getIssuesId());
            CartVo cartVo=new CartVo(issues);
            cartVo.setId(cart.getId());
            cartVo.setNum(cart.getNum());
            cartVos.add(cartVo);
        }
        DataVo dataVo=new DataVo();
        dataVo.setData(cartVos);
        dataVo.setTotal(cartVos.size());
        return dataVo;
    }

    /**
     * 新增数据
     *
     * @param cart 实例对象
     * @return 实例对象
     */
    @Override
    public Cart insert(Cart cart) {
        //如果有一个对象商品id和用户id都相等则num++
        if (cartDao.isExist(cart.getOpenId(),cart.getIssuesId()).size()==1){
            cart.setNum(cart.getNum()+1);
            this.cartDao.saveAndFlush(cart);
        }else {
            this.cartDao.save(cart);
        }
        return cart;
    }
    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public void deleteById(long id) {
        this.cartDao.deleteById(id);
    }
}