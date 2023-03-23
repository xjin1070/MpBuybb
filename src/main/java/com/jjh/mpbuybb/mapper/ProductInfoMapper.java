package com.jjh.mpbuybb.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
    @Select("SELECT * from product_info a JOIN type_info b on a.tno=b.tno limit #{pageNum},#{pageSize}")
    List<ProductInfo> getAll(Integer pageNum,Integer pageSize);

    @Select("SELECT * from product_info where pname like #{pname1} limit #{pageNum},#{pageSize}")
    List<ProductInfo> selectList(String pname1, Integer pageNum, Integer pageSize);
}
