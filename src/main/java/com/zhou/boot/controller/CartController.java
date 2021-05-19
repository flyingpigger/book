package com.zhou.boot.controller;

import com.zhou.boot.api.CommonResult;
import com.zhou.boot.domain.CartInfo;
import com.zhou.boot.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartController {

    @Autowired
    CartService cartService;

    @ResponseBody
    @RequestMapping("/getCart")
    public List<CartInfo> getCart(@RequestParam(value = "uid", defaultValue = "") int uid) {
        List<CartInfo> carts = cartService.selectAllByUserID(uid);
        return carts;
    }

    @ResponseBody
    @PutMapping("/addCount")
    public CommonResult addCount(@RequestParam(value = "bid", defaultValue = "") int bid,
                                 @RequestParam(value = "uid", defaultValue = "") int uid) {
        boolean result = cartService.addCount(bid, uid);
        if (result) {
            return CommonResult.success("success");
        } else {
            return CommonResult.failed("failed");
        }
    }

    @ResponseBody
    @PutMapping("/minusCount")
    public CommonResult minusCount(@RequestParam(value = "bid", defaultValue = "") int bid,
                                   @RequestParam(value = "uid", defaultValue = "") int uid) {
        boolean result = cartService.minusCount(bid, uid);
        if (result) {
            return CommonResult.success("success");
        } else {
            return CommonResult.failed("failed");
        }
    }

    @ResponseBody
    @PostMapping("/addItem")
    public CommonResult addItem(@RequestParam(value = "bid", defaultValue = "") int bid,
                                @RequestParam(value = "uid", defaultValue = "") int uid) {
        boolean result = cartService.addItem(bid, uid);
        if (result) {
            return CommonResult.success("success");
        } else {
            return CommonResult.failed("failed");
        }
    }

    @ResponseBody
    @DeleteMapping("/deleteItem")
    public CommonResult deleteItem(@RequestParam(value = "bid", defaultValue = "") int bid,
                                @RequestParam(value = "uid", defaultValue = "") int uid) {
        boolean result = cartService.deleteItem(bid, uid);
        if (result) {
            return CommonResult.success("success");
        } else {
            return CommonResult.failed("failed");
        }
    }

    @ResponseBody
    @PutMapping("/setCheck")
    public CommonResult setCheck(@RequestParam(value = "bid", defaultValue = "") int bid,
                                 @RequestParam(value = "checked", defaultValue = "true") boolean checked,
                                 @RequestParam(value = "uid", defaultValue = "") int uid) {
        boolean result = cartService.setChecked(bid, checked, uid);
        if (result) {
            return CommonResult.success("success");
        } else {
            return CommonResult.failed("failed");
        }
    }

    @ResponseBody
    @PutMapping("/setAllCheck")
    public CommonResult setAllCheck(@RequestParam(value = "uid", defaultValue = "") int uid,
                                    @RequestParam(value = "checked", defaultValue = "true") boolean checked) {
        boolean result = cartService.setAllChecked(uid, checked);
        if (result) {
            return CommonResult.success("success");
        } else {
            return CommonResult.failed("failed");
        }
    }
}
