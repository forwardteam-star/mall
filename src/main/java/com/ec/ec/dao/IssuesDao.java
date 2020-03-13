package com.ec.ec.dao;

import com.ec.ec.entity.Issues;
import com.ec.ec.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * (Issues)表数据库访问层
 */
public interface IssuesDao extends JpaRepository<Issues, Long> {
    List<Issues> findByIssuesNameLike(String name);
}