package com.icss.dao;

import com.icss.pojo.TLoginlog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TLoginlogDao {
    void insertLoginLog(@Param("userid") Long userid,@Param("ip") String ip);
    List<TLoginlog> selectAllLog();
    void deleteLog(long id);
}