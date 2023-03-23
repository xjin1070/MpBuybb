package com.jjh.mpbuybb.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.jjh.mpbuybb.bean.OrderInfo;
import com.jjh.mpbuybb.service.OrderInfoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/orderInfo")
public class OrderInfoController {
    @Resource
    OrderInfoService orderInfoService;

    /**
     * 微信小程序后端接口
     * 生成订单
     */
//    @PostMapping("/addOrder")
//    public R addOrder(OrderInfo orderInfo){}


    // 将前端传过来的数据进行处理
    // 1. 生成订单号


//        boolean result = orderInfoService.save(orderInfo);
//        if (!result) {
//            return R.failed("数据请求验证失败");
//        }
//        else {
//            return R.ok("添加成功");
//        }
//
//    }


}
