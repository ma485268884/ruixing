package com.yintu.ruixing;

import com.yintu.ruixing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class RuixingApplicationTests {

    @Autowired
    private UserService userService;




   /* @Test
    void contextLoads() {
        Integer[] ids = new Integer[]{1, 2, 3};
        List<SolutionStatusEntity> solutionStatusEntities = solutionStatusService.findByIdsAndType(ids, (short) 1);
        System.out.println(solutionStatusEntities);


    }*/
}
