package com.zhou.boot.mapper;

import com.zhou.boot.domain.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
/**
 * @Entity com.zhou.boot.domain.User
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Select("SELECT COUNT(*) FROM user WHERE username=#{user.username} and password=#{user.password}")
    int userCount(@Param("user") User user);

    @Select("SELECT id FROM user WHERE username=#{username}")
    Integer getUserIdByName(String username);

}




