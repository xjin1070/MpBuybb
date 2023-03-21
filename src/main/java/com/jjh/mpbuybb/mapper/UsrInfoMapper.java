package com.jjh.mpbuybb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jjh.mpbuybb.bean.UsrInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UsrInfoMapper extends BaseMapper<UsrInfo> {
//    @Select("select * from usr_info where usr_name = #{usrName}")
////    List<Integer> get;
}
