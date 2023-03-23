package com.jjh.mpbuybb.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class OrderInfo {
    @TableId(type = IdType.AUTO)
    private Integer id; //主键
    private String orderNum ; //订单编号
    private Integer usr_id ; //用户id
    private Double amount ; //总金额
    private Integer postage ; //邮费（默认包邮）
    private String create_time ; //下单时间
    private String address ; //收货地址
}
