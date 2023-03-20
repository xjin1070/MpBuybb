package com.jjh.mpbuybb.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jjh.mpbuybb.bean.TypeInfo;
import com.jjh.mpbuybb.mapper.TypeInfoMapper;
import com.jjh.mpbuybb.service.TypeInfoService;
import com.jjh.mpbuybb.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TypeInfoServiceImpl extends ServiceImpl<TypeInfoMapper,TypeInfo> implements TypeInfoService {
//    @Autowired
//    private TypeInfoMapper typeInfoMapper;
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
