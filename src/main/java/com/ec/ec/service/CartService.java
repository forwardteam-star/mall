package com.ec.ec.service;

import com.ec.ec.Vo.CartVo;
import com.ec.ec.Vo.DataVo;
import com.ec.ec.entity.Cart;

import java.util.List;

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

    /**
     * 查询购物车库存
     * @param issuesId
     * @param openId
     * @return
     */
//    Integer getStock(Integer issuesId, long openId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    DataVo queryAllByLimit(int page, int limit);


    DataVo getAllCart(long openId);

    /**
     * 新增数据
     *
     * @param cart 实例对象
     * @return 实例对象
     */
    Cart insert(Cart cart);

    /**
     * 修改数据
     *
     * @param cart 实例对象
     * @return 实例对象
     */
    Cart update(Cart cart);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    void deleteById(long id);

}