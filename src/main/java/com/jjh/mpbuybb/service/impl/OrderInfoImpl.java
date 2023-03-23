package com.jjh.mpbuybb.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jjh.mpbuybb.bean.OrderInfo;
import com.jjh.mpbuybb.mapper.OrderInfoMapper;
import com.jjh.mpbuybb.service.OrderInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OrderInfoImpl extends ServiceImpl<OrderInfoMapper, OrderInfo> implements OrderInfoService {
    @Resource
    OrderInfoMapper orderInfoMapper;

    @Override
    public Integer addOrder(Integer postage, String address, Integer pno, String pname, Integer pnum,Double price, Double amount) {
//        其他的在这里传入，用set
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setPostage(postage);
        orderInfo.setAddress(address);
//        orderInfo.setPno(postage);
        orderInfo.setPno(pno);
        orderInfo.setPname(pname);
        orderInfo.setPnum(pnum);
        orderInfo.setPrice(price);
        orderInfo.setAmount(amount);

//        //获取当前时间
//        orderInfo.setOrderTime(new Date());

        int insert = orderInfoMapper.insert(orderInfo);
        return insert;
    }
}
