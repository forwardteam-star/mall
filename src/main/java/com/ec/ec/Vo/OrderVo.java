package com.ec.ec.Vo;

import lombok.Data;

import java.util.List;

/**
 **/
@Data
public class OrderVo {
    private List<CartVo> cartVos;
    private long orderNum;

    public OrderVo() {
    }

    public OrderVo(List<CartVo> cartVos, long orderNum) {
        this.cartVos = cartVos;
        this.orderNum = orderNum;
    }
}
