package com.yintu.ruixing;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.yintu.ruixing.dao"})
public class RuixingApplication {

    public static void main(String[] args) {
        SpringApplication.run(RuixingApplication.class, args);
    }

}
