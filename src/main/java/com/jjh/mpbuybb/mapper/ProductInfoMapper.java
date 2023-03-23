package com.jjh.mpbuybb.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jjh.mpbuybb.bean.ProductInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ProductInfoMapper extends BaseMapper<ProductInfo> {
//    @Select("SELECT * from product_info a JOIN type_info b on a.tno=b.tno")
//    Page<ProductInfo> findPage(Page<ProductInfo> page);


    @Select("SELECT * from product_info a JOIN type_info b on a.tno=b.tno limit #{pageNum},#{pageSize}")
    List<ProductInfo> getAll(Integer pageNum,Integer pageSize);

    @Select("SELECT * from product_info a JOIN type_info b on a.tno=b.tno ")
    List<ProductInfo> getTotal();


    @Select("SELECT * from product_info where pname like #{pname1} limit #{pageNum},#{pageSize}")
    List<ProductInfo> selectLists(String pname1, Integer pageNum, Integer pageSize);


    @Select("SELECT * from product_info where pname like #{pname1}")
    List<ProductInfo> getTotal1(String pname1);
    @Update("update product_info set pname=#{pname} ,price=#{price},pinvent=#{pinvent},punit=#{punit},pnw=#{pnw},pexp=#{pexp},pintro=#{pintro},tno=#{tno},deleted=#{deleted},imgs=#{img},tname=#{tname},status=#{status} where pno=#{pno}")
    void updateProduct(String pname, Double price, Integer pinvent, String punit, String pnw, String pexp, String pintro, Integer tno, String tname, Integer status, Integer deleted, String img, Integer pno);

}
