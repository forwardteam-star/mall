package com.ec.ec.service;

import com.ec.ec.Vo.DataVo;
import com.ec.ec.entity.Cart;

/**
 * (Cart)表服务接口
 *
 */
public interface CartService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Cart queryById(long id);


    DataVo getAllCart(long openId);

    /**
     * 新增数据
     *
     * @param cart 实例对象
     * @return 实例对象
     */
    Cart insert(Cart cart);


    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    void deleteById(long id);

}