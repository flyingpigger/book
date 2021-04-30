package com.zhou.boot.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhou.boot.domain.Book;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 *
 */
public interface BookService extends IService<Book> {

    IPage<Book> selectBookByTypePage(Page<Book> page, String type);

}
