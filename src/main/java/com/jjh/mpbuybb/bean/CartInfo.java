package com.jjh.mpbuybb.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class CartInfo {
    @TableId(type = IdType.AUTO)
    private Integer pno; //主键
    private String pname;
    private Integer pnum;
    private Integer tno;
    private Double price;
    private String intro;
    private Boolean checked;
}
