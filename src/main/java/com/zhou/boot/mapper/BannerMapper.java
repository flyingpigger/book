package com.zhou.boot.mapper;

import com.zhou.boot.domain.Banner;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Entity com.zhou.boot.domain.Banner
 */
@Mapper
public interface BannerMapper extends BaseMapper<Banner> {

    @Select("SELECT * FROM banner")
    List<Banner> selectAllMapper();
}




