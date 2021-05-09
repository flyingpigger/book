package com.zhou.boot.mapper;

import com.zhou.boot.domain.Cart;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhou.boot.domain.CartInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CartMapper extends BaseMapper<Cart> {

    @Select("SELECT uid,bid,count,checked,title,img_url,price,description " +
            "FROM cart,book " +
            "WHERE cart.uid=#{uid} and cart.bid=book.id")
    List<CartInfo> selectAllByUserID(Integer uid);

    @Update("UPDATE cart SET count=count+1 WHERE bid=#{bid} AND uid=#{uid}")
    int addCount(int bid, int uid);

    @Update("UPDATE cart SET count=count-1 WHERE bid=#{bid} AND uid=#{uid}")
    int minusCount(int bid, int uid);

    @Insert("INSERT INTO cart VALUES(null,#{uid},#{bid},1,0)")
    int addItem(int bid, int uid);

    @Delete("DELETE FROM cart WHERE uid=#{uid} AND bid=#{bid}")
    int deleteItem(int bid, int uid);

    @Update("UPDATE cart SET checked=#{checked} WHERE bid=#{bid} AND uid=#{uid}")
    int setChecked(int bid, boolean checked, int uid);

    @Update("UPDATE cart SET checked=#{checked} WHERE uid=#{uid}")
    int setAllChecked(int uid, boolean checked);
}




