package com.shuq.service.impl;

import com.shuq.dao.StudentMapper;
import com.shuq.model.Student;
import com.shuq.service.StudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentMapper studentMapper;

    /**
     *@Transactional：表示方法有事务支持
     *  默认：使用库的隔离级别，  REQUIRED   传播行为：超时 -1
     *  抛出运行时异常，回滚事务
     */
    @Transactional
    @Override
    public int addStudent(Student student) {
        System.out.println("业务方法addStudent");
        int rows = studentMapper.insert(student);
        System.out.println("执行sql语句");

        //抛出一个运行时异常，目的是回滚事务
        //int m = 10/0;


        return rows;
    }
}
