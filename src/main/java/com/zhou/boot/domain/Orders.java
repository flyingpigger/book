package com.zhou.boot.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * 订单
 * @TableName orders
 */
@TableName(value ="orders")
@Data
public class Orders implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 用户ID
     */
    private Integer uid;

    /**
     * 书籍名称
     */
    private String bookList;

    /**
     * 总价
     */
    private BigDecimal totalPrice;

    /**
     * 是否发货，1为发货，0为未发货
     */
    private Boolean isDelivered;

    /**
     * 是否支付，1为支付，0为未支付
     */
    private Boolean isPaid;

    /**
     * 是否收货，1为收货，0为未收货
     */
    private Boolean isReceived;

    /**
     * 地址
     */
    private String address;

    /**
     * 电话号码
     */
    private String tel;

    /**
     * 收货人
     */
    private String name;

    /**
     * 日期
     */
    private String date;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}