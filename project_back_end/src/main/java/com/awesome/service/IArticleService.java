package com.awesome.service;

import com.awesome.entity.Article;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @author Yiqi Li
 */
public interface IArticleService extends IService<Article> {
    List<Article> getOrigin();
    List<Article> getSummary();

    boolean saveOrigin(MultipartFile[] files) throws IOException;

    boolean saveSummary(MultipartFile[] files) throws IOException;
}
