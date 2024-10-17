package com.example.springboot3guidance;

import com.example.springboot3guidance.entity.Student;
import com.example.springboot3guidance.mapper.StudentMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringBoot3GuidanceApplicationTests {

//    @Test
//    void contextLoads() {
//    }

    @Autowired
    public StudentMapper studentMapper;

    @Test
    void getGirl() {
        List<Student> students = studentMapper.findGirl();
        for (Student student : students) {
            System.out.println(student);
        }
    }


}


