package com.zhou.boot.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhou.boot.api.CommonResult;
import com.zhou.boot.domain.Banner;
import com.zhou.boot.domain.Book;
import com.zhou.boot.domain.Category;
import com.zhou.boot.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @Autowired
    BannerService bannerService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    AdviceService adviceService;

    @ResponseBody
    @GetMapping("/category")
    public List<Category> getCategory() {
        return categoryService.list();
    }

    @ResponseBody
    @RequestMapping("/banner")
    public List<Banner> getBanner() {
        List<Banner> banners = bannerService.list();
        return banners;
    }

    @ResponseBody
    @RequestMapping("/books")
    public List<Book> getBooksByType(@RequestParam(value = "type", defaultValue = "教育") String type,
                                     @RequestParam(value = "pn", defaultValue = "1") Integer pn) {

        Page<Book> bookPage = new Page<>(pn, 10);
        IPage<Book> page = bookService.selectBookByTypePage(bookPage, type);

        return page.getRecords();
    }

    @ResponseBody
    @RequestMapping("/allBooks/{page}")
    public JSONObject getAllBooks(@PathVariable("page") Integer page) {
        Page<Book> bookPage = new Page<>(page, 10);
        Page<Book> pages = bookService.page(bookPage);

        JSONObject object = new JSONObject();
        object.put("data",pages.getRecords());
        object.put("total", pages.getTotal());
        return object;
    }

    @ResponseBody
    @RequestMapping("/book")
    public Book getBookById(@RequestParam(value = "id", defaultValue = "1") Integer id) {

        return bookService.getById(id);
    }

    @ResponseBody
    @RequestMapping("/searchBook")
    public List<Book> searchBook(@RequestParam(value = "keyWord", defaultValue = "") String keyWord) {

        return bookService.searchBook(keyWord);
    }

    @DeleteMapping("/deleteBook")
    public CommonResult deleteBook(@RequestBody Book book) {
        boolean result = bookService.removeById(book);
        if (result) {
            return CommonResult.success("success");
        } else {
            return CommonResult.failed("failed");
        }
    }

    @PutMapping("/editBook")
    public CommonResult editBook(@RequestBody Book book) {
        boolean result = bookService.updateById(book);
        if (result) {
            return CommonResult.success("success");
        } else {
            return CommonResult.failed("failed");
        }
    }
}
