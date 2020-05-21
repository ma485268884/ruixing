package com.yintu.ruixing;

import com.yintu.ruixing.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class RuixingApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {
        // System.out.println(userService.loadUserByUsername("d"));

        System.out.println(new BCryptPasswordEncoder().encode("123456"));
    }
}
