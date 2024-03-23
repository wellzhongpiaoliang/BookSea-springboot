package com.seabooks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
// @SpringBootApplication(exclude= {DataSourceAutoConfiguration.class}) // 如果加了mybatis的插件,启动时就必须连接数据库,这里可以设置不连接数据库
public class SeaBooksApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeaBooksApplication.class, args);
    }

}
