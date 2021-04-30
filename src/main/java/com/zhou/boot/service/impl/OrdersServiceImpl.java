package com.zhou.boot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhou.boot.domain.Orders;
import com.zhou.boot.service.OrdersService;
import com.zhou.boot.mapper.OrdersMapper;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders>
implements OrdersService{

}




