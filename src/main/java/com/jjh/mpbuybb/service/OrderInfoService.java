package com.jjh.mpbuybb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jjh.mpbuybb.bean.OrderInfo;
import org.springframework.stereotype.Service;

@Service
public interface OrderInfoService extends IService<OrderInfo> {
    Integer addOrder(Integer postage,String address,Integer pno,String pname,Integer pnum,Double price,Double amount
    );

}
