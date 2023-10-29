package com.example.water_cloud1.controller;

import com.example.water_cloud1.dao.missionDao;
import com.example.water_cloud1.pojo.mission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MissionController {

    @Autowired
    private missionDao missiondao;

    /**********************************任务管理***********************************************************/
    @GetMapping("mission_mana")
    public String MissionMana(Model model){
        List<mission> lsmission=missiondao.FindAll();
        model.addAttribute("missionsArr",lsmission);
        return "MissionManage";
    }
    /**********************************任务管理--根据ID删除任务***********************************************************/
    @GetMapping("/del_mission{M_Name}")
    public String DelMission(@PathVariable("M_Name")String M_Name){
        missiondao.DeleteById(M_Name);
        return "redirect:/mission_mana";
    }
    /**********************************任务管理--根据名称到达更新任务的页面***********************************************************/
    @GetMapping("/to_update_mission{M_Name}")
    public String ToUpdateMission(@PathVariable("M_Name")String M_Name, HttpSession session){
        mission now=missiondao.FindByName(M_Name);
        session.setAttribute("update_mission_pojo",now);
        return "redirect:/mission_update";
    }
    /**********************************任务管理--根据名称更新任务后返回查询信息页面**********************************************************/
    @PostMapping("update_mission")
    public String UpdateMission(@RequestParam("M_Name")String M_Name,
                            @RequestParam("M_Aerar")String M_Aerar,@RequestParam("M_Price")String M_Price,
                            @RequestParam("M_Sep") String M_Sep,@RequestParam("M_Time")String M_Time,
                            @RequestParam("M_Explain") String M_Explain,@RequestParam("M_Able") String M_Able){
        mission now=new mission(M_Name,M_Aerar,M_Price,M_Sep,M_Time,M_Explain,M_Able);
        missiondao.Update(now);
        return "redirect:/mission_mana";
    }
    /**********************************任务管理--新增任务***********************************************************/
    @PostMapping("add_mission")
    public String AddMission(@RequestParam("M_Name")String M_Name,
                         @RequestParam("M_Aerar")String M_Aerar,@RequestParam("M_Price")String M_Price,
                         @RequestParam("M_Sep") String M_Sep,@RequestParam("M_Time")String M_Time,
                         @RequestParam("M_Explain") String M_Explain,@RequestParam("M_Able")String M_Able){
        mission now=new mission(M_Name,M_Aerar,M_Price,M_Sep,M_Time,M_Explain,M_Able);
        missiondao.InsertMission(now);
        return "redirect:/mission_mana";
    }
    /**********************************搜索任务***********************************************************/
    @PostMapping ("/mission_search")
    public String SeachMission(@RequestParam("search_mission_M_Name")String M_Name,Model model){
        System.out.println("++++"+M_Name);
        List<mission>lss=new ArrayList<>();
        mission now=missiondao.FindByName(M_Name);
        lss.add(now);
        model.addAttribute("missionsArr",lss);
        return "MissionManage";
    }
}
