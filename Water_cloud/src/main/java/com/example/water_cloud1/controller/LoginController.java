package com.example.water_cloud1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.water_cloud1.dao.userDao;
import com.example.water_cloud1.pojo.user;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private userDao userdao;

    @PostMapping("login_check")
    public String LoginCheck(@RequestParam("username")String uu, @RequestParam("password")String pp, Model model, HttpSession session){
        user now=userdao.FindByName(uu);
        if(now==null){
            model.addAttribute("msg", "用户名不存在，请先注册");
            return "login";
        }
        if(!pp.equals(now.getPassword())){
            model.addAttribute("msg", "用户名或密码错误");
            return "login";
        }

        if(now.getType().equals("管理员")){
            session.setAttribute("admin", "管理员");
            session.setAttribute("id", now.getId());
            System.out.println("登录成功");
            return "redirect:/admin";
        }else{
            session.setAttribute("admin", "普通用户");
            session.setAttribute("id", now.getId());
            System.out.println("登录成功");
            return "redirect:/index";
        }
    }

}
