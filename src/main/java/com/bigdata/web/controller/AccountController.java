package com.bigdata.web.controller;

import com.bigdata.domain.Account;
import com.bigdata.service.AccountService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("findAll")
    @ResponseBody
    public List<Account> findAll(){
        return accountService.findAll();
    }

    @RequestMapping("save")
    public String save(Account account){
        accountService.saveAccount(account);
        return "forward:/account/findAll";
//return "success";
    }

    @RequestMapping("findSingle")
    @ResponseBody
    public List<Account> findSingle(String name, HttpServletRequest request, HttpServletResponse response){

        List<Account> single = accountService.findSingle(name);
        return single;
    }


    @RequestMapping("delete_name")
    public String delete(String name, HttpServletRequest request){

        List<Account> single = accountService.findSingle(name);
        if(single == null){
            request.setAttribute("message","用户名不存在,请重新输入!");
            return  "forward:../index.jsp";
        }

        Integer delete = accountService.delete(name);
        return "forward:/account/findAll";
    }

    @RequestMapping("update_s")
    public ModelAndView update(String name,HttpServletResponse response){
        List<Account> single = accountService.findSingle(name);
        Account account = single.get(0);
        ModelAndView update = new ModelAndView();
        //if(single == null){
        //     update.setViewName("index");
        //}
        update.setViewName("update");
        update.addObject("account",account);
        return update;
    }

    @RequestMapping("update")
    public String update(Account account){

        accountService.update(account);

        return "forward:../account/findAll";
    }


    @RequestMapping("findByExample")
    @ResponseBody
    public List<Account> findByExample(Account account){
        return accountService.findByExample(account);
    }

    @RequestMapping("findByPage")
    public ModelAndView findByPages(@RequestParam(value = "page",defaultValue = "1") Integer page,@RequestParam(value = "pageSize",defaultValue = "3") Integer pageSize){

        PageInfo byPages = accountService.findByPages(page, pageSize);
        ModelAndView mv = new ModelAndView();
        mv.addObject("pageInfo",byPages);
        mv.addObject("pageNum",page);
        mv.setViewName("list");
        return mv;
    }

    @RequestMapping("delete")
    public String delete(Integer id){
        accountService.delete_id(id);
        return "list";
    }


    @RequestMapping("saveUI")
    public String saveUI(Account account){
        return "saveOrUpdate";
    }


    @RequestMapping("updateUI")
    public ModelAndView updateUI(Integer id){
        Account account = accountService.findById(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("account",account);
        mv.setViewName("saveOrUpdate");
        return mv;
    }


    @RequestMapping("saveOrUpdate")
    public String updateUI(Account account){
       accountService.saveOrUpdate(account);
       return "redirect:/account/findByPage";
    }

}
