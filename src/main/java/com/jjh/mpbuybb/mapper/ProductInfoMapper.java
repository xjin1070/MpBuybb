package com.jjh.mpbuybb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jjh.mpbuybb.bean.ProductInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ProductInfoMapper extends BaseMapper<ProductInfo> {
}
