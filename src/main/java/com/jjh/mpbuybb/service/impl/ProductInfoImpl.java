package com.jjh.mpbuybb.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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

    @Override
    public List<ProductInfo> getAll(Integer pageNum, Integer pageSize) {
        pageNum = pageNum -1;
        return productInfoMapper.getAll(pageNum,pageSize);
    }

    @Override
    public List<ProductInfo> selectList(String pname, Integer pageNum, Integer pageSize) {
        pageNum = pageNum -1;
        String pname1 = "%"+pname+"%";
        return productInfoMapper.selectList(pname1,pageNum,pageSize);
    }


}
