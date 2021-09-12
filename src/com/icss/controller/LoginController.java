package com.icss.controller;

import com.icss.pojo.TPower;
import com.icss.pojo.TUserinfo;
import com.icss.service.UserService;
import com.icss.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class LoginController {
    @Autowired
    UserService userService;
    @RequestMapping("logincheck")
    public String logincheck(String user, String password, String imge, Model model, HttpServletRequest httpServletRequest){
        HttpSession session = httpServletRequest.getSession();
        String random = (String) session.getAttribute("random");
        Result<TUserinfo> result = userService.queryUserInfo(user,password);
        if(random.equalsIgnoreCase(imge)){
            if(result.getNumber()==3){
                //登录成功
                session.setAttribute("TUserinfo",(TUserinfo)result.getObject());
                Map<String, List<TPower>> map = userService.queryMenu((TUserinfo) result.getObject());
                session.setAttribute("map",map);
                return "index";
            }else{
                model.addAttribute("msg",result.getNumber());
            }
        }else{
            model.addAttribute("msg",0);
        }
        return "login";
    }
    @RequestMapping("logout.do")
    public String logout(HttpServletRequest request){
        request.getSession().setAttribute("userinfo",null);
        return "login";
    }
}
