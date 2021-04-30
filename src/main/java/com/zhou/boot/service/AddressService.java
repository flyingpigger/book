package com.zhou.boot.service;

import com.zhou.boot.domain.Address;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 *
 */
public interface AddressService extends IService<Address> {

    List<Address> selectAllByUserID(Integer uid);

}
