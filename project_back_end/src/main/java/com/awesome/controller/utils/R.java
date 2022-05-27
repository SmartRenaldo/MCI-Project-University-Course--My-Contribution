package com.awesome.controller.utils;

import lombok.Data;

/**
 * @author Yiqi Li
 */
@Data
public class R {
    private Boolean flag;
    private Object data;
    private String message;

    public R() {
    }

    public R(Boolean flag) {
        this.flag = flag;
    }

    public R(Boolean flag, Object data) {
        this.flag = flag;
        this.data = data;
    }

    public R(Boolean flag, String message) {
        this.flag = flag;
        this.message = message;
    }

    public R(String message) {
        this.flag = false;
        this.message = message;
    }
}
