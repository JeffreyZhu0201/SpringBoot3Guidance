package com.example.springboot3guidance.mapper;

import com.example.springboot3guidance.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import java.util.List;

@Mapper
@Repository
public interface StudentMapper {
    @Select("SELECT * FROM student WHERE gender = '女';")
    public List<Student> findGirl() ;

    @Select("SELECT * FROM student WHERE id = #{id};")
    List<Student> findById(int id);//不加public也可，因为interface中的方法都是公用的
}
