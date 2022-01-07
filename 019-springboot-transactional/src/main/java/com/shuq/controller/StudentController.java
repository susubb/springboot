package com.shuq.controller;

import com.shuq.model.Student;
import com.shuq.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class StudentController {

    @Resource
    private StudentService service;

    @RequestMapping("/addStudent")
    @ResponseBody
    public String addStudent(String name,Integer age){
        Student s1 = new Student();
        s1.setAge(age);
        s1.setName(name);

        int rows = service.addStudent(s1);
        return "添加学生：" + rows;
    }

    @RequestMapping("/queryStudent")
    @ResponseBody
    public String queryStudent(String name,Integer age){
        Student s1 = new Student();
        s1.setAge(age);
        s1.setName(name);

        int rows = service.addStudent(s1);
        return "添加学生：" + rows;
    }
}
