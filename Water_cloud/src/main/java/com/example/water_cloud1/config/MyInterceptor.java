package com.example.water_cloud1.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component //注册bean
public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        String uri = request.getRequestURI();
        Object loginUser = request.getSession().getAttribute("admin");
        if (loginUser==null) {
            request.setAttribute("msg", "请先登录");
            request.getRequestDispatcher("/login").forward(request, response);
            return false;
        }
        return true;
    }
}
