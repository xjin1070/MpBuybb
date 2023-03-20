package com.jjh.mpbuybb.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class TypeInfo {
//    @TableId(value = "tno")
@TableId(type = IdType.AUTO)
    private Integer tno;
    private String tname;
    private Integer status;
}
