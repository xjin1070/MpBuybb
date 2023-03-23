package com.jjh.mpbuybb.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.jjh.mpbuybb.bean.OrderInfo;
import com.jjh.mpbuybb.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 后台接口
     * 根据商品编号或者商品名称查询订单
     */
//    @GetMapping("/findByOno")


    /**
     * 修改订单信息
     */
    @PostMapping("/editOrder")
    public R editOrder(OrderInfo orderInfo) {
        try {
            if (orderInfoService.updateById(orderInfo)) {
                return R.ok("修改成功");
            }
        } catch (Exception e) {
            return R.failed("修改失败");
        }
    return R.failed("修改失败");
    }

}
