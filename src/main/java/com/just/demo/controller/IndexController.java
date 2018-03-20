package com.just.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by apple on 2018/3/20.
 */

@RestController
public class IndexController {

    @RequestMapping("/index")
    public String index() {
        return "index";
    }
}
