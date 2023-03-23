package com.jjh.mpbuybb.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.jjh.mpbuybb.bean.OrderInfo;
import com.jjh.mpbuybb.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/orderInfo")
public class OrderInfoController {
    @Autowired
    OrderInfoService orderInfoService;

    /**
     * 微信小程序后端接口
     * 生成订单
     */
    @PostMapping("/addOrder")
//    @RequestParam(defaultValue = ) Integer postage,
    public R addOrder(@RequestParam(defaultValue = "0" )Integer postage,
                      @RequestParam(defaultValue = "default" )String address,
                      @RequestParam(defaultValue = "0" ) Integer pno,
                      @RequestParam(defaultValue = "default")String pname,
                      @RequestParam(defaultValue = "0" )Integer pnum,
                      @RequestParam(defaultValue = "0.0" )Double price,
                      @RequestParam(defaultValue = "0.0")Double amount) {
        Integer integer = orderInfoService.addOrder(postage, address, pno, pname, pnum, price, amount);
        return R.ok(integer);
    }


}
