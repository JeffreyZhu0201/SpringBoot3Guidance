# SpringBoot3Guidance

一步步教你搭建基本的SpringBoot3框架，并实现基础工具类，便于以后个性化开发！

## 目录

1. 项目依赖
2. 初始化项目
3. 配置Mybatis

## 1.项目依赖
JDK 版本: 17.0.12

SpringBoot 版本： 3.3.4

Idea

## 2.初始化项目

### 使用Idea自动创建项目

初始化选择：SpringWeb,Lombok,MySql Driver,Mybatis Framework 四个依赖

创建！

### 创建Controller

在启动类同级文件夹下创建Controller文件夹，在里面创建TestController.class

```java
//TestController.java
@RestController
public class TestController {
    @RequestMapping(value = "/test")
    public String test(){
        return "Hello, world!";
    }
}
```

### 在application.properties 文件加入数据库信息

```properties
# application.properties
spring.datasource.name=springboot3guidance
spring.datasource.url=jdbc:mysql://localhost:3306/springboot3guidance?useUnicode=true&characterEncoding=UTF-8&userSSL=false&serverTimezone=GMT%2B8 
spring.datasource.username=root
spring.datasource.password=qQ135275033**
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```

注意：在 Java 中，当我们使用 JDBC 连接 MySQL 数据库时，需要加载 MySQL 的 JDBC 驱动。这个驱动是一个 Java 类，它实现了 Java 的 java.sql.Driver接口。
在旧版的 MySQL JDBC 驱动中，这个类的全名是 com.mysql.jdbc.Driver。但是，在新版的 MySQL JDBC 驱动中，这个类已经被标记为过时，也就是 deprecated。

旧版数据库
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/springboot3guidance
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
```
新版数据库
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/springboot3guidance?useUnicode=true&characterEncoding=UTF-8&userSSL=false&serverTimezone=GMT%2B8 
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```

### Shift + F10 启动！

项目启动成功，去浏览器验证 http://localhost:8080/test

### 基本项目结构

```text
boot3-01-helloworld/
|-- src/
|   |-- main/
|       |-- java/                                                               # 项目的源代码
|           |-- com/                                
|               |-- fl/
|                   |-- boot/                                        # 包名，例如com.fl.boot
|                       |-- MyApplication.java # 应用的入口类，包含 main 方法，用于启动 Spring Boot 应用
|                       |-- controller/   # 包含所有的控制器类（Controller），它们处理用户的输入并返回响应
|                           |-- MyController.java
|                       |-- service/                    # 包含服务类（Service），它们包含业务逻辑。
|                           |-- MyService.java
|                       |-- repository/     # 用于Spring Data项目,适用于JPA、MongoDB、Neo4j等多种数据源
|                           |-- MyRepository.java
|                       |-- mapper/      # 用于MyBatis项目,用于关系型数据库，也可以通过扩展支持其他数据源
|                           |-- MyMapper.java
|                       |-- entity/                     # 包含实体类（Entity），它们映射到数据库表。
|                           |-- MyEntity.java
|                       |-- config/                             # 包含配置类，用于配置应用的行为
|                           |-- MyConfig.java
|                   		|-- exception
|                    					  |-- GlobalExceptionHandler.java  	# 捕获全局异常并处理
|       |-- resources/                                               # 包含了应用的所有资源文件
|           |-- application.properties                                           # 配置文件
|           |-- application.yml                                 # 配置文件,实际开发比上面的更常用
|           |-- static/                             # 用于存放静态资源，如CSS、JavaScript和图片文件
|           |-- templates/      # 用于存放Web应用的模板文件，这通常是在使用模板引擎（如Thymeleaf）时需要的
|           |-- schema.sql                                      # 用于存放创建数据库结构的SQL脚本
|           |-- data.sql                                        # 用于初始化数据库中的数据的SQL脚本
|       |-- test/                                   # 可以按照与src/main/java相似的包结构组织测试类
|-- pom.xml                                 # Maven构建文件，用于定义项目的依赖、插件和其他构建配置
|-- build.gradle                             # Gradle构建文件，用于定义项目的依赖、插件和其他构建配置
|-- .gitignore                                           # 定义 Git 版本控制系统应该忽略的文件和目录
|-- README.md                       # 这是项目的 README 文件，通常包含项目的基本信息和如何运行应用的指南
```

### 核心文件介绍

#### 入口函数 SpringBoot3GuidanceApplication.java

```java

package com.example.springboot3guidance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBoot3GuidanceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot3GuidanceApplication.class, args);
    }

}

```

* Spring Boot 应用的入口点是包含 @SpringBootApplication注解的类，以及在该类中定义的 main 方法。这个入口类负责启动 Spring Boot 应用。
* @SpringBootApplication：这是一个组合注解，它包含了三个主要的注解：
* @SpringBootConfiguration：标记这个类作为应用的配置类。

### 日志配置

日志是指应用程序运行时产生的信息，这些信息可以帮助开发者了解应用程序的运行状态、
调试问题以及监控应用程序的行为。日志可以包括信息性的消息、警告、错误以及调试信息等。

日志实现是具体实现日志记录功能的库或框架。它实现了日志门面定义的接口，并提供实际的日志记录能力。例如，Logback和Log4J都是日志实现的例子。

在 SLF4J 中，Logger 接口定义了几个常用的日志记录方法，包括 info(), debug(), warn(), 和 error()。
这些方法用于记录不同级别的日志信息，以便于开发者根据日志级别来过滤和查看应用程序的运行情况。

#### 要使用@Slf4j注解，首先要保证在pom.xml中引入了Lombok 库的依赖

```xml
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <optional>true</optional>
</dependency>
```
#### 为应用添加日志注解

```java
//TestController.java
import lombok.extern.slf4j.Slf4j;
@RestController
@Slf4j
public class TestController {
    //    无参测试
    @RequestMapping(value = "/test")
    public String test() {
        log.info("Hello, world!");
        log.warn("Hello, world!");
        log.error("Hello, world!");

        String userName = "张三";
        log.info("用户 {} 尝试登录系统。", userName);

        return "Hello, world!";
    }
}
```

控制台输出如下

```text
2024-10-17T08:48:09.921+08:00  INFO 4832 --- [SpringBoot3Guidance] [nio-8080-exec-1] c.e.s.Controller.TestController          : Hello, world!
2024-10-17T08:48:09.921+08:00  WARN 4832 --- [SpringBoot3Guidance] [nio-8080-exec-1] c.e.s.Controller.TestController          : Hello, world!
2024-10-17T08:48:09.921+08:00 ERROR 4832 --- [SpringBoot3Guidance] [nio-8080-exec-1] c.e.s.Controller.TestController          : Hello, world!
2024-10-17T08:48:09.921+08:00  INFO 4832 --- [SpringBoot3Guidance] [nio-8080-exec-1] c.e.s.Controller.TestController          : 用户 张三 尝试登录系统。
```

说明日志配置成功




### 配置lombok
#### 介绍
实体类代码臃肿(getter、setter、toString...)，太繁琐

Lombok是一个实用的java类库，能通过注解的形式自动生成构造器、
getter/setter、equals、hashcode、tostring等方法，并可以自动化生成日志变量，简化java开发、提高效率。

#### 注解 & 作用

* @Getter/@Setter

为所有的属性提供get/set方法

* @ToString

会给类自动生成易阅读的toString方法

* @EqualsAndHashCode

根据类所拥有的非静态字段自动重写equals方法和hashCode方法

* @Data

提供了更综合的生成代码功能（@Getter+@Setter+@ToString+@EqualsAndHashCode）

* @NoArgsConstructor

为实体类生成无参的构造器方法

* @AllArgsConstructor

为实体类生成除了static修饰的字段之外带有各参数的构造器方法。

#### 配置

##### 在pom.xml 引入依赖

```xml
<dependency>  
    <groupId>org.projectlombok</groupId>  
    <artifactId>lombok</artifactId>  
    <!--不需要指定版本，在父工程已指定-->
</dependency>
```

##### 在实体类加入注解

```java
@Data  
@NoArgsConstructor  
@AllArgsConstructor  
public class User {  
    private Integer id;  
    private String name;  
    private Short age;  
    private Short gender;  
    private String phone;  
  //使用lombok省略了以下代码
//    public User() {  
//    }  
//  
//    public User(Integer id, String name, Short age, Short gender, String phone) {  
//        this.id = id;  
//        this.name = name;  
//        this.age = age;  
//        this.gender = gender;  
//        this.phone = phone;  
//    }  
  
//    public Integer getId() {  
//        return id;  
//    }  
// ...
//    @Override  
//    public String toString() {  
//        return "User{" +  
//                "id=" + id +  
//                ", name='" + name + '\'' +  
//                ", age=" + age +  
//                ", gender=" + gender +  
//                ", phone='" + phone + '\'' +  
//                '}';  
//    }  
}
```

## 配置Mybatis
### 介绍
MyBatis是一个强大的持久层框架，它内部封装了对JDBC的操作，让开发者只需要关注SQL本身，而不需要处理繁琐的数据库连接、SQL构造、结果集处理等JDBC代码。

> 持久层：指的是就是数据访问层(dao)，是用来操作数据库的。

### 配置流程
* 配置MyBatis：在Spring Boot项目中，首先需要在application.properties或application.yml文件中配置MyBatis的相关设置，如mapper文件的位置、数据源信息等。
* 定义实体类：与JPA类似，需要定义实体类（Entity Classes），这些类映射到数据库中的表。MyBatis可以使用注解或XML配置文件来指定映射关系。
* 创建MyBatis的XML映射文件或使用注解：定义Mapper接口，这些接口的方法对应于数据库操作。每个方法通常对应一个SQL语句。然后，创建XML配置文件或使用注解来编写SQL语句和映射结果。MyBatis还支持动态SQL，可以根据条件灵活构建SQL语句。
* 事务管理：MyBatis的事务管理可以通过Spring的声明式事务管理来实现。在Spring Boot中，可以使用@Transactional注解来声明事务边界。
* 异常处理：MyBatis在执行SQL操作时可能会遇到异常，如SQL执行错误、参数错误等。这些异常可以在Service层或Controller层捕获并转换为业务逻辑层可以理解的异常。

### 使用Mybatis对mysql数据库进行增删改查

#### 1.创建数据库

```mysql
CREATE TABLE student (
  id INT PRIMARY KEY AUTO_INCREMENT,  -- 学生ID，主键，自动递增
  name VARCHAR(50) NOT NULL,          -- 学生姓名，不为空
  gender ENUM('男', '女') NOT NULL,  -- 学生性别，枚举类型，不为空
  age INT,                            -- 学生年龄
  class_name VARCHAR(50)            -- 学生所在班级名称
);
 
INSERT INTO student (name, gender, age, class_name) VALUES ('张三', '男', 18, '高三一班');
INSERT INTO student (name, gender, age, class_name) VALUES ('李四', '男', 17, '高三二班');
INSERT INTO student (name, gender, age, class_name) VALUES ('王五', '女', 18, '高三一班');
INSERT INTO student (name, gender, age, class_name) VALUES ('赵六', '女', 17, '高三二班');
```

#### 2. 创建 controller, entity,mapper, service, resources/mapping包

#### 3. 编写实体类
```java
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private int id;
    private String name;
    private int age;
    private char gender;
    private String className;
}
```

#### 4. 在 mapper 包创建 StudentMapper.java

```java
@Mapper
@Repository
public interface StudentMapper {
    @Select("SELECT * FROM student WHERE gender = '女';")
    public List<Student> findGirl();

    @Select("SELECT * FROM student WHERE id = #{id};")
    List<Student> findById(int id);//不加public也可，因为interface中的方法都是公用的
}
```

@Mapper注解用于标记MyBatis的映射器接口。当Spring Boot项目启动时，它会自动扫描带有@Mapper注解的接口，并创建它们的全局代理实例。
@Repository注解是Spring框架提供的一个注解，用于标记数据访问层的组件。当Spring容器扫描到带有@Repository注解的接口时，它会自动创建其代理实例，并实现基于接口的依赖注入。

#### 5.StudentMapper.java 单元测试
```java
@Autowired
    public StudentMapper studentMapper;

    @Test
    void getGirl() {
        List<Student> students = studentMapper.findGirl();
        for (Student student : students) {
            System.out.println(student);
        }
    }
```
输出结果
```text
Student(id=3, name=王五, age=18, gender=女, className=null)
Student(id=4, name=赵六, age=17, gender=女, className=null)
```







