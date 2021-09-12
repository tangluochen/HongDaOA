package com.icss.service;

import com.icss.dao.TMeetinginfoDao;
import com.icss.dao.TMynoteDao;
import com.icss.dao.TScheduleDao;
import com.icss.dao.TScheduleobDao;
import com.icss.pojo.TMeetinginfo;
import com.icss.pojo.TMynote;
import com.icss.pojo.TSchedule;
import com.icss.pojo.TScheduleob;
import com.icss.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleServiceImp implements ScheduleService{
    @Autowired
    TScheduleDao tScheduleDao;
@Autowired
    TMeetinginfoDao tMeetinginfoDao;
@Autowired
    TMynoteDao tMynoteDao;
@Autowired
    TScheduleobDao tScheduleobDao;
    @Override
    public List<TSchedule> selectAllSchedules(Page page) {
        int start = (page.getPageNow()-1)*page.getPageSize()+1;
        int end = (page.getPageNow())*page.getPageSize();
        return tScheduleDao.selectAllSchedules(start,end);
    }

    @Override
    public int selectAllscheduleCounts() {
        return tScheduleDao.selectAllscheduleCounts();
    }

    @Override
    public List<TSchedule> selectAllSchedulesByname(String name, Page page) {
        int start = (page.getPageNow()-1)*page.getPageSize()+1;
        int end = (page.getPageNow())*page.getPageSize();
        return tScheduleDao.selectAllSchedulesByname(name,start,end);
    }

    @Override
    public int selectAllscheduleCountsByname(String name) {
        return tScheduleDao.selectAllscheduleCountsByname(name);
    }

    @Override
    public List<TMeetinginfo> queryAllMeetingInfo() {
        return tMeetinginfoDao.selectAllMeetingInfo();
    }

    @Override
    public void insertSchedule(TSchedule tSchedule) {
        tScheduleDao.insertSchedule(tSchedule);
    }

    @Override
    public TSchedule selectScheduleByid(long tScheduleId) {
        return tScheduleDao.selectScheduleByid(tScheduleId);
    }

    @Override
    public void updateSchedule(TSchedule tSchedule) {
        tScheduleDao.updateSchedule(tSchedule);
    }

    @Override
    public void deleteSchedule(long tScheduleId) {
        tScheduleDao.deleteScheduleById(tScheduleId);
    }

    @Override
    public List<TMynote> selectAllNotes() {
        return tMynoteDao.selectAllNotes();
    }

    @Override
    public List<TScheduleob> queryAllScheduleOB(Long departid) {
        return tScheduleobDao.selectAllScheduleOB(departid);
    }

    @Override
    public List<TSchedule> queryAllDepartSchedule() {
        return tScheduleDao.selectAllDepartSchedule();
    }

    @Override
    public void addScheduleob(long departid, long scheduleid, long userid, long branchid) {
        tScheduleobDao.insertScheduleob(departid,scheduleid,userid,branchid);
    }
}
