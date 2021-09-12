package com.icss.controller;

import com.icss.dao.TBranchinfoDao;
import com.icss.pojo.TBranchinfo;
import com.icss.service.UserService;
import com.icss.util.Page;
import com.icss.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;

@Controller
public class BranchController {

    @Autowired
    UserService userService;
    @RequestMapping("branch_management.do")
    public String branchmanagement(String pageNow,Model model,Integer n){
        int page;
        int pageSize = 5;
        if(pageNow==null){
            page = 1;
        }else{
            page = Integer.parseInt(pageNow);
        }

        Result<List<TBranchinfo>> result = userService.queryBranch(page,pageSize);

        model.addAttribute("branchmanagement",result.getObject());
        Page page1 = new Page(result.getNumber(),page);
        page1.setPageSize(pageSize);
       model.addAttribute("page",page1);
       if(n!=null){
           model.addAttribute("n",n);
       }
        return "branchmanagement";
    }
    @RequestMapping("searchBranch.do")
    public String searchBranch(String searchbranch ,Model model){


        Result<List<TBranchinfo>> result = userService.queryBranchByname(searchbranch);
        model.addAttribute("branchmanagement",result.getObject());
        Page page1 = new Page(result.getNumber(),1);

        model.addAttribute("page",page1);
        return "branchmanagement";
    }
    @RequestMapping("updatebranch.do")
    public String updatebranch(String id, String name, String shortname, Model model){
        model.addAttribute("id",id);
        model.addAttribute("name",name);
        model.addAttribute("shortname",shortname);
        return "updatebranch";
    }
    @RequestMapping("UpdateBranch.do")
    public String UpdateBranch(String branchid, String branchname1, String branchname2,HttpServletRequest request, HttpServletResponse response){
        TBranchinfo tBranchinfo = new TBranchinfo();
        tBranchinfo.settBranchinfoId((long) Integer.parseInt(branchid));
        tBranchinfo.settBranchinfoName(branchname1);
        tBranchinfo.settBranchinfoShortname(branchname2);
        userService.updateBranchInfo(tBranchinfo);
        return "forward:branch_management.do";
    }

    @RequestMapping("DeleteBranch.do")
    public String deleteBranch(String branchid,Model model) {
        try {
            userService.deleteBranch(Long.parseLong(branchid));
            model.addAttribute("n",1);
        } catch (Exception e) {
            model.addAttribute("n",0);
        }
        return "forward:branch_management.do";
    }

    @RequestMapping("/deleteAllBranch.do")
    public String deleteAllBranch(String [] branchid,Model model)
            throws Exception, IOException {
        for (String aLong : branchid) {
            try {
                userService.deleteBranch(Long.parseLong(aLong));
                model.addAttribute("n",1);
            } catch (Exception e) {
                model.addAttribute("n",0);
            }
        }

        return "forward:branch_management.do";
    }


    @RequestMapping("addbranch.do")
    public String addbranch(HttpServletRequest request){
//       String msg = (String) request.getAttribute("msg");
//       request.setAttribute("msg",msg);
        return "addbranch";
    }
    @RequestMapping("AddBranch.do")
    public String AddBranch(String branchid, String branchname1, String branchname2,HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        TBranchinfo tBranchinfo = new TBranchinfo();
        tBranchinfo.settBranchinfoId((long) Integer.parseInt(branchid));
        tBranchinfo.settBranchinfoName(branchname1);
        tBranchinfo.settBranchinfoShortname(branchname2);

        try {
            userService.addBranch(tBranchinfo);
            return "forward:branch_management.do";
        }catch (Exception e){
            e.printStackTrace();
            request.setAttribute("msg","机构名称重复");
            return "addbranch";
        }

    }
}
