package com.zhou.boot.mapper;

import com.zhou.boot.domain.Address;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @Entity com.zhou.boot.domain.Address
 */
@Mapper
public interface AddressMapper extends BaseMapper<Address> {

    @Select("SELECT * FROM address WHERE uid=#{uid}")
    List<Address> selectAllByUserID(Integer uid);

    @Update("UPDATE address SET is_default=false WHERE uid=#{uid}")
    int setFalse(int uid);

    @Select("SELECT * FROM address WHERE uid=#{uid} AND is_default=1")
    Address getByUid(int uid);
}




