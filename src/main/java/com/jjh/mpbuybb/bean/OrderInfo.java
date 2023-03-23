package com.jjh.mpbuybb.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class OrderInfo {
    @TableId(type = IdType.AUTO)
    private Integer id; //主键
    private String orderNum ; //订单编号
//    private Integer usr_id ; //用户id
    private Double amount ; //总金额
    private Integer status; //支付状态（0：未支付，1：已支付，2：已发货，3：已签收）
    private Integer postage ; //邮费（默认包邮）
    private String create_time ; //下单时间
    private String address ; //收货地址
    private Integer pno; //商品id
    private String pname; //商品名称
    private Integer pnum; //商品数量
    private Double price; //商品单价
}
