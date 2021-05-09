package com.zhou.boot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhou.boot.domain.Orders;
import com.zhou.boot.service.OrdersService;
import com.zhou.boot.mapper.OrdersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service

public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders>
implements OrdersService{
    @Autowired
    OrdersMapper ordersMapper;

    @Override
    public List<Orders> listByUid(Integer uid) {
        return ordersMapper.listByUid(uid);
    }

    @Override
    public boolean orderPaid(int oid) {
        return ordersMapper.orderPaid(oid) == 1;
    }

    @Override
    public boolean orderDelivered(int oid) {
        return ordersMapper.orderDelivered(oid) == 1;
    }

    @Override
    public boolean orderReceived(int oid) {
        return ordersMapper.orderReceived(oid) == 1;
    }

    @Override
    public List<Orders> getPaidOrder() {
        return ordersMapper.getPaidOrder();
    }

    @Override
    public List<Orders> getDeliveredOrder() {
        return ordersMapper.getDeliveredOrder();
    }

    @Override
    public List<Orders> getReceivedOrder() {
        return ordersMapper.getReceivedOrder();
    }
}