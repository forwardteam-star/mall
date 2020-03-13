package com.ec.ec.dao;

import com.ec.ec.entity.Admin;
import com.ec.ec.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * (Admin)表数据库访问层
 */
public interface AdminDao extends JpaRepository<Admin, Long> {
    List<Admin> findByTeleAndPassword(String phone,String password);

}