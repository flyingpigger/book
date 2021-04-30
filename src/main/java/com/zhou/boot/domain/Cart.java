package com.zhou.boot.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 购物车
 * @TableName cart
 */
@TableName(value ="cart")
@Data
public class Cart implements Serializable {
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
     * 书籍数量
     */
    private Integer count;

    /**
     * 
     */
    private Boolean checked;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}