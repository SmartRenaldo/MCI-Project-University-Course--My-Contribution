package com.awesome.controller.utils;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * throw exception
 * @author Yiqi Li
 */
@RestControllerAdvice
public class ProjectExceptionAdvice {
    // intercept all exception information
    @ExceptionHandler
    public R doException(Exception e){
        e.printStackTrace();
        return new R("Server failure, please try again later!");
    }
}
