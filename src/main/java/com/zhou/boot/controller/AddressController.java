package com.zhou.boot.controller;

import com.zhou.boot.api.CommonResult;
import com.zhou.boot.domain.Address;
import com.zhou.boot.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class AddressController {

    @Autowired
    AddressService addressService;

    @ResponseBody
    @GetMapping("/profile/addressList")
    public List<Address> getAddress(@RequestParam(value = "uid", defaultValue = "") int uid) {
        return addressService.selectAllByUserID(uid);
    }

    @ResponseBody
    @PostMapping("/profile/addAddress")
    public CommonResult addAddress(@RequestBody Address address) {
        boolean result = addressService.save(address);
        if (result) {
            return CommonResult.success("success");
        } else {
            return CommonResult.failed("failed");
        }
    }

    @ResponseBody
    @PutMapping("/profile/editAddress")
    public CommonResult editAddress(@RequestBody Address address) {
        boolean result = addressService.updateById(address);
        if (result) {
            return CommonResult.success("success");
        } else {
            return CommonResult.failed("failed");
        }
    }

    @ResponseBody
    @DeleteMapping("/profile/deleteAddress")
    public CommonResult deleteAddress(@RequestBody Address address) {
        boolean result = addressService.removeById(address);
        if (result) {
            return CommonResult.success("success");
        } else {
            return CommonResult.failed("failed");
        }
    }

    @ResponseBody
    @GetMapping("/defaultAddress")
    public Address getDefaultAddress(@RequestParam(value = "uid", defaultValue = "") int uid) {
        return addressService.getByUid(uid);
    }

}
