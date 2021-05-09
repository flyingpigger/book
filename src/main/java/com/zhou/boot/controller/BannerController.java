package com.zhou.boot.controller;

import com.zhou.boot.domain.Banner;
import com.zhou.boot.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class BannerController {

    @Autowired
    BannerService bannerService;

    @ResponseBody
    @RequestMapping("/banner")
    public List<Banner> getBanner() {
        List<Banner> banners = bannerService.list();
        return banners;
    }
}
