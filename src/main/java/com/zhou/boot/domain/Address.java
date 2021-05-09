package com.zhou.boot.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 收货人地址
 * @TableName address
 */
@TableName(value ="address")
@Data
public class Address implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 收货人姓名
     */
    private String name;

    /**
     * 用户ID
     */
    private Integer uid;

    /**
     * 详细地址
     */
    private String addressDetail;

    /**
     * 城市
     */
    private String city;

    /**
     * 区县
     */
    private String county;

    /**
     * 省份
     */
    private String province;

    /**
     * 邮政编码
     */
    private String postalCode;

    /**
     * 地区编码，通过 省市区选择 获取
     */
    private String areaCode;

    /**
     * 收货人手机号
     */
    private String tel;

    /**
     * 是否为默认收货地址，1为是，0或空为否
     */
    private Boolean isDefault;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}