package com.example.springboot3guidance.controller;

import com.example.springboot3guidance.service.TestService;
import com.example.springboot3guidance.utils.Result;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.springboot3guidance.utils.ResultEnum.RESULT_DATA_NONE;

@RestController
@Slf4j
public class TestController {

    @Resource
    TestService testService;

    @RequestMapping("/test")
    public Result<String> test(){
        //日志测试
        log.info("Hello, world!");
        log.warn("Hello, world!");
        log.error("Hello, world!");

        String userName = "张三";
        log.info("用户 {} 尝试登录系统。", userName);

        String name = testService.testService("123");

        return Result.error(RESULT_DATA_NONE);
    }

}
