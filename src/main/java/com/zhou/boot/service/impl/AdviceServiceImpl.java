package com.zhou.boot.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zhou.boot.domain.Cart;
import com.zhou.boot.domain.Orders;
import com.zhou.boot.mapper.BookMapper;
import com.zhou.boot.mapper.CartMapper;
import com.zhou.boot.mapper.OrdersMapper;
import com.zhou.boot.service.AdviceService;
import com.zhou.boot.utils.BookCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;

@Service
public class AdviceServiceImpl implements AdviceService {

    @Autowired
    OrdersMapper ordersMapper;
    @Autowired
    CartMapper cartMapper;
    @Autowired
    BookMapper bookMapper;

    @Override
    public JSONArray adviceBooks() {
        List<Orders> orders = ordersMapper.listAll();
        List<Cart> carts = cartMapper.listAll();

        DecimalFormat df = new DecimalFormat("0.00");
        df.setRoundingMode(RoundingMode.HALF_UP);

        //订单中物品的权值
        Double orderWeight = 0.7;
        //购物车中物品的权值
        Double cartWeight = 0.3;

        HashSet<Integer> bookIdSet = new HashSet<>();
        HashMap<Integer, Double> bookCountMap= new HashMap<>();

//处理订单中的数据
for (Orders order:orders) {
    //取出订单中的书籍列表字符串
    String bookList = order.getBookList();
    //将字符串转化为JSON数组对象
    JSONArray objects = JSON.parseArray(bookList);
    for (Object item : objects) {
        //只取出书籍列表中的书籍ID和购买数量信息
        BookCount bookCount = JSON.parseObject(item.toString(), BookCount.class);
        Integer bid = bookCount.getBid();
        Integer count = bookCount.getCount();
        //将书籍ID和其对应的数量进行加权计算并存储到HashMap中
        if (! bookIdSet.contains(bid)) {
            bookIdSet.add(bid);
            bookCountMap.put(bid, count * orderWeight);
        } else {
            Double oldPoint = bookCountMap.get(bid);
            Double newPoint = oldPoint + count * orderWeight;
            bookCountMap.put(bid, newPoint);
        }
    }
}
//处理购物车中的数据
for (Cart cart : carts) {
    //取出购物车中的书籍ID和在购物车的数量信息
    Integer bid = cart.getBid();
    Integer count = cart.getCount();
    //将书籍ID和其对应的数量进行加权计算并存储到HashMap中
    if (! bookIdSet.contains(bid)) {
        bookIdSet.add(bid);
        bookCountMap.put(bid, count * cartWeight);
    } else {
        Double oldPoint = bookCountMap.get(bid);
        Double newPoint = (oldPoint + count * cartWeight) ;
        bookCountMap.put(bid, newPoint);
    }
}

List<Map.Entry<Integer, Double>> listEntry = new ArrayList<>(bookCountMap.entrySet());
listEntry.sort(new Comparator<Map.Entry<Integer, Double>>() {
    @Override
    public int compare(Map.Entry<Integer, Double> o1, Map.Entry<Integer, Double> o2) {

        // String的compareTo方法，返回负数，说明o1在o2的字典顺序之前。
        return o2.getValue().compareTo(o1.getValue());
    }
});

        JSONArray ranks = new JSONArray();

        int i = 1;
        for(Map.Entry<Integer, Double> entry : listEntry) {
            JSONObject rank = new JSONObject(true);
            Integer key = entry.getKey();
            Double value = entry.getValue();
            String title = bookMapper.selectBookNameById(key);
            rank.put("title", title);
            rank.put("value", df.format(value));
            rank.put("rank", i++);
            ranks.add(rank);
        }

        return ranks;
    }
}
