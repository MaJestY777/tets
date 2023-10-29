package com.example.water_cloud1.pojo;
import lombok.Data;
import java.util.Date;
@Data
public class entry {
    private String name;
    private String equipment_id;
    private String settlement_flow;
    private String cumulative_flow;
    private String Last_use;
    private String water_meter_balance;
    private String equipment_status;
    private String communication_status;
    private String reading_status;
    private String operation_time;

    public entry(String name, String equipment_id, String settlement_flow, String cumulative_flow, String last_use, String water_meter_balance, String equipment_status, String communication_status, String reading_status, String operation_time) {
        this.name = name;
        this.equipment_id = equipment_id;
        this.settlement_flow = settlement_flow;
        this.cumulative_flow = cumulative_flow;
        this.Last_use = last_use;
        this.water_meter_balance = water_meter_balance;
        this.equipment_status = equipment_status;
        this.communication_status = communication_status;
        this.reading_status = reading_status;
        this.operation_time = operation_time;
    }


    @Override
    public String toString() {
        return "entry{" +
                ", name='" + name + '\'' +
                ", equipment_id='" + equipment_id + '\'' +
                ", settlement_flow='" + settlement_flow + '\'' +
                ", cumulative_flow='" + cumulative_flow + '\'' +
                ", Last_use='" + Last_use + '\'' +
                ", water_meter_balance='" + water_meter_balance + '\'' +
                ", equipment_status='" + equipment_status + '\'' +
                ", communication_status='" + communication_status + '\'' +
                ", reading_status='" + reading_status + '\'' +
                ", operation_time='" + operation_time + '\'' +
                '}';
    }
}
