package com.zhou.boot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhou.boot.domain.Cart;
import com.zhou.boot.domain.CartInfo;
import com.zhou.boot.service.CartService;
import com.zhou.boot.mapper.CartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class CartServiceImpl extends ServiceImpl<CartMapper, Cart>
        implements CartService {

    @Autowired
    CartMapper cartMapper;

    @Override
    public List<CartInfo> selectAllByUserID(Integer uid) {
        return cartMapper.selectAllByUserID(uid);
    }

    @Override
    public boolean addCount(int bid, int uid) {
        int result = cartMapper.addCount(bid, uid);
        return result == 1;
    }

    @Override
    public boolean minusCount(int bid, int uid) {
        int result = cartMapper.minusCount(bid, uid);
        return result == 1;
    }

    @Override
    public boolean addItem(int bid, int uid) {
        int result = cartMapper.addItem(bid, uid);
        return result == 1;
    }

    @Override
    public boolean deleteItem(int bid, int uid) {
        int result = cartMapper.deleteItem(bid, uid);
        return result == 1;
    }

    @Override
    public boolean setChecked(int bid, boolean checked, int uid) {
        int result = cartMapper.setChecked(bid, checked, uid);
        return result == 1;
    }

    @Override
    public boolean setAllChecked(int uid, boolean checked) {
        int result = cartMapper.setAllChecked(uid, checked);
        return result >= 1;
    }
}




