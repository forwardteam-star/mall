package com.ec.ec.dao;

import com.ec.ec.entity.Item;
import com.ec.ec.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * (Item)表数据库访问层
 */
public interface ItemDao extends JpaRepository<Item, Long> {
    List<Item> findByOpenId(long id);

}