package com.icss.controller;

import com.icss.pojo.*;
import com.icss.service.AdminService;
import com.icss.service.ScheduleService;
import com.icss.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ScheduleobController {
    @Autowired
    UserService userService;
    @Autowired
    AdminService adminService;
    @Autowired
    ScheduleService scheduleService;
    @RequestMapping("depart_schedule.do")
    public String departschedule(HttpServletRequest request ,Model model){
//        List<TBranchinfo> list2 = userService.queryAllBranch();
//        List<TDepartinfo> tDepartinfoList = userService.queryAllDepart();
//        List<TUserinfo> tUserinfoList = adminService.selectAlluser();
//        model.addAttribute("departlist",tDepartinfoList);
//        model.addAttribute("branchlist",list2);
//        model.addAttribute("userlist",tUserinfoList);
        TUserinfo tUserinfo = (TUserinfo) request.getSession().getAttribute("TUserinfo");
        if(tUserinfo.gettDepartinfo().gettDepartinfoId()!=null){
            List<TScheduleob> list = scheduleService.queryAllScheduleOB(tUserinfo.gettDepartinfo().gettDepartinfoId());
            model.addAttribute("scheduleoblist",list);
        }else{
            model.addAttribute("n",1);
        }

        return "departsch";
    }
    @RequestMapping("adddeptschedule.do")
    public String adddepartschedule(HttpServletRequest request ,Model model){
        List<TSchedule> list = scheduleService.queryAllDepartSchedule();
        model.addAttribute("schedulelist",list);

        return "departSchedule";
    }
    @RequestMapping("addscheduleob.do")
    public String addscheduleob(Long scheduleId){
        TSchedule tSchedule = scheduleService.selectScheduleByid(scheduleId);
        String username = tSchedule.gettScheduleCreateuser();
        TUserinfo userinfo = adminService.selectTUserinfoByuname(username);
        long userid = userinfo.gettUserinfoId();
        long departid = userinfo.gettDepartinfo().gettDepartinfoId();
        TDepartinfo tDepartinfo = userService.queryDepartByid(departid);
        long branchid = tDepartinfo.gettBranchinfo().gettBranchinfoId();
        scheduleService.addScheduleob(departid,scheduleId,userid,branchid);
        return "forward:depart_schedule.do";
    }

}
