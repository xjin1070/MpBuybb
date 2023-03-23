package com.jjh.mpbuybb.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jjh.mpbuybb.bean.OrderInfo;
import com.jjh.mpbuybb.mapper.OrderInfoMapper;
import com.jjh.mpbuybb.service.OrderInfoService;
import org.springframework.stereotype.Service;

@Service
public class OrderInfoImpl extends ServiceImpl<OrderInfoMapper, OrderInfo> implements OrderInfoService {
}
