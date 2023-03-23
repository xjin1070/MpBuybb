package com.jjh.mpbuybb.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jjh.mpbuybb.bean.CartInfo;
import com.jjh.mpbuybb.mapper.CartInfoMapper;
import com.jjh.mpbuybb.service.CartInfoService;
import org.springframework.stereotype.Service;

@Service
public class CartInfoImpl extends ServiceImpl<CartInfoMapper, CartInfo> implements CartInfoService{

}
