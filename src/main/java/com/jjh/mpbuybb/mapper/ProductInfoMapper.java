package com.jjh.mpbuybb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jjh.mpbuybb.bean.ProductInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ProductInfoMapper extends BaseMapper<ProductInfo> {
//    @Select("SELECT * from product_info a JOIN type_info b on a.tno=b.tno")
//    Page<ProductInfo> findPage(Page<ProductInfo> page);
    List<ProductInfo> getAll();
}
