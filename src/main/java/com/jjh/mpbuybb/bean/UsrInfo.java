package com.jjh.mpbuybb.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("usr_info")
public class UsrInfo {
//    @TableId(type = IdType.AUTO)
    @JsonProperty(value = "id")
//    @Column(name = "ID")

    private Integer id;
    private String name;
    private String password;
    private String position;

    private String Email;
    private String address; //收货地址
}
