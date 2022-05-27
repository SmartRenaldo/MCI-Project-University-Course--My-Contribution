package com.awesome.mapper;

import com.awesome.entity.Article;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Yiqi Li
 */
@Mapper
public interface ArticleMapper extends BaseMapper<Article> {
    @Select("select * from article_mapping where article_id = -1")
    List<Article> selectOrigin();

    @Select("select * from article_mapping where article_id <> -1")
    List<Article> selectSummary();
}
