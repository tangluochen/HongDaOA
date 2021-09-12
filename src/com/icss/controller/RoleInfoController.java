package com.icss.controller;

import com.icss.pojo.TRoleinfo;
import com.icss.pojo.TUserinfo;
import com.icss.pojo.TUserstate;
import com.icss.service.AdminService;
import com.icss.service.RoleInfoService;
import com.icss.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Controller
public class RoleInfoController {
    @Autowired
    RoleInfoService roleInfoService;
    @Autowired
    UserService userService;
    @Autowired
    AdminService adminService;
    @RequestMapping("role_management.do")
    public String findRole(HttpServletRequest request){
        Map<TRoleinfo, List<TUserinfo>> maprole=new LinkedHashMap<>();
        List<TRoleinfo> listrole =roleInfoService.findRole();
        for (TRoleinfo roleInfoBean : listrole) {
            List<TUserinfo> listUser = userService.queryUserByRole(roleInfoBean.gettRoleinfoId());
            maprole.put(roleInfoBean, listUser);
        }
        request.getSession().setAttribute("maprole", maprole);
        return "roleinfo";
    }
    @RequestMapping("product-category-add.do")
    public String go(){
        return "admin-role-add";
    }
    @RequestMapping("rolefind")
    public String findUserRole(HttpServletRequest request){
        String id=request.getParameter("userid");

        System.out.println(id);
        TUserinfo userBean=userService.findUserRole(Long.parseLong(id));
        System.out.println(userBean);
        request.getSession().setAttribute("userBean", userBean);
        return "roleupdate";

    }
    @RequestMapping("roleupdate.do")
    public String updateRole(HttpServletRequest request){
//        long roleid=Long.parseLong(request.getParameter("role"));
//        long stateid=Long.parseLong(request.getParameter("state"));
        long roleid;
        long stateid;
        if("系统管理员".equals(request.getParameter("role"))){
            roleid = 1;
        }else{
            roleid=2;
        }
        if("正常状态".equals(request.getParameter("state"))){
            stateid=1;
        }else stateid=0;
        TRoleinfo tRoleinfo = new TRoleinfo();
        tRoleinfo.settRoleinfoId(roleid);
        TUserstate tUserstate = new TUserstate();
        tUserstate.settUserstateId(stateid);
        TUserinfo userBean=(TUserinfo) request.getSession().getAttribute("userBean");
        userBean.settRoleinfo(tRoleinfo);
        userBean.settUserstate(tUserstate);
        adminService.updateUser(userBean);
        return "welcome";

    }
}
