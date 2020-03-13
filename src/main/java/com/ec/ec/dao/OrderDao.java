package com.ec.ec.dao;

import com.ec.ec.entity.Order;
import com.ec.ec.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * (Order)表数据库访问层
 *
 */
public interface OrderDao extends JpaRepository<Order, Long> {

}