package com.zhou.boot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhou.boot.domain.Address;
import com.zhou.boot.service.AddressService;
import com.zhou.boot.mapper.AddressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class AddressServiceImpl extends ServiceImpl<AddressMapper, Address>
implements AddressService{

    @Autowired
    AddressMapper addressMapper;

    @Override
    public List<Address> selectAllByUserID(Integer uid) {
        return addressMapper.selectAllByUserID(uid);
    }
}




