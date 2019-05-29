package com.bigdata.web.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


//自定义拦截器,在用户操作之前进行拦截判断是否登录,如果登录了直接放行返回true,未登录跳转到登录页面并提示
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        //1.判断如果是登录操作直接放行
        String uri = request.getRequestURI();
        if (uri != null && !uri.trim().equals("") && uri.contains("login")) {
            return true;
        }
        //2.如果是已登录直接放行
        Object username = request.getSession().getAttribute("username");
        if (username != null) {
            return true;
        }
        //3.其他的拦截
        request.getSession().setAttribute("message", "请登录后再操作");
        try {
            response.sendRedirect("/login.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
