package com.ec.ec.service;

import com.ec.ec.Vo.DataVo;
import com.ec.ec.entity.Order;

import java.util.List;

/**
 * (Order)表服务接口
 *
 */
public interface OrderService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Order queryById(long id);

    String Bill(String orderNum);

    /**
     * 新增数据
     *
     * @param order 实例对象
     * @return 实例对象
     */
    Order insert(Order order);


    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    void deleteById(long id);

}