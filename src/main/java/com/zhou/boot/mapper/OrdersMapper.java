package com.zhou.boot.mapper;

import com.zhou.boot.domain.Orders;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @Entity com.zhou.boot.domain.Orders
 */
public interface OrdersMapper extends BaseMapper<Orders> {

    @Select("SELECT * FROM orders WHERE uid=#{uid}")
    List<Orders> listByUid(Integer uid);

    @Update("UPDATE orders SET is_paid=1 WHERE id=#{oid}")
    int orderPaid(int oid);

    @Update("UPDATE orders SET is_delivered=1 WHERE id=#{oid}")
    int orderDelivered(int oid);

    @Update("UPDATE orders SET is_received=1 WHERE id=#{oid}")
    int orderReceived(int oid);

    @Select("SELECT * FROM orders WHERE is_delivered=0 AND is_paid=1")
    List<Orders> getPaidOrder();

    @Select("SELECT * FROM orders WHERE is_delivered=1 AND is_received=0")
    List<Orders> getDeliveredOrder();

    @Select("SELECT * FROM orders WHERE is_received=1")
    List<Orders> getReceivedOrder();

}




