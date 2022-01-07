package com.shuq;

import com.shuq.service.HelloService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Resource
    private HelloService helloService;

    public static void main(String[] args) {
        System.out.println("准备创建容器对象");
        //创建容器对象
        SpringApplication.run(Application.class, args);
        System.out.println("容器对象创建之后");
    }

    @Override
    public void run(String... args) throws Exception {
        String str = helloService.sayHello("lisi");
        System.out.println(str);
        //可做自定义操作，比如读取文件，数据库等
        System.out.println("在容器对象创建后，执行方法");
    }
}
