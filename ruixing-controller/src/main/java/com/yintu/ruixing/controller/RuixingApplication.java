package com.yintu.ruixing.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value = {"classpath:druid.properties"})
public class RuixingApplication {

    public static void main(String[] args) {
        SpringApplication.run(RuixingApplication.class, args);
    }

}
