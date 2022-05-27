package com.awesome.mapper;

import com.awesome.entity.Mark;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MarkMapperTests {
    @Autowired
    MarkMapper markMapper;

    //test passed
    @Test
    public void testInsert() {
        int i = markMapper.insert(new Mark(3.0, 4, 3, 2));
        System.out.println(i);
    }

    //test passed
    @Test
    public void testSelectList() {
        List<Mark> marks = markMapper.selectList(null);
        for (Mark mark : marks) {
            System.out.println(mark);
        }
    }

    //test passed
    @Test
    public void testSelectAvgMarkOfUserId() {
        List<Mark> marks = markMapper.selectAvgMarkOfUserId();
        for (Mark mark : marks) {
            System.out.println(mark);
        }
    }

    @Test
    public void testSelectAvgMarkOfUserIdBySummaryId() {
        List<Mark> marks = markMapper.selectAvgMarkOfUserIdBySummaryId(1);
        for (Mark mark : marks) {
            System.out.println(mark);
        }
    }

    //passed
    @Test
    public void testSelectHighestMarkBy() {
        Mark mark = markMapper.selectHighestMark(1);
        System.out.println(mark);
    }

    //passed
    @Test
    public void testSelectLowestMarkBy() {
        Mark mark = markMapper.selectLowestMark(1);
        System.out.println(mark);
    }

    //passed
    @Test
    public void testSelectVoteData() {
        List<Mark> marks = markMapper.selectVoteData();
        for (Mark mark : marks) {
            System.out.println(mark);
        }
    }

    @Test
    public void test() {
        List<Mark> marks = markMapper.selectVoteData();
        System.out.println(marks);

        for (Mark mark : marks) {
            LambdaQueryWrapper<Mark> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(mark.getMark() != null, Mark::getMark, mark.getMark());
            wrapper.eq(mark.getAspectId() != null, Mark::getAspectId, mark.getAspectId());
            wrapper.eq(mark.getSummaryId() != null, Mark::getSummaryId, mark.getSummaryId());
            wrapper.eq(mark.getUserId() != null, Mark::getUserId, mark.getUserId());

            List<Mark> marks2 = markMapper.selectList(wrapper);
            System.out.println(marks2);
        }
    }

    //passed
    @Test
    public void testSelectAvgMarkOfUserIdParagraphNumBySummaryId() {
        List<Mark> marks = markMapper.selectAvgMarkOfUserIdBySummaryId(1);
        for (Mark mark : marks) {
            System.out.println(mark);
        }
    }

    //passed
    @Test
    public void testUpdateMark() {
        int i = markMapper.updateMark(new Mark(5.0, 2, 3, 1));
        System.out.println(i);
    }

    //passed
    @Test
    public void testDeleteForAllUsers() {
        int i = markMapper.deleteForAllUsers(new Mark(5.0, 2, 3, 3));
        System.out.println(i);
    }

}
