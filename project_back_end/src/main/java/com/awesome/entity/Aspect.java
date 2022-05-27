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
@TableName("aspect_mapping")
public class Aspect {
    private String aspect;
    private int aspectId;
}
