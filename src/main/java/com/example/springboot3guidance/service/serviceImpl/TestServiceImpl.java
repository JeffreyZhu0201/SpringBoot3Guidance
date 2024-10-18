package com.example.springboot3guidance.service.serviceImpl;

import com.example.springboot3guidance.service.TestService;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {
    @Override
    public String testService(String userName) {
        return "hello " + userName;
    }
}
