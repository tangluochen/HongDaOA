package com.icss.dao;

import com.icss.pojo.TManualsign;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TManualsignDao {
    List<TManualsign> selectSignByUser(@Param("id") Long id);
    List<TManualsign> selectSign();
    int insertSign(@Param("id") Long id,@Param("tManualsignDesc")String tManualsignDesc,@Param("status")int status);
    TManualsign selectSignByStatus(@Param("status") int status,@Param("userId") long userId);
    void updateSignTime(@Param("tManualsignId") long tManualsignId);
    List<TManualsign> selectSignByUsername(@Param("username") String username);
}