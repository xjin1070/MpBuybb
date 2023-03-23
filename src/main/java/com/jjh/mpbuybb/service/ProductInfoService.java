package com.jjh.mpbuybb.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jjh.mpbuybb.bean.ProductInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public interface ProductInfoService extends IService<ProductInfo> {
    List<ProductInfo> getAll(Integer pageNum, Integer pageSize);

    List<ProductInfo> selectList(String pname, Integer pageNum, Integer pageSize);
}
