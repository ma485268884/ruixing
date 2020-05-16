package com.yintu.ruixing;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RuixingApplicationTests {
    //@Value("${spring.datasource.initialSize}")
    private String test;

    @Test
    void contextLoads() {
        System.out.println(test);
    }
}
