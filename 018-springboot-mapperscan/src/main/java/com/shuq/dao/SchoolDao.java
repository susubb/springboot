package com.shuq.dao;


import com.shuq.model.Student;
import org.apache.ibatis.annotations.Param;


public interface SchoolDao {
    Student selectById(@Param("stuId") Integer id);
}
