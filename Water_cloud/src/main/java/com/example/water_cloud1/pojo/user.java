package com.example.water_cloud1.pojo;

import lombok.Data;

@Data
public class user {
    private int id;
    private String uname;
    private String password;
    private String idcard;
    private String type;
    private String phonenum;
    private String name;

    public user(String uname, String password, String idcard, String type, String phonenum, String name) {
        this.uname = uname;
        this.password = password;
        this.idcard = idcard;
        this.phonenum=phonenum;
        this.type = type;
        this.name=name;
    }

    @Override
    public String toString() {
        return "user{" +
                "id=" + id +
                ", uname='" + uname + '\'' +
                ", password='" + password + '\'' +
                ", idcard='" + idcard + '\'' +
                ", type='" + type + '\'' +
                ", phonenum='" + phonenum + '\'' +
                '}';
    }
}
