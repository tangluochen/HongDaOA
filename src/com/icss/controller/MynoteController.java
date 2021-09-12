package com.icss.controller;

import com.icss.pojo.TMynote;
import com.icss.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MynoteController {
@Autowired
    ScheduleService scheduleService;
@RequestMapping("my_note.do")
    public String mynote(Model model){
    List<TMynote> tMynoteList = scheduleService.selectAllNotes();
    model.addAttribute("mynotelist",tMynoteList);
    return "mynoteshow";
}
}
