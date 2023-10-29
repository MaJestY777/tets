package com.example.water_cloud1.dao;

import com.example.water_cloud1.pojo.mission;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface missionDao {
    /********************查找所有任务*****************************************************/
    @Select("select * from mission_information")
    List<mission> FindAll();
    /********************根据名称查找任务*****************************************************/
    @Select("select * from mission_information where M_Name=#{pos}")
    mission FindByName(String pos);
    /********************根据ID删除用任务************************************************/
    @Delete("delete from mission_information where M_Name=#{M_Name}")
    int DeleteById(String M_Name);
    /********************插入任务************************************************/
    @Insert("insert into mission_information(M_Name,M_Aerar,M_Price,M_Sep,M_Time,M_Explain,M_Able)" + "values(#{M_Name},#{M_Aerar},#{M_Price},#{M_Sep},#{M_Time},#{M_Explain},#{M_Able})")
    int InsertMission(mission mission);
    /********************更新用户***********************************************/
    @Update("update mission_information set M_Name=#{M_Name},M_Aerar=#{M_Aerar},M_Price=#{M_Price},M_Sep=#{M_Sep},M_Time=#{M_Time},M_Explain=#{M_Explain},M_Able=#{M_Able} where M_Name=#{M_Name}")
    int Update(mission uu);
    /********************模糊查询任务***********************************************/
    @Select("select * from mission_information where M_Name like CONCAT('%',#{key},'%');")
    List<mission>FindAllByName(String key);
}
