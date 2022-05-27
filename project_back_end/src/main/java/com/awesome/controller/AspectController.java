package com.awesome.controller;

import com.awesome.controller.utils.R;
import com.awesome.entity.Aspect;
import com.awesome.service.IAspectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Yiqi Li
 */
@RestController
@CrossOrigin
@RequestMapping("/aspects")
public class AspectController {

    @Autowired
    IAspectService aspectService;

    @PostMapping
    public R saveAll(@RequestBody List<Aspect> aspects) {
        boolean flag = aspectService.saveBatch(aspects);
        return new R(flag, flag ? "Added successfully!" : "Add failed!");
    }

    @GetMapping
    public R getAll() {
        return new R(true, aspectService.list());
    }

    @DeleteMapping
    public R deleteAll() {
        return new R(true, aspectService.remove(null));
    }

}
