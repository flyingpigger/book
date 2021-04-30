package com.zhou.boot.controller;

import com.zhou.boot.domain.Address;
import com.zhou.boot.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class AddressController {

    @Autowired
    AddressService addressService;

    @ResponseBody
    @PostMapping("/profile/address")
    public void postAddress(@RequestBody Address address, HttpServletRequest request) {
        addressService.save(address);
    }

}
