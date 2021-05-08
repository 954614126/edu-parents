package com.definesys.edu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Copyright: Shanghai Definesys Company.All rights reserved.
 * @Description:
 * @author: shuaishuai.li
 * @since: 2021/05/03 11:44
 * @history: 1.2021/05/03 created by shuaishuai.li
 */
@SpringBootApplication
@MapperScan("com.definesys.edu.mapper")
@ComponentScan("com.definesys")
public class EduApplication {
    public static void main(String[] args) {
        SpringApplication.run(EduApplication.class,args);
    }
}