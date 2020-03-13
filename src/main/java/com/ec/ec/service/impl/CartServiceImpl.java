package com.ec.ec.service.impl;

import com.ec.ec.Vo.CartVo;
import com.ec.ec.Vo.DataVo;
import com.ec.ec.dao.CartDao;
import com.ec.ec.dao.IssuesDao;
import com.ec.ec.entity.Cart;
import com.ec.ec.entity.Issues;
import com.ec.ec.service.CartService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

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

//    @Override
//    public Integer getStock(Integer issuesId, long openId) {
//        return cartDao.getStock(openId,issuesId);
//    }

    /**
     * 查询多条数据
     *
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public DataVo queryAllByLimit(int page, int limit) {
        PageRequest pageReques=PageRequest.of(page-1,limit);   //获取第1页的两条记录
        Page<Cart> articleList = cartDao.findAll(pageReques);
        DataVo objson = new DataVo();
        objson.setData(articleList.getContent());
        objson.setTotal(issuesDao.findAll().size());
        objson.setCode(0);
        return objson;
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
     * 修改数据
     *
     * @param cart 实例对象
     * @return 实例对象
     */
    @Override
    public Cart update(Cart cart) {
        this.cartDao.saveAndFlush(cart);
        return this.queryById(cart.getId());
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