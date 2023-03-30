package com.learning.system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Author:Jude
 * Date:2023-03-30 下午3:29
 */

@SpringBootApplication
@MapperScan("com.learning.system.mapper")
public class ServiceAuthApplication {
    public static void main(String[] args) {

        SpringApplication.run(ServiceAuthApplication.class,args);
    }
}
