package com.awesome.mapper;

import com.awesome.entity.Mark;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author Yiqi Li
 */
@Mapper
public interface MarkMapper extends BaseMapper<Mark> {
    /**
     * calculate the average marks of users when aspect_id, and summary_id are fixed
     * @return list of marks
     */
    @Select("SELECT AVG(mark) as 'mark', aspect_id, summary_id from mark_table group by aspect_id, summary_id")
    List<Mark> selectAvgMarkOfUserId();

    /**
     * calculate the average marks of three users, paragraph numbers, and summary id
     * @param summaryId
     * @return list of marks
     */
    @Select("SELECT AVG(mark) as 'mark', aspect_id, summary_id from mark_table where summary_id = #{summaryId} group by aspect_id")
    List<Mark> selectAvgMarkOfUserIdBySummaryId(int summaryId);

    /**
     * get the max marks after calculate the average marks for users
     * @return mark list
     */
    @Select("SELECT AVG(mark) as 'mark', aspect_id, summary_id from mark_table where aspect_id=#{aspectId} group by summary_id order by AVG(mark) desc limit 1")
    Mark selectHighestMark(int aspectId);

    /**
     * get the min marks after calculate the average marks for users
     * @return mark list
     */
    @Select("SELECT AVG(mark) as 'mark', aspect_id, summary_id from mark_table where aspect_id=#{aspectId} group by summary_id order by AVG(mark) asc limit 1")
    Mark selectLowestMark(int aspectId);

    /**
     * select paragraph_num, aspect_id, and summary_id with huge difference given by users,
     * and paragraph_num, aspect_id, and summary_id are fixed
     * @return list of marks
     */
    @Select("select distinct t1.aspect_id, t1.summary_id from mark_table t1, mark_table t2 where t1.mark > t2.mark + 1 and t1.aspect_id = t2.aspect_id and t1.summary_id=t2.summary_id")
    List<Mark> selectVoteData();

    /**
     * update mark according to paragraphNum, userId, and aspectId
     * @param mark
     * @return rows effected
     */
    @Update("Update mark_table set mark = #{mark} where user_id = #{userId} and aspect_id = #{aspectId} and summary_id = #{summaryId}")
    int updateMark(Mark mark);

    /**
     * delete mark table item where paragraph_num, aspect_id, summary_id are same as current respectively
     * @param mark
     * @return rows effected
     */
    @Delete("delete from mark_table where aspect_id = #{aspectId} and summary_id = #{summaryId}")
    int deleteForAllUsers(Mark mark);

}
