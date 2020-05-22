package com.yintu.ruixing;

import com.yintu.ruixing.dao.PermissionDao;
import com.yintu.ruixing.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.AntPathMatcher;

@SpringBootTest
class RuixingApplicationTests {

    @Autowired
    private UserService userService;
    @Autowired
    private PermissionDao permissionDao;

    @Test
    void contextLoads() {
        // System.out.println(userService.loadUserByUsername("d"));
//        AntPathMatcher antPathMatcher = new AntPathMatcher();
//        System.out.println(new BCryptPasswordEncoder().encode("123456"));
//        System.out.println(antPathMatcher.match("/users/**", "/users/121212/role"));
//        System.out.println(antPathMatcher.match("/users", "/users/121212/role?page=131"));
        System.out.println(permissionDao.selectByUserIdAndUrl(1L,"/users"));
    }
}
