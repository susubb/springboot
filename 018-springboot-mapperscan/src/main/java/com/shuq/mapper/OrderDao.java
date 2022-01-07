package com.shuq.mapper;


import com.shuq.model.Student;
import org.apache.ibatis.annotations.Param;


public interface OrderDao {
    Student selectById(@Param("stuId") Integer id);
}
