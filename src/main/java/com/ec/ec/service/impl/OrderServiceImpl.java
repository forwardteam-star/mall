package com.ec.ec.service.impl;

import com.ec.ec.Vo.DataVo;
import com.ec.ec.dao.ItemDao;
import com.ec.ec.dao.OrderDao;
import com.ec.ec.entity.Item;
import com.ec.ec.entity.Order;
import com.ec.ec.entity.User;
import com.ec.ec.service.OrderService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Order)表服务实现类
 *
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderDao orderDao;
    @Resource
    private ItemDao itemDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Order queryById(long id) {
//        return this.orderDao.getOne(id);
        return this.orderDao.getOne(id);
    }

    @Override
    public String Bill(String orderNum) {
//        System.out.println("********************"+orderNum);
//        Order order= orderDao.queryByOrdernum(orderNum);
//        order.setOrderType("等待发货");
//        orderDao.update(order);
//        List<Item> items= itemDao.getAllItemByOrdernum(orderNum);
//        for (Item item:items){
//            item.setItemType("等待发货");
//            itemDao.update(item);
//        }
//        return orderNum;
        return null;
    }

    /**
     * 查询多条数据
     *
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public DataVo queryAllByLimit(int page, int limit) {
//        return this.orderDao.queryAllByLimit(offset, limit);
        PageRequest pageReques=PageRequest.of(page-1,limit);   //获取第1页的两条记录
        Page<Order> articleList = orderDao.findAll(pageReques);
        DataVo objson = new DataVo();
        objson.setData(articleList.getContent());
        objson.setTotal(orderDao.findAll().size());
        objson.setCode(0);
        return objson;
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
     * 修改数据
     *
     * @param order 实例对象
     * @return 实例对象
     */
    @Override
    public Order update(Order order) {
        this.orderDao.saveAndFlush(order);
        return this.queryById(order.getId());
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