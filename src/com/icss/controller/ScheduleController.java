package com.icss.controller;

import com.icss.pojo.TMeetinginfo;
import com.icss.pojo.TSchedule;
import com.icss.service.ScheduleService;
import com.icss.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ScheduleController {
    @Autowired
    ScheduleService scheduleService;
    @RequestMapping("my_schedule.do")
    public String myschedule(Integer pageNow,Model model){
        int count = scheduleService.selectAllscheduleCounts();
        if(pageNow==null){
            pageNow = 1;
        }
        Page page = new Page(count,pageNow);
        List<TSchedule> tScheduleList = scheduleService.selectAllSchedules(page);
        model.addAttribute("MySchedule",tScheduleList);
        model.addAttribute("page",page);
        model.addAttribute("count",count);
        return "myschedule";
    }
    @RequestMapping("schedulesearch.do")
    public String schedulesearch(String schedulename1,Integer pageNow,Model model){
        int count = scheduleService.selectAllscheduleCountsByname(schedulename1);
        if(pageNow==null){
            pageNow = 1;
        }
        Page page = new Page(count,pageNow);
        List<TSchedule> tScheduleList =scheduleService.selectAllSchedulesByname(schedulename1,page);
        model.addAttribute("MySchedule",tScheduleList);
        model.addAttribute("page",page);
        model.addAttribute("count",count);
        model.addAttribute("schedulename1",schedulename1);
        return "schedulesearchshow";
    }
    @RequestMapping("addmyscheduleforword.do")
    public String addschedule(Model model){
        List<TMeetinginfo> tMeetinginfoList =scheduleService.queryAllMeetingInfo();
        model.addAttribute("meetingList",tMeetinginfoList);
        return "addmyschedule";
    }

    @RequestMapping("addmyschedule.do")
    public String addmyschedule(TSchedule tSchedule,TMeetinginfo tMeetinginfo,Model model){
        tSchedule.settMeetinginfo(tMeetinginfo);
        scheduleService.insertSchedule(tSchedule);
        return "forward:my_schedule.do";
    }
    @RequestMapping("selectupdate.do")
    public String selectupdate(Long tScheduleId,Model model){
        TSchedule tSchedule = scheduleService.selectScheduleByid(tScheduleId);
        model.addAttribute("myschedule",tSchedule);
        return "updatemyschedule";
    }
    @RequestMapping("updateMySchedule.do")
    public String updateMySchedule(TSchedule tSchedule,TMeetinginfo tMeetinginfo){
        tSchedule.settMeetinginfo(tMeetinginfo);
        scheduleService.updateSchedule(tSchedule);
        return "forward:my_schedule.do";
    }
    @RequestMapping("DeleteMySchedule.do")
    @ResponseBody
    public String DeleteMySchedule(long tScheduleId){
        scheduleService.deleteSchedule(tScheduleId);
        return "forward:my_schedule.do";
    }
    @RequestMapping("schedulessdelete.do")
    public String usersdelete(String ids,Model model){
        String[] array = ids.split(",");
        for (int i = 0; i < array.length; i++) {
            System.out.println("=====批量删除传递参数====");
            int id = Integer.parseInt(array[i]);
                scheduleService.deleteSchedule(id);
        }
        return "forward:my_schedule.do";
    }
}
