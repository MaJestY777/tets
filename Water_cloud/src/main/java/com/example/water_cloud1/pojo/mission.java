package com.example.water_cloud1.pojo;

import lombok.Data;

@Data
public class mission {
    private String M_Name;
    private String M_Aerar;
    private String M_Price;
    private String M_Sep;
    private String M_Time;
    private String M_Explain;
    private String M_Able;

    public mission(String M_Name, String M_Aerar, String M_Price, String M_Sep, String M_Time, String M_Explain, String M_Able) {
        this.M_Name = M_Name;
        this.M_Aerar = M_Aerar;
        this.M_Price = M_Price;
        this.M_Sep = M_Sep;
        this.M_Time = M_Time;
        this.M_Explain = M_Explain;
        this.M_Able = M_Able;
    }
}
