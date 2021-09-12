package com.icss.aop;

import com.icss.dao.TUserinfoDao;
import com.icss.pojo.TUserinfo;
import com.icss.service.LogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class LAOP {
    @Autowired
    LogService logService;
    @Autowired
    HttpServletRequest httpServletRequest;
    @Autowired
    TUserinfoDao tUserinfoDao;
    @Pointcut(value="execution(* com.icss.service.UserService.queryUserInfo(..))")
    public void loginlog(){

    }
    @After("loginlog()")
    public  void loginlog(JoinPoint joinPoint){
        String ip = httpServletRequest.getRemoteAddr();
        Object[] objects = joinPoint.getArgs();
        String username = (String) objects[0];
        String password = (String) objects[1];
        TUserinfo tUserinfo = tUserinfoDao.selectTUserinfoByuname(username);
        if(tUserinfo!=null){
            if(tUserinfo.gettUserinfoPassword().equals(password)){
                logService.saveLoginlog(tUserinfo.gettUserinfoId(),ip);
            }
        }
        System.out.println(ip);
    }
}
