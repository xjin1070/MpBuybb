package com.jjh.mpbuybb.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jjh.mpbuybb.bean.UsrInfo;
import com.jjh.mpbuybb.mapper.UsrInfoMapper;
import com.jjh.mpbuybb.service.UsrInfoService;
import org.springframework.stereotype.Service;

@Service
public class UsrInfoServiceImpl extends ServiceImpl<UsrInfoMapper,UsrInfo> implements UsrInfoService {
}
