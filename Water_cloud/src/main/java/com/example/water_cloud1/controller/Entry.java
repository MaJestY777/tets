package com.example.water_cloud1.controller;

import com.example.water_cloud1.dao.entryDao;
import com.example.water_cloud1.pojo.entry;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class Entry {
    @Autowired
    private entryDao entrydao;
    /**********************************信息管理***********************************************************/
    @GetMapping("entry_mana")
    public String EntryMana(Model model, @RequestParam(name = "page", required = false,defaultValue = "1") int page,
    @RequestParam(name = "size", required = false,defaultValue = "10") int size){
        List<entry> entryList= entrydao.findAll();
        int startIndex = (page - 1) * size;
        int endIndex = Math.min(startIndex + size, entryList.size());
        List<entry> lscar = entryList.subList(startIndex, endIndex);
        model.addAttribute("entryArr",lscar);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", (int) Math.ceil(entryList.size() / (double) size));
        return "EntryManager";
    }
    /**********************************信息管理--新增录入***********************************************************/
    @PostMapping("add_entry")
    public String add_entry(@RequestParam("name")String name,
                         @RequestParam("equipment_id")String equipment_id,@RequestParam("settlement_flow")String settlement_flow,
                         @RequestParam("cumulative_flow") String cumulative_flow,@RequestParam("Last_use")String Last_use,
                            @RequestParam("water_meter_balance")String water_meter_balance,
                            @RequestParam("equipment_status")String equipment_status,
                            @RequestParam("communication_status")String communication_status,
                            @RequestParam("reading_status")String reading_status,
                            @RequestParam("operation_time")String operation_time){
        entry now=new entry(name,equipment_id,settlement_flow,cumulative_flow,
                Last_use,water_meter_balance,equipment_status,communication_status,reading_status,operation_time);
        entrydao.InsertEntry(now);
        return "redirect:/entry_mana";
    }
    /**********************************搜索信息***********************************************************/
    @PostMapping ("/entry_seach")
    public String SeachEntry(@RequestParam("seach_entry_equipment_id")String equipment_id,Model model){
        System.out.println("++++"+equipment_id);
        List<entry> lss=new ArrayList<>();
        entry now=entrydao.FindById(equipment_id);
        lss.add(now);
        model.addAttribute("entryArr",lss);
        return "EntryManager";
    }
    /**********************************信息管理--根据ID删除信息***********************************************************/
    @GetMapping("/del_entry{equipment_id}")
        public String DelEntry(@PathVariable("equipment_id")String equipment_id){
        entrydao.DeleteById(equipment_id);
        return "redirect:/entry_mana";
    }
    /**********************************任务管理--根据ID到达更新任务的页面***********************************************************/
    @GetMapping("/to_update_entry{equipment_id}")
    public String ToUpdateEntry(@PathVariable("equipment_id")String equipment_id, HttpSession session){
        entry now=entrydao.FindById(equipment_id);
        session.setAttribute("update_entry_pojo",now);
        return "redirect:/entry_update";
    }
    /**********************************任务管理--根据ID更新任务后返回查询信息页面**********************************************************/
    @PostMapping("update_entry")
    public String UpdateMission(@RequestParam("name")String name,
                                @RequestParam("equipment_id")String equipment_id,@RequestParam("settlement_flow")String settlement_flow,
                                @RequestParam("cumulative_flow") String cumulative_flow,@RequestParam("Last_use")String Last_use,
                                @RequestParam("water_meter_balance")String water_meter_balance,
                                @RequestParam("equipment_status")String equipment_status,
                                @RequestParam("communication_status")String communication_status,
                                @RequestParam("reading_status")String reading_status,
                                @RequestParam("operation_time")String operation_time){
        entry now=new entry(name,equipment_id,settlement_flow,cumulative_flow,Last_use,
                water_meter_balance,equipment_status,communication_status,reading_status,operation_time);
        entrydao.Update(now);
        return "redirect:/entry_mana";
    }
}
