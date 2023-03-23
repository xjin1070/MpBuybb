package com.jjh.mpbuybb.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jjh.mpbuybb.bean.TypeInfo;
import com.jjh.mpbuybb.mapper.TypeInfoMapper;
import com.jjh.mpbuybb.service.TypeInfoService;
import com.jjh.mpbuybb.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TypeInfoServiceImpl extends ServiceImpl<TypeInfoMapper,TypeInfo> implements TypeInfoService {

    @Autowired
    private TypeInfoMapper typeInfoMapper;
    @Override
    public List<TypeInfo> findTypeColumn() {
        QueryWrapper<TypeInfo> lm=new QueryWrapper<>();
        lm.select("tname");

        return typeInfoMapper.selectList(lm);
    }

    @Override
    public List<TypeInfo> findTypeOne(String name) {
        QueryWrapper<TypeInfo> lm=new QueryWrapper<>();
        lm.select("tno");
        lm.eq("tname",name);
        return typeInfoMapper.selectList(lm);
    }
//    @Autowired
//    private TypeInfoMapper typeInfoMapper;
//
//    // 分页没写好
//    @Override
//    public Map<String,Object> finds(int curentPage, int pageSize) {
//
//     //   LambdaQueryWrapper<TypeInfo> queryWrapper = new LambdaQueryWrapper<>();
//        //queryWrapper.eq(TypeInfo :: getTno, content);
//
//        //  queryWrapper.like(typeInfo.getTname() != null, TypeInfo :: getTname, content);
//
//        Page<TypeInfo> typeInfoPage = new Page<>(curentPage, pageSize);
//        Page<TypeInfo> page1 = typeInfoMapper.selectPage(typeInfoPage, null);
//        Map<String,Object> map = new HashMap<>();
//        map.put("total",page1.getTotal());
//        map.put("data",page1.getRecords());
//
//        return map;
//    }
//
//


//
//    @Override
//    public int add(String tname) {
//        if (StringUtil.checkNull(tname)) {
//            return -1;
//        }
//        return typeInfoMapper.add(tname);
//    }
//
//    @Override
//    public List<TypeInfo> finds() {
//        return typeInfoMapper.finds() ;
//    }
}
