package com.example.water_cloud1.dao;

import com.example.water_cloud1.pojo.entry;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface entryDao {
    @Select("select * from entry")
    List<entry> findAll();

    @Select("select * from entry where equipment_id=#{equipment_id}")
    entry FindById(String equipment_id);

    @Insert("insert into entry(name,equipment_id,settlement_flow,cumulative_flow,Last_use,water_meter_balance," +
            "equipment_status,communication_status,reading_status,operation_time)" + "values(#{name},#{equipment_id},#{settlement_flow},#{cumulative_flow},#{Last_use},#{water_meter_balance},#{equipment_status},#{communication_status},#{reading_status},#{operation_time})")
    int InsertEntry(entry entry);

    @Delete("delete from entry where equipment_id=#{equipment_id}")
    int DeleteById(String equipment_id);

    @Update("update entry set name=#{name},equipment_id=#{equipment_id},settlement_flow=#{settlement_flow},cumulative_flow=#{cumulative_flow},Last_use=#{Last_use},water_meter_balance=#{water_meter_balance},equipment_status=#{equipment_status},communication_status=#{communication_status},reading_status=#{reading_status},operation_time=#{operation_time}  where equipment_id=#{equipment_id}")
    int Update(entry uu);

}
