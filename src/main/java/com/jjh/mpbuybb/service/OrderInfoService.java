package com.jjh.mpbuybb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jjh.mpbuybb.bean.OrderInfo;
import com.jjh.mpbuybb.vo.R;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderInfoService extends IService<OrderInfo> {
    Integer addOrder(Integer postage,String address,Integer pno,String pname,Integer pnum,Double price,Double amount);

//    R findByPnoOrPname(String pname, Integer pno);
    List<OrderInfo> findByPname(String pname);
}
