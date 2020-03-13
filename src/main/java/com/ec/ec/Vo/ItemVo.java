package com.ec.ec.Vo;

import com.ec.ec.entity.Issues;
import com.ec.ec.entity.Item;
import lombok.Data;

/**
 **/
@Data
public class ItemVo {
    //订单id
    private long itemId;
    //订单号
    private long orderNum;
    //商品名称
    private String issuesName;
    //图url
    private String issuesUrl;
    //商品数量
    private Integer itemNum;
    //价格
    private Double itemPrice;
    //付款状态
    private String itemType;
    //商品id
    private long issuesId;

    public ItemVo() {
    }


    public ItemVo(Item item, Issues issues) {
        this.itemId=item.getId();
        this.orderNum = item.getOrderNum();
        this.issuesName = issues.getIssuesName();
        this.issuesUrl = issues.getIssuesUrl();
        this.itemNum = item.getItemNum();
        this.itemPrice = item.getItemPrice();
        this.itemType = item.getItemType();
        this.issuesId = item.getIssuesId();
    }
}
