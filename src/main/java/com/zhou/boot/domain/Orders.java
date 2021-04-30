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
     * 书籍ID
     */
    private Integer bid;

    /**
     * 书籍名称
     */
    private String bookName;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 数量
     */
    private Integer amount;

    /**
     * 总价
     */
    private BigDecimal total;

    /**
     * 是否发货，1为发货，0为未发货
     */
    private Integer isDelivered;

    /**
     * 是否收货，1为收货，0为未收货
     */
    private Integer isReceived;

    /**
     * 地址
     */
    private String address;

    /**
     * 电话号码
     */
    private String phone;

    /**
     * 收货人
     */
    private String consignee;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}