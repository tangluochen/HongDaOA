package com.icss.service;

import com.icss.dao.TManualsignDao;
import com.icss.dao.TWorktimeDao;
import com.icss.pojo.TManualsign;
import com.icss.pojo.TWorktime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class WorkTimeServiceImp implements WorkTimeService{
    @Autowired
    TWorktimeDao tWorktimeDao;
    @Autowired
    TManualsignDao tManualsignDao;
    @Override
    public int queryWokeTime() {


        int status = 0;
        TWorktime worktime = tWorktimeDao.selectWoketime();
        Date date = new Date();
        String start = worktime.gettWorktimeOndutytime();
        String end = worktime.gettWorktimeOffdutytime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
        try {
            Date startTime = simpleDateFormat.parse(start);
            Date endTime = simpleDateFormat.parse(end);
            Date now = simpleDateFormat.parse(simpleDateFormat.format(date));
            if(now.after(startTime)&&now.before(endTime)){
                status = 3;
            }else if(now.before(startTime)||now.equals(startTime)){
                status = 1;
            }else if(now.after(endTime)||now.equals(endTime)){
                status = 2;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return status;
    }


}
