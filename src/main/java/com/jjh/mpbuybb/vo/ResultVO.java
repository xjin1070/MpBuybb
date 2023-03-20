package com.jjh.mpbuybb.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor

//@NoArgsConstructor
public class ResultVO {
    private int code; //响应码
    private String msg; //返回消息
    private Object data;// 返回数据

    public ResultVO() {
        super();
    }

    public ResultVO(int code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
    }
    public ResultVO(int code, Object data) {
        super();
        this.code = code;
        this.data = data;
    }

    private boolean flag;


    public ResultVO(Boolean flag){
        this.flag = flag;
    }

    public ResultVO(Boolean flag, String msg) {
        this.flag = flag;
        this.msg = msg;
    }

    public ResultVO(Boolean flag, Object data) {
        this.flag = flag;
        this.data = data;
    }
    public ResultVO(Object object){
        this.flag = true;
        this.data = object;
    }


}
