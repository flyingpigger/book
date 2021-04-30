package com.zhou.boot.mapper;

import com.zhou.boot.domain.Cart;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhou.boot.domain.CartInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface CartMapper extends BaseMapper<Cart> {

    @Select("SELECT uid,bid,count,checked,title,img_url,price,description " +
            "FROM cart,book " +
            "WHERE cart.uid=#{uid} and cart.bid=book.id")
    List<CartInfo> selectAllByUserID(Integer uid);

    @Update("UPDATE cart SET count=count+1 WHERE bid=#{bid}")
    int addCount(int bid);

    @Insert("INSERT INTO cart VALUES(null,#{uid},#{bid},1,0)")
    int addItem(int bid, int uid);

    @Update("UPDATE cart SET checked=#{checked} WHERE bid=#{bid}")
    int setChecked(int bid, boolean checked);

    @Update("UPDATE cart SET checked=#{checked} WHERE uid=#{uid}")
    int setAllChecked(int uid, boolean checked);
}




