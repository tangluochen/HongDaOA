package com.icss.service;

import com.icss.pojo.TMeetinginfo;
import com.icss.pojo.TMynote;
import com.icss.pojo.TSchedule;
import com.icss.pojo.TScheduleob;
import com.icss.util.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ScheduleService {
    List<TSchedule> selectAllSchedules(Page page);
    int selectAllscheduleCounts();
    List<TSchedule> selectAllSchedulesByname(String name,Page page);
    int selectAllscheduleCountsByname(String name);
    List<TMeetinginfo> queryAllMeetingInfo();
    void insertSchedule(TSchedule tSchedule);
    TSchedule selectScheduleByid(long tScheduleId);
    void updateSchedule( TSchedule tSchedule);
    void deleteSchedule(long tScheduleId);
    List<TMynote> selectAllNotes();
    List<TScheduleob> queryAllScheduleOB(@Param("departid") Long departid);
    List<TSchedule> queryAllDepartSchedule();
    void addScheduleob(long departid,long scheduleid,
                          long userid, long branchid);
}
