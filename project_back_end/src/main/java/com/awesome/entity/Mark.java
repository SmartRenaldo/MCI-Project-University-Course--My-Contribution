package com.awesome.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Yiqi Li
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@TableName("mark_table")
public class Mark {
    private Double mark;
    private Integer userId;
    private Integer aspectId;
    private Integer summaryId;
}
