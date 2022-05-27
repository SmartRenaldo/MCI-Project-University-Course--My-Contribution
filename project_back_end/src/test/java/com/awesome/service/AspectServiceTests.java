package com.awesome.service;

import com.awesome.entity.Aspect;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author Yiqi Li
 */
@SpringBootTest
public class AspectServiceTests {
    @Autowired
    IAspectService iAspectService;

    //passed
    @Test
    void testSave() {
        iAspectService.save(new Aspect("Non-Redundancy", 2));
    }

    @Test
    void testList() {
        List<Aspect> aspects = iAspectService.list();
        for (Aspect aspect : aspects) {
            System.out.println(aspect);
        }
    }
}
