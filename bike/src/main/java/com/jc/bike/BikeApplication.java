package com.jc.bike;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.jc.bike.mapper")
public class BikeApplication {

    public static void main(String[] args) {
        SpringApplication.run(BikeApplication.class, args);
    }

}
