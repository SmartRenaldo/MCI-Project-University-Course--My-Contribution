package com.awesome.service.impl;

import com.awesome.entity.Article;
import com.awesome.mapper.ArticleMapper;
import com.awesome.service.IArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

/**
 * @author Yiqi Li
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements IArticleService {

    @Autowired
    ArticleMapper articleMapper;

    @Override
    public List<Article> getOrigin() {
        return articleMapper.selectOrigin();
    }

    @Override
    public List<Article> getSummary() {
        return articleMapper.selectSummary();
    }

    @Override
    public boolean saveOrigin(MultipartFile[] files) throws IOException {
        String text = new String(files[0].getBytes());
        int insert = articleMapper.insert(new Article(files[0].getOriginalFilename(), text, -1));

        return insert > 0;
    }

    @Override
    public boolean saveSummary(MultipartFile[] files) throws IOException {
        int insert = 0;
        int count = 0;

        for (MultipartFile file : files) {
            String text = new String(file.getBytes());
            insert += articleMapper.insert(new Article(file.getOriginalFilename(), text, count++));
        }

        return insert > 0;
    }
}
