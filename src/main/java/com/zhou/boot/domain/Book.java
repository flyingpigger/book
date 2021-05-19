package com.zhou.boot.domain;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * 书籍信息
 * @TableName book
 */
@TableName(value ="book")
@Data
public class Book implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    @JSONField(name = "bid")
    private Integer id;

    /**
     * 标题
     */
    private String title;

    /**
     * 描述
     */
    private String description;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 类型
     */
    private String type;

    /**
     * 商品图片链接
     */
    private String imgUrl;

    /**
     * 详细信息链接
     */
    private String detailUrl;

    /**
     * 作者
     */
    private String author;

    /**
     * 出版社
     */
    private String publisher;


    /**
     * 出版日期
     */
    private String publishDate;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}