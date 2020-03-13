package com.ec.ec.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * (Item)实体类
 *
 */
@Entity
@Data
public class Item implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    //订单号
    private long orderNum;
    //
    private long openId;
    //商品id
    private long issuesId;
    //商品数量
    private Integer itemNum;
    //收货地址
    private String itemAddress;
    //订单价格
    private Double itemPrice;
    //订单状态
    private String itemType;
    //创建时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date itemDate;
    //商品名
    private String IssuesName;

    public Item() {
    }

    public Item( long orderNum, long openId, long issuesId, Integer itemNum, String itemAddress, Double itemPrice, String itemType, Date itemDate) {
        this.orderNum = orderNum;
        this.openId = openId;
        this.issuesId = issuesId;
        this.itemNum = itemNum;
        this.itemAddress = itemAddress;
        this.itemPrice = itemPrice;
        this.itemType = itemType;
        this.itemDate = itemDate;
    }


}