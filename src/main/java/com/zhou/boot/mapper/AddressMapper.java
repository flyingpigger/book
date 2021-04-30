package com.zhou.boot.mapper;

import com.zhou.boot.domain.Address;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Entity com.zhou.boot.domain.Address
 */
@Mapper
public interface AddressMapper extends BaseMapper<Address> {

    @Select("SELECT * FROM address WHERE uid=#{uid}")
    List<Address> selectAllByUserID(Integer uid);

}




