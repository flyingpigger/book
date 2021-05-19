package com.zhou.boot.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhou.boot.domain.Book;
import com.zhou.boot.service.BookService;
import com.zhou.boot.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book>
implements BookService{

    @Autowired
    private BookMapper bookMapper;

    @Override
    public IPage<Book> selectBookByTypePage(Page<Book> page, String type) {
        // 不进行 count sql 优化，解决 MP 无法自动优化 SQL 问题，这时候你需要自己查询 count 部分
        // page.setOptimizeCountSql(false);
        // 当 total 为小于 0 或者设置 setSearchCount(false) 分页插件不会进行 count 查询
        // 要点!! 分页返回的对象与传入的对象是同一个
        return bookMapper.selectPageVo(page, type);
    }

    @Override
    public List<Book> searchBook(String keyWord) {
        return bookMapper.searchBook(keyWord);
    }

}




