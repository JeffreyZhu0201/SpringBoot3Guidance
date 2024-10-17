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

