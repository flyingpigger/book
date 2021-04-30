package com.zhou.boot.domain;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class CartInfo implements Serializable {

    /**
     * 用户ID
     */
    private Integer uid;

    /**
     * 书籍ID
     */
    private Integer bid;

    /**
     * 书籍数量
     */
    private Integer count;

    /**
     * 是否选中
     */
    private Boolean checked;

    private String title;
    private String imgUrl;
    private BigDecimal price;
    private String description;

}
