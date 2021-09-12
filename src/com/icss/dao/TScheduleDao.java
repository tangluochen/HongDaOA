package com.icss.dao;

import com.icss.pojo.TSchedule;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TScheduleDao {
    List<TSchedule> selectAllDepartSchedule();
    List<TSchedule> selectAllSchedules(@Param("start") int start, @Param("end") int end);
    int selectAllscheduleCounts();
    List<TSchedule> selectAllSchedulesByname(@Param("name") String name,@Param("start") int start, @Param("end") int end);
    int selectAllscheduleCountsByname(@Param("name") String name);
    void insertSchedule(@Param("tSchedule") TSchedule tSchedule);
    TSchedule selectScheduleByid(@Param("tScheduleId") long tScheduleId);
    void updateSchedule(@Param("tSchedule") TSchedule tSchedule);
    void deleteScheduleById(@Param("tScheduleId") long tScheduleId);
}