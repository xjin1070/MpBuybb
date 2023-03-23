package com.jjh.mpbuybb.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("product_info")
public class ProductInfo {


    private String pname; //商品名称
    private Double price; //商品价格
    private Integer pinvent; //商品库存
    private String punit; //商品单位
    private String pnw; //商品净含量
    private String pexp; //商品保质期

    private String pintro; //商品介绍
    @TableId(type = IdType.AUTO)
    private Integer pno; //商品编号 (主键)
    private Integer tno; //商品类型编号
    private String tname; //商品类型名称
    private Integer status; //商品状态，0为下架，1为上架，默认0
    @TableLogic(value = "0",delval = "1")
    private Integer deleted;

    private String imgs; //商品图片
}
