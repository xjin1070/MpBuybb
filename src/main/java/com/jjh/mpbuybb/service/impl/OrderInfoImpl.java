package com.jjh.mpbuybb.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jjh.mpbuybb.bean.OrderInfo;
import com.jjh.mpbuybb.mapper.OrderInfoMapper;
import com.jjh.mpbuybb.service.OrderInfoService;
import com.jjh.mpbuybb.vo.R;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class OrderInfoImpl extends ServiceImpl<OrderInfoMapper, OrderInfo> implements OrderInfoService {
    @Resource
    OrderInfoMapper orderInfoMapper;

    @Override
    public Integer addOrder(Integer postage, String address, Integer pno, String pname, Integer pnum,Double price, Double amount) {
//        其他的在这里传入，用set
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setPostage(postage);
        orderInfo.setAddress(address);
//        orderInfo.setPno(postage);
        orderInfo.setPno(pno);
        orderInfo.setPname(pname);
        orderInfo.setPnum(pnum);
        orderInfo.setPrice(price);
        orderInfo.setAmount(amount);

        //获取当前时间
        Date date= new Date();
//        long time = date.getTime();
//        time.toString();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dataString = sdf.format(date);
        orderInfo.setCreate_time(dataString);

        //状态
        orderInfo.setStatus(0); //默认为0，未支付


        //根据上面所有的信息，生成订单号
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMddHHmmss");
        String sdf1String = sdf1.format(date);
        String orderNo = pno+sdf1String+pnum;
        orderInfo.setOrderNum(orderNo);




        int insert = orderInfoMapper.insert(orderInfo);
        return insert;
    }

    @Override
    public List<OrderInfo> findByPname(String pname) {
        LambdaQueryWrapper<OrderInfo> lm = new LambdaQueryWrapper<>();
        lm.like(pname!=null,OrderInfo::getPname,pname);
        return orderInfoMapper.selectList(lm);
    }

//    @Override
//    public R findByPnoOrPname(String pname, Integer pno) {
//        List<OrderInfo> orderInfos = orderInfoMapper.findByPnoOrPname(pname, pno);
//    }
}
