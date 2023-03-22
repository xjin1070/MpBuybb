package com.jjh.mpbuybb.TypeInfoServoiceImpTest;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jjh.mpbuybb.bean.TypeInfo;
import com.jjh.mpbuybb.mapper.TypeInfoMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class TypeInfoServoiceTest {
    @Autowired
    TypeInfoMapper typeInfoMapper;
    @Test
    void test(){
        Page<TypeInfo> typeInfoPage = new Page<>(1, 2);
        typeInfoMapper.selectPage(typeInfoPage, null);
        Map<String,Object> map = new HashMap<>();
        map.put("total",typeInfoPage.getTotal());
        map.put("data",typeInfoPage.getRecords());
        System.out.println(map);




    }
}
