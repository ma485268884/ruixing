package com.yintu.ruixing;

import com.yintu.ruixing.dao.PermissionDao;
import com.yintu.ruixing.dao.QuDuanInfoDao;
import com.yintu.ruixing.dao.UserDao;
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

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class RuixingApplicationTests {

    @Autowired
    private UserService userService;
    @Autowired
    private PermissionDao permissionDao;
    @Autowired
    private QuDuanInfoDao quDuanInfoDao;


    @Test
    void contextLoads() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd");
        Date date = simpleDateFormat.parse("2020-06-04");
        System.out.println(quDuanInfoDao.selectStatisticsSongDuanByDate(date));
        System.out.println(quDuanInfoDao.selectStatisticsFenXianPanSongDuanByDate(date));
        System.out.println(quDuanInfoDao.selectStatisticsFenXianPanShouDuanByDate(date));
        System.out.println(quDuanInfoDao.selectStatisticsShouDuanByDate(date));

    }
}
