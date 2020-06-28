package com.yintu.ruixing;

import com.yintu.ruixing.dao.PermissionDao;
import com.yintu.ruixing.dao.QuDuanInfoDao;
import com.yintu.ruixing.dao.UserDao;
import com.yintu.ruixing.entity.SolutionStatusEntity;
import com.yintu.ruixing.service.SolutionStatusService;
import com.yintu.ruixing.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.AntPathMatcher;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class RuixingApplicationTests {

    @Autowired
    private UserService userService;

    @Autowired
    SolutionStatusService solutionStatusService;


    @Test
    void contextLoads() {
        Integer[] ids = new Integer[]{1, 2, 3};
        List<SolutionStatusEntity> solutionStatusEntities = solutionStatusService.findByIdsAndType(ids, (short) 1);
        System.out.println(solutionStatusEntities);


    }
}
