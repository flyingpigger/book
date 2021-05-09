package com.zhou.boot.service;

import com.zhou.boot.domain.Orders;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 *
 */
public interface OrdersService extends IService<Orders> {

    List<Orders> listByUid(Integer uid);

    boolean orderPaid(int oid);

    boolean orderDelivered(int oid);

    boolean orderReceived(int oid);

    List<Orders> getPaidOrder();

    List<Orders> getDeliveredOrder();

    List<Orders> getReceivedOrder();

}