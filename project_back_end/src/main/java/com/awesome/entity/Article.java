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
@TableName("article_mapping")
public class Article {
    private String articleName;
    private String text;
    private Integer articleId;
}
