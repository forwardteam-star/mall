package com.ec.ec.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * (Order)实体类
 *
 */
@Entity
@Data
@Table(name = "order_")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    //订单号
    private long orderNum;
    //
    private long openId;
    //总价
    private Double orderPrice;
    //地址
    private String orderAddress;
    //时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date orderDate;
    //状态
    private String orderType;

    public Order() {
    }

    public Order( long orderNum, long openId, Double orderPrice, String orderAddress, Date orderDate, String orderType) {

        this.orderNum = orderNum;
        this.openId = openId;
        this.orderPrice = orderPrice;
        this.orderAddress = orderAddress;
        this.orderDate = orderDate;
        this.orderType = orderType;
    }

}