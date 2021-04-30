package com.zhou.boot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhou.boot.domain.Banner;
import com.zhou.boot.service.BannerService;
import com.zhou.boot.mapper.BannerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class BannerServiceImpl extends ServiceImpl<BannerMapper, Banner>
implements BannerService{
}




