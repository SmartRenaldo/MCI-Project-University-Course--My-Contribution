package com.awesome.service;

import com.awesome.entity.Mark;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author Yiqi Li
 */
public interface IMarkService extends IService<Mark> {
    /**
     * calculate the average marks of users when paragraph_num, aspect_id, and summary_id are fixed
     * @return list of marks
     */
    List<Mark> getAvgMarkOfUserId();

    /**
     * calculate the average marks of three users, paragraph numbers, and summary id is the parameter
     * @param summaryId
     * @return list of marks
     */
    List<Mark> getAvgMarkOfUserIdBySummaryId(int summaryId);

    /**
     * get the max marks after calculate the average marks for users
     * @return mark list
     */
    Mark getHighestMark(int aspectId);

    /**
     * get the min marks after calculate the average marks for users
     * @return mark list
     */
    Mark getLowestMark(int aspectId);

    /**
     * select paragraph_num, aspect_id, and summary_id with huge difference given by users,
     * and paragraph_num, aspect_id, and summary_id are fixed
     * @return list of marks
     */
    List<Mark> getVoteData();

    /**
     * can only handle where condition in sql for exact search
     * @param mark
     * @return
     */
    public List<Mark> getByCondition(Mark mark);
    /**
     * update mark according to paragraphNum, userId, and aspectId
     * @param mark
     * @return rows effected
     */
    boolean updateMark(Mark mark);

    /**
     * delete mark table item where paragraph_num, aspect_id, summary_id are same as current respectively
     * (mark's paragraph_num, aspect_id, summary_id)
     * @param mark
     * @return rows effected
     */
    boolean deleteForAllUsers(Mark mark);

}
