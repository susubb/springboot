package com.shuq.dao;


import com.shuq.model.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


public interface StudentDao {
    Student selectById(@Param("stuId") Integer id);
}
