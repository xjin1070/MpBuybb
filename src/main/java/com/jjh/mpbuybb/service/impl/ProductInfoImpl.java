package com.jjh.mpbuybb.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jjh.mpbuybb.bean.ProductInfo;
import com.jjh.mpbuybb.mapper.ProductInfoMapper;
import com.jjh.mpbuybb.service.ProductInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductInfoImpl extends ServiceImpl<ProductInfoMapper, ProductInfo> implements ProductInfoService {


    // 多表查询分页
    @Resource
    private ProductInfoMapper productInfoMapper;
//    public Page<ProductInfo> findPage(int currentpage, int pagesize) {
//        Page<ProductInfo> page = new Page<>(currentpage, pagesize);
//        return productInfoMapper.findPage(page);
//    }

    public List<ProductInfo> getAll() {
        return productInfoMapper.getAll();
    }
}
