package com.zhou.boot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhou.boot.domain.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @Entity com.zhou.boot.domain.Book
 */
@Mapper
public interface BookMapper extends BaseMapper<Book> {

    @Select("SELECT * FROM book WHERE type=#{type}")
    IPage<Book> selectPageVo(Page<?> page, String type);

}




