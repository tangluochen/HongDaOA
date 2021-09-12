package com.icss.controller;

import com.icss.pojo.TBranchinfo;
import com.icss.pojo.TDepartinfo;
import com.icss.pojo.TUserinfo;
import com.icss.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class DepartController {
    @Autowired
    UserService userService;
    @RequestMapping("depart_management.do")
    public String departmanagement(Model model){
        List<TDepartinfo> listDepartPojo = userService.queryAllDepart();
        int departcount = listDepartPojo.size();
        model.addAttribute("listDepartPojo",listDepartPojo);
        model.addAttribute("departcount",departcount);
        return "showdepart";
    }

    @RequestMapping("delete.do")
    @ResponseBody
    public String delete(String departid){
        userService.deleteDepartByDid(Long.parseLong(departid));
        return "showdepart";
    }

    @RequestMapping("deleteAll.do")
    @ResponseBody
    public String deleteAll(String text){
        String[] t = text.split(",");
        userService.deleteAllDeparts(t);
        return "showdepart";
    }

    @RequestMapping("updatedepart.do")
    public String updatedepart(String id, Model model){
        String s =id;
        List<TUserinfo> list = userService.queryAllUser();
        List<TBranchinfo> list2 = userService.queryAllBranch();
        List<TDepartinfo> listDepartPojo = userService.queryAllDepart();
        for (TDepartinfo departPojo : listDepartPojo) {
            if (departPojo.gettDepartinfoId()==Integer.parseInt(s)) {
                model.addAttribute("departPojo", departPojo);
                model.addAttribute("userBean", list);
                model.addAttribute("branchBean", list2);
            }
        }
        return "updatedepart";
    }
    @RequestMapping("update.do")
    @ResponseBody
    public String update(TDepartinfo tDepartinfo,TBranchinfo tBranchinfo,TUserinfo tUserinfo){
        tDepartinfo.settUserinfo(tUserinfo);
        tDepartinfo.settBranchinfo(tBranchinfo);
        userService.updateDepart(tDepartinfo);
        return "showdepart";
    }

    @RequestMapping("adddepart.do")
    public String adddepart(Model model){
        List<TUserinfo> list = userService.queryAllUser();
        List<TBranchinfo> list2 = userService.queryAllBranch();
//        List<TDepartinfo> listDepartPojo = userService.queryAllDepart();
//        model.addAttribute("departP", listDepartPojo);
        model.addAttribute("userB", list);
        model.addAttribute("branchB", list2);
        return "adddepart";
    }
    @RequestMapping("add.do")
    @ResponseBody
    public String add(TDepartinfo tDepartinfo,TBranchinfo tBranchinfo,TUserinfo tUserinfo){
        tDepartinfo.settUserinfo(tUserinfo);
        tDepartinfo.settBranchinfo(tBranchinfo);
        userService.addDepart(tDepartinfo);
        return "depart_management.do";
    }
}
