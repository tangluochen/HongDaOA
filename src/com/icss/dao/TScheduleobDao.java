package com.icss.dao;

import com.icss.pojo.TScheduleob;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TScheduleobDao {
    List<TScheduleob> selectAllScheduleOB(@Param("departid") Long departid);
    void insertScheduleob(@Param("departid") long departid,@Param("scheduleid")long scheduleid,
            @Param("userid")long userid, @Param("branchid")long branchid);
}