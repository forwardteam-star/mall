package com.ec.ec.Vo;

import com.ec.ec.entity.Issues;
import lombok.Data;

@Data
public class CartVo {
    //购物车项id
    private long id;
    //商品标题
    private String title;
    //商品图片地址
    private String image;
    //数量
    private Integer num;
    //价格
    private double price;
    //是否选中
    private boolean selected;
    //商品id
    private long issuesId;

    public CartVo() {
    }
    public CartVo(Issues issues) {
        //id,num
        this.title = issues.getIssuesName();
        this.image = issues.getIssuesUrl();
        this.price = issues.getIssuesPrice();
        this.selected = false;
        this.issuesId = issues.getId();
    }

    public CartVo(Integer id, String title, String image, Integer num, double price, boolean selected, Integer issuesId) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.num = num;
        this.price = price;
        this.selected = selected;
        this.issuesId = issuesId;
    }

}
