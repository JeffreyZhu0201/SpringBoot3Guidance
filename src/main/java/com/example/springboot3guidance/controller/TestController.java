package com.example.springboot3guidance.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TestController {

    @RequestMapping("/test")
    public String test(){
        //日志测试
        log.info("Hello, world!");
        log.warn("Hello, world!");
        log.error("Hello, world!");

        String userName = "张三";
        log.info("用户 {} 尝试登录系统。", userName);

        return "test";
    }

}
