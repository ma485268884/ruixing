package com.yintu.ruixing;

import com.yintu.ruixing.entity.CheZhanEntity;
import com.yintu.ruixing.entity.PreSaleFileAuditorEntity;
import com.yintu.ruixing.service.CheZhanService;
import com.yintu.ruixing.service.PreSaleFileAuditorService;
import com.yintu.ruixing.service.QuDuanInfoTypesPropertyService;
import com.yintu.ruixing.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class RuixingApplicationTests {

    @Autowired
    private UserService userService;
    @Autowired
    private PreSaleFileAuditorService preSaleFileAuditorService;
    @Autowired
    private QuDuanInfoTypesPropertyService quDuanInfoTypesPropertyService;
    @Autowired
    private CheZhanService cheZhanService;


    @Test
    void contextLoads() {
        List<PreSaleFileAuditorEntity> preSaleFileAuditorEntities = new ArrayList<>();
        PreSaleFileAuditorEntity preSaleFileAuditorEntity = new PreSaleFileAuditorEntity();
        preSaleFileAuditorEntity.setPreSaleFileId(0);
        preSaleFileAuditorEntity.setAuditorId(0);
        preSaleFileAuditorEntity.setIsPass((short) 0);
        preSaleFileAuditorEntities.add(preSaleFileAuditorEntity);
        preSaleFileAuditorService.addMuch(preSaleFileAuditorEntities);
    }

    @Test
    void contextLoads1() {
//        System.out.println(quDuanInfoTypesPropertyService.connectFindByCondition("1,3"));
//        System.out.println();
////        System.out.println(cheZhanService.findByczId(11));
        String types = quDuanInfoTypesPropertyService.countByType(Arrays.asList(1, 2));
        System.out.println(types);
    }

}
