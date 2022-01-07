package com.shuq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
public class JspController {

    /*public String doJsp(HttpServletRequest request){
        request.setAttribute("data","Springboot使用jsp");
        //视图的逻辑名称
        return "index";
    }*/


    /**
     * ModelAndView:
     * @param model
     * @return
     */

    @RequestMapping("/myjsp")
    public String doJsp(Model model){
        //把数据放入到request作用域
        model.addAttribute("data","Springboot使用jsp");

        //视图的逻辑名称
        return "index";
    }
}
