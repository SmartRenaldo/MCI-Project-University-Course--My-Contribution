package com.awesome.controller;

import com.awesome.controller.utils.R;
import com.awesome.entity.Mark;
import com.awesome.service.IMarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Yiqi Li
 */
@RestController
@CrossOrigin
@RequestMapping("/marks")
public class MarkController {

    @Autowired
    IMarkService iMarkService;

    /**
     * save single item
     * @param mark
     * @return
     */
    @PostMapping
    public R save(@RequestBody Mark mark) {
        boolean flag = iMarkService.save(mark);
        return new R(flag, flag ? "Added successfully!" : "Add failed!");
    }

    /**
     * can only handle where condition in sql for exact search
     * @param mark
     * @return
     */
    @GetMapping
    public R getByCondition(Mark mark) {
        List<Mark> marks = iMarkService.getByCondition(mark);
        return new R(true, marks);
    }

    /**
     * calculate the average marks of users when aspect_id, and summary_id are fixed
     * @return
     */
    @GetMapping(value = "/avg_userid")
    public R getAvgMarkOfUserId() {
        List<Mark> marks = iMarkService.getAvgMarkOfUserId();
        return new R(true, marks);
    }

    /**
     * calculate the average marks of three users, and summary id is the parameter
     * @return
     */
    @GetMapping(value = "/avg_userid/{id}")
    public R getAvgMarkOfUserIdBySummaryId(@PathVariable int id) {
        List<Mark> marks = iMarkService.getAvgMarkOfUserIdBySummaryId(id);
        return new R(true, marks);
    }

    /**
     * get the max mark for articles according to aspect id
     * @return
     */
    @GetMapping(value = "/highest_mark/{id}")
    public R getHighestMark(@PathVariable int id) {
        Mark mark = iMarkService.getHighestMark(id);
        return new R(true, mark);
    }

    /**
     * get the min mark for articles according to aspect id
     * @return
     */
    @GetMapping(value = "/lowest_mark/{id}")
    public R getLowestMark(@PathVariable int id) {
        Mark mark = iMarkService.getLowestMark(id);
        return new R(true, mark);
    }

    /**
     * select paragraph_num, aspect_id, and summary_id with huge difference given by users,
     * and paragraph_num, aspect_id, and summary_id are fixed
     * (Scenario: if different users mark the same item with huge difference
     * (the max mark - the min mark > 1 ), need to call for a vote)
     * @return list of marks
     */
    @GetMapping(value = "/vote")
    public R getVoteData() {
        List<Mark> marks = iMarkService.getVoteData();
        return new R(true, marks);
    }

    /**
     * update mark according to userId, and aspectId
     * @param mark
     * @return rows effected
     */
    @PutMapping
    public R update(@RequestBody Mark mark) {
        boolean flag = iMarkService.updateMark(mark);
        return new R(flag, flag ? "Updated successfully!" : "Update failed!");
    }

    /**
     * delete the whole data
     * @return
     */
    @DeleteMapping()
    public R deleteAll() {
        boolean flag = iMarkService.remove(null);
        return new R(flag, flag ? "Removed all successfully!" : "Remove failed!");
    }

    /**
     * delete mark table item where aspect_id, summary_id are same as current respectively
     * (mark's paragraph_num, aspect_id, summary_id)
     * @param mark
     * @return rows effected
     */
    @DeleteMapping(value = "/current_all_users")
    public R deleteCurrentForAllUsers(@RequestBody Mark mark) {
        boolean flag = iMarkService.deleteForAllUsers(mark);
        return new R(flag, flag ? "Removed successfully!" : "Remove failed!");
    }

}
