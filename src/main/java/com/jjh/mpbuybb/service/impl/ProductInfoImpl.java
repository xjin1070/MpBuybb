package com.jjh.mpbuybb.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jjh.mpbuybb.bean.ProductInfo;
import com.jjh.mpbuybb.mapper.ProductInfoMapper;
import com.jjh.mpbuybb.service.ProductInfoService;
import com.jjh.mpbuybb.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductInfoImpl extends ServiceImpl<ProductInfoMapper, ProductInfo> implements ProductInfoService {

//    @Autowired


    // 多表查询分页
    @Resource
    private ProductInfoMapper productInfoMapper;
//    public Page<ProductInfo> findPage(int currentpage, int pagesize) {
//        Page<ProductInfo> page = new Page<>(currentpage, pagesize);
//        return productInfoMapper.findPage(page);
//    }

    @Override
    public R getAll(Integer pageNum, Integer pageSize) {
        pageNum = (pageNum -1)*pageSize;
         List<ProductInfo> productInfos=productInfoMapper.getAll(pageNum,pageSize);
         Integer total = productInfoMapper.getTotal().size();
//        Integer total = productInfos.size();
        return R.ok().data("productInfos",productInfos).data("total",total);
    }

    @Override
    public List<ProductInfo> findAllProduct() {
        return productInfoMapper.selectList(null);
    }

    @Override
    public R findByPname(String pname, Integer pageNum, Integer pageSize) {
        pageNum = (pageNum -1)*pageSize;
        String pname1 = "%"+pname+"%";
        List<ProductInfo> productInfos=productInfoMapper.selectLists(pname1,pageNum,pageSize);
//        Integer total = productInfos.size();
        Integer total = productInfoMapper.getTotal1(pname1).size();
        return R.ok().data("productInfos",productInfos).data("total",total);
//        return productInfoMapper.selectList(pname1,pageNum,pageSize);
    }


}
