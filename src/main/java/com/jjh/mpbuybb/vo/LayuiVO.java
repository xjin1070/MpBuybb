package com.jjh.mpbuybb.vo;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class LayuiVO {
    private int code; //响应码,如果有返回值，则为0
    private String msg; //返回消息
    private int count;//总记录数
    private Object data;//   返回数据

    public LayuiVO() {
        super();
    }

    public LayuiVO(int code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
    }
    public LayuiVO( Object data) {
        super();
        this.code = 0;
        this.data = data;
    }
}
