package com.ec.ec.dao;

import com.ec.ec.entity.Cart;
import com.ec.ec.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * (Cart)表数据库访问层
 *
 */
public interface CartDao extends JpaRepository<Cart, Long> {
    List<Cart> findByOpenId(long id);

    @Query(value = "select\n" +
            "          id, open_id, issues_id, num, date\n" +
            "        from issues.cart\n" +
            "        where\n" +
            "        open_id = :openId\n" +
            "        and\n" +
            "        issues_id=:issuesId", nativeQuery = true)
    List<Cart> isExist(long openId, long issuesId);

}