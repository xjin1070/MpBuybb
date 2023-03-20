package com.jjh.mpbuybb.bean;

import lombok.Data;

@Data
public class ProductInfo {
    private Long pno;
    private String pname;
    private Integer tno;
    private Double price;
    private String intro;
    private Integer balance;
    private String pics;
    private String descr;
    private Integer status;
}
