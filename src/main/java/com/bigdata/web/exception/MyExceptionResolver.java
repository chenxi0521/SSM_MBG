package com.bigdata.web.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//自定义异常处理器
public class MyExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object Hanlder, Exception ex) {
        //1.记录日志
        ex.printStackTrace();
        //2.根据异常类型进行邮件通知/短信通知
        //...........
        //3.实际中我们可以根据异常的不同类型给用户友好提示
        ModelAndView mv = new ModelAndView();
        mv.setViewName("error");
        mv.addObject("message","服务器忙,请稍后再试");
        return mv;
    }
}
