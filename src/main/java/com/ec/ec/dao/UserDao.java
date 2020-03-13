package com.ec.ec.dao;


import com.ec.ec.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * (User)表数据库访问层
 */
public interface UserDao extends JpaRepository<User, Long> {
    User findByPhone(String phone);
    User findByPhoneAndPassword(String phone,String password);

}