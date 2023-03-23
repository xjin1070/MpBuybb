package com.jjh.mpbuybb.controller;

import com.jjh.mpbuybb.service.CartInfoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/cartInfo")
public class CartInfoController {
    @Resource
    CartInfoService cartInfoService;

    /**
     * 微信小程序后端接口
     * 添加商品到购物车
     */
//    @PostMapping("/addCart")
//    public
}
