package com.awesome.controller;

import com.awesome.controller.utils.R;
import com.awesome.entity.Article;
import com.awesome.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @author Yiqi Li
 */
@RequestMapping("/article")
@RestController
@CrossOrigin
public class ArticleController {
    @Autowired
    IArticleService articleService;

    /**
     * receive origin file from front-end
     * article id of origin file (source file) is -1
     * @param files
     * @return
     * @throws IOException
     */
    @PostMapping("/origin")
    public R saveOrigin(MultipartFile[] files) throws IOException {
        boolean flag = articleService.saveOrigin(files);

        return new R(flag, flag ? "Added successfully!" : "Add failed!");
    }

    /**
     * receive summary files from front-end
     * article id of summary files start from 1
     * @param files
     * @return
     * @throws IOException
     */
    @PostMapping("/summary")
    public R saveSummary(MultipartFile[] files) throws IOException {
        boolean flag = articleService.saveSummary(files);

        return new R(flag, flag ? "Added successfully!" : "Add failed!");
    }

    /**
     * get origin article name
     * @return
     */
    @GetMapping("/origin")
    public R getOrigin() {
        return new R (true, articleService.getOrigin());
    }

    /**
     * get summary article names and ids
     * @return
     */
    @GetMapping("/summary")
    public R getSummary() {
        return new R (true, articleService.getSummary());
    }

    @DeleteMapping
    public R removeAll() {
        boolean flag = articleService.remove(null);
        return new R(flag, flag ? "Removed all successfully!" : "Remove failed!");
    }
}
