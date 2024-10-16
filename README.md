# SpringBoot3Guidance

一步步教你搭建基本的SpringBoot3框架，并实现基础工具类，便于以后个性化开发！

## 目录

### 1. 项目依赖
### 2. 初始化项目

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
spring.datasource.url=jdbc:mysql://localhost:3306/springboot3guidance
spring.datasource.username=root
spring.datasource.password=qQ135275033**
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
```

### Shift + F10 启动！

项目启动成功，去浏览器验证 http://localhost:8080/test

