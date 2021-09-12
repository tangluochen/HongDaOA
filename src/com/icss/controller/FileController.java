package com.icss.controller;

import com.icss.pojo.TFileinfo;
import com.icss.pojo.TFiletypeinfo;
import com.icss.pojo.TUserinfo;
import com.icss.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.List;

@Controller
public class FileController {
//file_management.do文件管理
    @Autowired
    FileService fileService;
    @RequestMapping("file_management.do")
    public String filemanagement(Model model,Integer n){
        List<TFileinfo> tFileinfoList = fileService.queryAllFile();
        int count = fileService.queryFileCount();
        model.addAttribute("showfilelist",tFileinfoList);
        model.addAttribute("count",count);
        if(n!=null){
            model.addAttribute("n",n);
        }
        return "showfileinfo";
    }
    //trash.do回收站
    @RequestMapping("trash.do")
    public String trash(Model model,Integer n){
        List<TFileinfo> tFileinfoList = fileService.queryAllTrash();
        int count = fileService.queryTrash();
        model.addAttribute("showfilelist",tFileinfoList);
        model.addAttribute("count",count);
        if(n!=null){
            model.addAttribute("n",n);
        }
        return "trashshow";
    }
    //文件搜索file_search.do
    @RequestMapping("file_search.do")
    public String filesearch(){
        return "showfileinfo";
    }

    @RequestMapping("filesearch.do")
    public String filesearch(String filename,Model model){
        List<TFileinfo> fileinfoList = fileService.selectAllFilesByName(filename);
        int count = fileService.queryTrash();
        model.addAttribute("showfilelist",fileinfoList);
        model.addAttribute("count",count);
        return "showfileinfo";
    }

    @RequestMapping("trashsearch.do")
    public String trashsearch(String filename,Model model){
        List<TFileinfo> fileinfoList = fileService.selectAllTrashByName(filename);
        int count = fileService.queryTrash();
        model.addAttribute("showfilelist",fileinfoList);
        model.addAttribute("count",count);
        return "trashshow";
    }
    /**
     * 文件上传
     */
    @RequestMapping("fileupload1.do")
    public String fileUpload(){
        return "fileupload";

    }
//@RequestParam("myfiles")
    @RequestMapping("fileupload.do")
    public String fileupload(String fileremark, MultipartFile myfiles, HttpServletRequest request, Model model){
        String fileName = myfiles.getOriginalFilename();
       String fileTypeName = fileName.split("\\.")[1];
       //根据文件类型名字，搜索文件类型id
        Integer typeid = fileService.queryIdBytypename(fileTypeName);
        if(typeid == null){
            model.addAttribute("msg",0);
            return "fileupload";
        }
        TFiletypeinfo filetypeinfo = new TFiletypeinfo();
        filetypeinfo.settFiletypeinfoId(Long.parseLong(typeid.toString()));

        TUserinfo tUserinfo = (TUserinfo) request.getSession().getAttribute("TUserinfo");
        String owner = tUserinfo.gettUserinfoName();
        //根据用户名创建所属路径
        File fileFolder = new File("D:/oaupload/"+owner);
        if (!fileFolder.exists()){
            fileFolder.mkdir();
        }
        String filePath = "D:/oaupload/"+owner+"/"+fileName;
        TFileinfo tFileinfo = new TFileinfo();
        tFileinfo.settFiletypeinfo(filetypeinfo);
        tFileinfo.settFileinfoName(fileName);
        tFileinfo.settFileinfoOwner(owner);
        tFileinfo.settFileinfoFilepath(filePath);
        tFileinfo.settFileinfoRemark(fileremark);
        //添加到数据库
        fileService.addFile(tFileinfo);
        try {
            InputStream inputStream = myfiles.getInputStream();
            FileOutputStream fileOutputStream = new FileOutputStream(filePath);
            byte[] ch = new byte[1024];
            int len;
            while((len = inputStream.read(ch))!=-1){
                fileOutputStream.write(ch,0,len);
                fileOutputStream.close();
            }
            fileOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "forward:file_management.do";
    }
//放入回收站
    @RequestMapping("ifdelete.do")
    public String ifdelete(int fileinfoid){
        fileService.updateDelTrash(fileinfoid);
        return "forward:file_management.do";
    }
    //撤销删除
    @RequestMapping("canceldelete.do")
    public String canceldelete(int fileinfoid){
        fileService.updateDelFile(fileinfoid);
        return "forward:trash.do";
    }
    //彻底删除
    @RequestMapping("filedelete.do")
    public String filedelete(int fileinfoid){
        TFileinfo tFileinfo = fileService.queryFileByI(fileinfoid);
        File file = new File(tFileinfo.gettFileinfoFilepath());
        file.delete();
        fileService.deleteFile(fileinfoid);
        //从磁盘下彻底删除
        return "forward:trash.do";
    }

    @RequestMapping("filedownload.do")
    public ResponseEntity<byte[]> download(int fileinfoid) throws IOException {
        TFileinfo fileinfo = fileService.queryFileByI(fileinfoid);
        File file = new File(fileinfo.gettFileinfoFilepath());

        byte[] body = null;
        InputStream is = new FileInputStream(file);
        body = new byte[is.available()];
        is.read(body);
        HttpHeaders headers = new HttpHeaders();
        String fileName = new String(file.getName().getBytes("utf-8"),"iso-8859-1");
        headers.add("Content-Disposition", "attchement;filename=" + fileName);
        HttpStatus statusCode = HttpStatus.OK;
        ResponseEntity<byte[]> entity = new ResponseEntity<>(body, headers, statusCode);
        return entity;
    }

    @RequestMapping("filetrash.do")
    public String filetrash(String ids,Model model){
        String[] array = ids.split(",");
        for (int i = 0; i < array.length; i++) {
            System.out.println("=====批量删除传递参数====");
            int id = Integer.parseInt(array[i]);
            try {
                fileService.updateDelTrash(id);
                model.addAttribute("n",1);
            } catch (Exception e) {
                model.addAttribute("n",0);
            }
        }
        return "forward:file_management.do";
    }

    @RequestMapping("trashdel.do")
    public String trashdel(String ids,Model model){
        String[] array = ids.split(",");
        for (int i = 0; i < array.length; i++) {
            System.out.println("=====批量删除传递参数====");
            int id = Integer.parseInt(array[i]);
            try {
                TFileinfo tFileinfo = fileService.queryFileByI(id);
                File file = new File(tFileinfo.gettFileinfoFilepath());
                file.delete();
                fileService.deleteFile(id);
                model.addAttribute("n",1);
            } catch (Exception e) {
                model.addAttribute("n",0);
            }
        }
        return "forward:trash.do";
    }

}
