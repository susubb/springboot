package com.shuq;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * @MapperScan:找到Dao接口和Mapper文件
 *  basePackages：DaO接口所在的包名
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.shuq.dao","com.shuq.mapper"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
