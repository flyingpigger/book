package com.zhou.boot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhou.boot.domain.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Entity com.zhou.boot.domain.Book
 */
@Mapper
public interface BookMapper extends BaseMapper<Book> {

    @Select("SELECT * FROM book WHERE type=#{type}")
    IPage<Book> selectPageVo(Page<?> page, String type);

    @Select("SELECT book.title FROM book WHERE id=#{bid}")
    String selectBookNameById(Integer bid);

    @Select("SELECT * FROM book WHERE title LIKE '%${keyWord}%'")
    List<Book> searchBook(String keyWord);

}




