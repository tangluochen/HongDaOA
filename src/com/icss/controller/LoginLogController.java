package com.icss.controller;

import com.icss.pojo.TLoginlog;
import com.icss.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class LoginLogController {
    @Autowired
    LogService logService;
        @RequestMapping("login_log.do")
    public String loginlog(Model model){
            List<TLoginlog> loginlogList = logService.queryAllLog();
            model.addAttribute("loginloglist",loginlogList);
            return "loginlogshow";
        }
        @RequestMapping("logdelete.do")
    public String logdelete(Long id){
            logService.removeLog(id);
            return "forward:login_log.do";
        }
}
