package com.icss.controller;

import com.google.gson.Gson;
import com.icss.pojo.*;
import com.icss.service.AdminService;
import com.icss.service.UserService;
import com.icss.service.WorkTimeService;
import com.icss.util.Page;
import com.icss.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    AdminService adminService;
    @Autowired
    UserService userService;
    @Autowired
    WorkTimeService workTimeService;
    @RequestMapping("user_management.do")
    public String usermanagement(){
        return "forward:myProductPage.do";
    }
    @RequestMapping("myProductPage.do")
    public String myProductPage(String pageNow,Model model,Integer n){
        int page;
        int pageSize = 5;
        if(pageNow==null){
            page = 1;
        }else{
            page = Integer.parseInt(pageNow);
        }
        Result<List<TUserinfo>> result = adminService.queryUser(page,pageSize);

        model.addAttribute("users",result.getObject());
        Page page1 = new Page(result.getNumber(),page);
        page1.setPageSize(pageSize);
        model.addAttribute("page",page1);
        if(n!=null){
            model.addAttribute("n",n);
        }
        return "usershow";
    }
    @RequestMapping("usersearch.do")
    public String usersearch(String username1 ,String pageNow,Model model){
        int page;
        int pageSize = 5;
        if(pageNow==null){
            page = 1;
        }else{
            page = Integer.parseInt(pageNow);
        }
        Result<List<TUserinfo>> result =  adminService.queryUserByName(username1,page,pageSize);
        model.addAttribute("users",result.getObject());
        Page page1 = new Page(result.getNumber(),page);
        page1.setPageSize(pageSize);
        model.addAttribute("page",page1);
        model.addAttribute("username1",username1);
        return "usersearchshow";
    }

    @RequestMapping("userdelete.do")
    public String userdelete(String id,Model model){
        try {
            adminService.deleteAllUser(Integer.parseInt(id));
            model.addAttribute("n",1);
        } catch (Exception e) {
            model.addAttribute("n",0);
        }
        return "forward:myProductPage.do";
    }

    @RequestMapping("usersdelete.do")
    public String usersdelete(String ids,Model model){
        String[] array = ids.split(",");
        for (int i = 0; i < array.length; i++) {
            System.out.println("=====批量删除传递参数====");
            int id = Integer.parseInt(array[i]);
            try {
                adminService.deleteAllUser(id);
                model.addAttribute("n",1);
            } catch (Exception e) {
                model.addAttribute("n",0);
            }
        }
        return "forward:myProductPage.do";
    }

    @RequestMapping("useradd1.do")
    public String useradd1(Model model) throws ServletException, IOException {
        List<TBranchinfo> list2 = userService.queryAllBranch();
//        List<TDepartinfo> tDepartinfoList = userService.queryAllDepart();
//        model.addAttribute("departList",tDepartinfoList);
        model.addAttribute("branchList",list2);
        return "useradd";
    }
    @RequestMapping("useradd.do")
    @ResponseBody
    public String useradd(TUserinfo tUserinfo, TDepartinfo tDepartinfo, TRoleinfo tRoleinfo, TUserstate tUserstate){
        Result result = new Result();

        TUserinfo userinfo = adminService.selectTUserinfoByuname(tUserinfo.gettUserinfoName());
        if(userinfo==null){
            tUserinfo.settDepartinfo(tDepartinfo);
            tUserinfo.settRoleinfo(tRoleinfo);
            tUserinfo.settUserstate(tUserstate);
            adminService.addUser(tUserinfo);
            result.setNumber(200);
        }else{
            result.setNumber(500);
        }
        Gson gson = new Gson();

        return gson.toJson(result);
    }

    @RequestMapping(value="depart.do",method = RequestMethod.POST,produces = {"text/html;charset=utf-8"})
    @ResponseBody
    public String brankdepart(TBranchinfo tBranchinfo) throws IOException {
        List<TDepartinfo> list2 = adminService.queryDepartByBranch(tBranchinfo);
        Gson gosn =new Gson();
        String str = gosn.toJson(list2);
        System.out.println(str);
        return str;
    }
    @RequestMapping(value="userupdate1.do")
    public String userupdate1(Model model,String name){
//根据用户名查询所在部门，
        TUserinfo tUserinfo = adminService.selectTUserinfoByuname(name);
        List<TBranchinfo> list2 = userService.queryAllBranch();
        //查询所有部门，查询
        Long deptid = tUserinfo.gettDepartinfo().gettDepartinfoId();
        Long branchID =  adminService.queryBranchID(deptid);
        TBranchinfo tBranchinfo = new TBranchinfo();
        tBranchinfo.settBranchinfoId(branchID);
        if(branchID==null){
            branchID = Long.parseLong("0");
        }
        List<TDepartinfo> departinfoList = adminService.queryDepartByBranch(tBranchinfo);

        model.addAttribute("gender",tUserinfo.gettUserinfoGender());
        model.addAttribute("roleid", tUserinfo.gettRoleinfo().gettRoleinfoId());
        model.addAttribute("stateid",tUserinfo.gettUserstate().gettUserstateId());
        model.addAttribute("departid",deptid);
        model.addAttribute("branchList",list2);
        model.addAttribute("branchId",branchID);
        model.addAttribute("departList",departinfoList);
        return "userupdate";
    }
    @RequestMapping("userupdate.do")
    @ResponseBody
    public String userupdate(TUserinfo tUserinfo, TDepartinfo tDepartinfo, TRoleinfo tRoleinfo, TUserstate tUserstate){
//        tUserinfo.settDepartinfo(tDepartinfo);
//        tUserinfo.settRoleinfo(tRoleinfo);
//        tUserinfo.settUserstate(tUserstate);
//        adminService.updateUser(tUserinfo);
//        return "forward:myProductPage.do";

        Result result = new Result();

        TUserinfo userinfo = adminService.selectTUserinfoByuname(tUserinfo.gettUserinfoName());
        if(userinfo==null){
            tUserinfo.settDepartinfo(tDepartinfo);
            tUserinfo.settRoleinfo(tRoleinfo);
            tUserinfo.settUserstate(tUserstate);
            adminService.updateUser(tUserinfo);
            result.setNumber(200);
        }else{
            /**
             * 如果是自己的依旧要更新
             */
            if(userinfo.gettUserinfoId()==tUserinfo.gettUserinfoId()){
                tUserinfo.settDepartinfo(tDepartinfo);
                tUserinfo.settRoleinfo(tRoleinfo);
                tUserinfo.settUserstate(tUserstate);
                adminService.updateUser(tUserinfo);
                result.setNumber(200);
            }else
            result.setNumber(500);
        }
        Gson gson = new Gson();

        return gson.toJson(result);
    }

    @RequestMapping("sign.do")
    public String sign(HttpServletRequest request,Model model){
        TUserinfo tUserinfo = (TUserinfo) request.getSession().getAttribute("TUserinfo");
        List<TManualsign> tManualsignList = userService.selectSignByUser(tUserinfo.gettUserinfoId());
        model.addAttribute("signlist",tManualsignList);
        return "signshow";
    }

    @RequestMapping("manualsign.do")
    public String ms(Model model){
        List<TManualsign> tManualsignList = userService.selectSign();
        model.addAttribute("signlist",tManualsignList);
        return "signshow";
    }
    @RequestMapping("manualsign_check.do")
    public String mucheck(){
        return "adminsign";
    }
    @RequestMapping("signsearch.do")
    public String signsearcc(String username1,Model model){
        List<TManualsign> tManualsignList = userService.selectSignByUsername(username1);
        model.addAttribute("signlist",tManualsignList);
        return "adminsign";
    }
    @RequestMapping(value="signin.do",produces = {"text/html;charset=utf-8"})
    public String sin(HttpServletRequest request){

        //查询当天有没有签到，有就更新，没有，就添加
        TUserinfo tUserinfo = (TUserinfo) request.getSession().getAttribute("TUserinfo");
        long userId = tUserinfo.gettUserinfoId();
        //先搜索上班或工作时间
        int status = workTimeService.queryWokeTime();
        //单卡是上班还是下班还是迟到了
        TManualsign tManualsign = null;
        switch (status){
            case 1:
                //搜索上班是否有打卡记录
                tManualsign = userService.querySignByStatus(1,userId);
                if(tManualsign==null){
                    userService.insertSign(userId,status);
                }else{
                    //更新
                    userService.updateTime(tManualsign.gettManualsignId());
                }
                break;
            case 2:
                //搜索下班是否有打卡记录
                tManualsign = userService.querySignByStatus(2,userId);
                if(tManualsign==null){
                    userService.insertSign(userId,status);
                }else{
                    //更新
                    userService.updateTime(tManualsign.gettManualsignId());
                }
                break;
            case 3:
                //搜索上班是否有打卡记录
                tManualsign = userService.querySignByStatus(1,userId);
                if(tManualsign==null){
                    TManualsign m = userService.querySignByStatus(3,userId);
                    if(m==null){
                        userService.insertSign(userId,status);
                    }
                }
                break;
        }
        return "forward:sign.do";
    }
}
