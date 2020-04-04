package com.ec.ec.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ec.ec.dao.OrderDao;
import com.ec.ec.entity.Order;
import com.ec.ec.service.OrderService;

/**
 * (Order)表服务实现类
 *
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderDao orderDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Order queryById(long id) {
        return this.orderDao.getOne(id);
    }

    @Override
    public String Bill(String orderNum) {
        return null;
    }

    /**
     * 新增数据
     *
     * @param order 实例对象
     * @return 实例对象
     */
    @Override
    public Order insert(Order order) {
        this.orderDao.save(order);
        return order;
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public void deleteById(long id) {
        this.orderDao.deleteById(id);
    }
}