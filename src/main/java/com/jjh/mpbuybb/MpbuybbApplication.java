package com.jjh.mpbuybb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.jjh.mpbuybb.mapper")
public class MpbuybbApplication {

    public static void main(String[] args) {
        SpringApplication.run(MpbuybbApplication.class, args);
    }

}
