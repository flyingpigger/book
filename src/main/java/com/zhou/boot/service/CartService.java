package com.zhou.boot.service;

import com.zhou.boot.domain.Cart;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zhou.boot.domain.CartInfo;

import java.util.List;

/**
 *
 */
public interface CartService extends IService<Cart> {

    List<CartInfo> selectAllByUserID(Integer uid);

    boolean addCount(int bid);
    boolean addItem(int bid, int uid);
    boolean setChecked(int bid, boolean checked);
    boolean setAllChecked(int uid, boolean checked);
}
