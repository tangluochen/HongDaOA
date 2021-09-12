package com.icss.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;


@Controller
public class JspController {
    @RequestMapping(value="loginservlet.do")
    public String loginservlet(HttpServletRequest httpServletRequest){
        return "login";
    }
    @RequestMapping("welcome")
    public String welcome(){
        return "welcome";
    }

    
}
