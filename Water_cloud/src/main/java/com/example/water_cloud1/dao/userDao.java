package com.example.water_cloud1.dao;

import org.apache.ibatis.annotations.*;
import com.example.water_cloud1.pojo.user;

import java.util.List;

@Mapper
public interface userDao {
     /********************根据姓名查找用户*****************************************************/
    @Select("select * from user where uname=#{pos}")
    user FindByName(String pos);
}
