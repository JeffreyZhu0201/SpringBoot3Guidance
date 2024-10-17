package com.example.springboot3guidance.mapper;

import com.example.springboot3guidance.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import java.util.List;

@Mapper
@Repository
public interface StudentMapper {
//    @Select("SELECT * FROM student WHERE gender = '女';")
//    public List<Student> findGirl() ;
//
//    @Select("SELECT * FROM student WHERE id = #{id};")
//    List<Student> findById(int id);//不加public也可，因为interface中的方法都是公用的

//    //转换数据库字段方法 将column字段转换为Entity字段
//    @Results({
//            @Result(column= "dept_id", property = "deptId"),
//            @Result(column= "create_time", property = "createTime"),
//            @Result(column= "update_time", property = "updateTime")
//    })
//    @Select("select id, username, password, name, gender, image, job, entrydate, " +
//            "dept_id, create_time, update_time from emp where id = #{id}")
//    List<Student> getById2(Integer id);

        public List<Student> findGirl() ;

        public List<Student> findById(int id);

        public int insertStudent(Student student);

        public int deleteById(int id);

        public int updateClassName(int id, String className);

}
