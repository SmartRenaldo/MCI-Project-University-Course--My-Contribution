package com.awesome.service.impl;

import com.awesome.entity.Mark;
import com.awesome.mapper.MarkMapper;
import com.awesome.service.IMarkService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Yiqi Li
 */
@Service
public class MarkServiceImpl extends ServiceImpl<MarkMapper, Mark> implements IMarkService {

    @Autowired
    MarkMapper markMapper;

    @Override
    public List<Mark> getAvgMarkOfUserId() {
        return markMapper.selectAvgMarkOfUserId();
    }

    @Override
    public List<Mark> getAvgMarkOfUserIdBySummaryId(int summaryId) {
        return markMapper.selectAvgMarkOfUserIdBySummaryId(summaryId);
    }

    @Override
    public Mark getHighestMark(int aspectId) {
        return markMapper.selectHighestMark(aspectId);
    }

    @Override
    public Mark getLowestMark(int aspectId) {
        return markMapper.selectLowestMark(aspectId);
    }

    @Override
    public List<Mark> getVoteData() {
        return markMapper.selectVoteData();
    }

    @Override
    public List<Mark> getByCondition(Mark mark) {
        LambdaQueryWrapper<Mark> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(mark.getMark() != null, Mark::getMark, mark.getMark());
        wrapper.eq(mark.getAspectId() != null, Mark::getAspectId, mark.getAspectId());
        wrapper.eq(mark.getSummaryId() != null, Mark::getSummaryId, mark.getSummaryId());
        wrapper.eq(mark.getUserId() != null, Mark::getUserId, mark.getUserId());

        return markMapper.selectList(wrapper);
    }

    @Override
    public boolean updateMark(Mark mark) {
        int row = markMapper.updateMark(mark);

        return row > 0;
    }

    @Override
    public boolean deleteForAllUsers(Mark mark) {
        int row = markMapper.deleteForAllUsers(mark);

        return row > 0;
    }

}
