package com.jjh.mpbuybb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jjh.mpbuybb.bean.TypeInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TypeInfoMapper extends BaseMapper<TypeInfo> {
//    /**
//     * 添加
//     * @param tname
//     * @return
//     */
//    int add(String tname);
//    /**
//     * 查询
//     * @return
//     */
//    List<TypeInfo> finds();
}
