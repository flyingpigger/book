package com.zhou.boot.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhou.boot.domain.Book;
import com.zhou.boot.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Slf4j
@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @ResponseBody
    @RequestMapping("/books")
    public List<Book> getBooksByType(@RequestParam(value = "type", defaultValue = "教育") String type,
                                     @RequestParam(value = "pn", defaultValue = "1") Integer pn) {

        Page<Book> bookPage = new Page<>(pn, 10);
        IPage<Book> page = bookService.selectBookByTypePage(bookPage, type);

        log.info("获得请求/books");
        return page.getRecords();
    }

    @ResponseBody
    @RequestMapping("/allBooks/{page}")
    public List<Book> getAllBooks(@PathVariable("page") Integer page) {
        Page<Book> bookPage = new Page<>(page, 10);
        Page<Book> page1 = bookService.page(bookPage);

        return page1.getRecords();
    }

    @ResponseBody
    @RequestMapping("/book")
    public Book getBookById(@RequestParam(value = "id", defaultValue = "1") Integer id) {

        Book book = bookService.getById(id);

        log.info("获得请求/book");
        return book;
    }
}
