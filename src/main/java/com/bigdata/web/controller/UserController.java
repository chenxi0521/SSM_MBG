package com.bigdata.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/login")
    public String login(String username, String password, HttpSession session){
        //1.模拟查询数据库并校验用户名密码
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password) ){
            //帐号密码为空
            session.setAttribute("message","请输入帐号密码");
            return "forward:/login.jsp";
        }
        if(username.equals("admin") & password.equals("1234")) {
            //登陆成功
            session.setAttribute("username",username);
            return "forward:/index.jsp";
        }
        session.setAttribute("message","帐号密码错误");
        return "forward:/login.jsp";
    }
}
