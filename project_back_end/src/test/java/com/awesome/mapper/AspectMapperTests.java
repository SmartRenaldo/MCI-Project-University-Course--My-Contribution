package com.awesome.mapper;

import com.awesome.entity.Aspect;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Yiqi Li
 */
@SpringBootTest
public class AspectMapperTests {

    @Autowired
    AspectMapper aspectMapper;

    // passed
    @Test
    public void testInsert(){
        aspectMapper.insert(new Aspect("Non-Redundancy", 1));
    }
}
