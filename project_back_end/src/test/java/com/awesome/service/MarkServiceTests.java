package com.awesome.service;

import com.awesome.entity.Mark;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.apache.logging.log4j.util.Strings;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MarkServiceTests {
    @Autowired
    IMarkService markService;

    //test passed
    @Test
    public void testSave() {
        boolean flag = markService.save(new Mark(4.0, 2, 2, 1));
        System.out.println(flag);
    }

    //test passed
    @Test
    public void testList() {
        List<Mark> marks = markService.list(null);

        for (Mark mark : marks) {
            System.out.println(mark);
        }
    }

    //test passed
    @Test
    public void testGetAvgMarkOfUserId() {
        List<Mark> marks = markService.getAvgMarkOfUserId();

        for (Mark mark : marks) {
            System.out.println(mark);
        }
    }

    //test passed
    @Test
    public void testGetHighestMarkBy() {
        Mark mark = markService.getHighestMark(1);
        System.out.println(mark);
    }

    //passed
    @Test
    public void testGetLowestMarkBy() {
        Mark mark = markService.getLowestMark(1);
        System.out.println(mark);
    }

    //passed
    @Test
    public void testGetVoteData() {
        List<Mark> marks = markService.getVoteData();

        for (Mark mark : marks) {
            System.out.println(mark);
        }
    }

    //test passed
    @Test
    public void testGetByCondition() {
        List<Mark> marks = markService.getVoteData();

        for (Mark mark : marks) {
            System.out.println(mark);
        }
    }

    //passed
    @Test
    public void testGetAvgMarkOfUserIdBySummaryId() {
        List<Mark> marks = markService.getAvgMarkOfUserIdBySummaryId(1);
        for (Mark mark : marks) {
            System.out.println(mark);
        }
    }

    //passed
    @Test
    public void testUpdateMark() {
        boolean flag = markService.updateMark(new Mark(5.0, 2, 3, 1));
        System.out.println(flag);
    }

    //passed
    @Test
    public void testDeleteForAllUsers() {
        boolean flag = markService.deleteForAllUsers(new Mark(5.0, 4, 3, 3));
        System.out.println(flag);
    }
}
