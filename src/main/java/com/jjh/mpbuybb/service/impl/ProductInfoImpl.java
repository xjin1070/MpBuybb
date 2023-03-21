package com.jjh.mpbuybb.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jjh.mpbuybb.bean.ProductInfo;
import com.jjh.mpbuybb.mapper.ProductInfoMapper;
import com.jjh.mpbuybb.service.ProductInfoService;
import org.springframework.stereotype.Service;

@Service
public class ProductInfoImpl extends ServiceImpl<ProductInfoMapper, ProductInfo> implements ProductInfoService {
}
