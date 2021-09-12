package com.icss.dao;

import com.icss.pojo.TBranchinfo;
import com.icss.pojo.TDepartinfo;
import com.icss.pojo.TUserinfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TDepartinfoDao {
    List<TDepartinfo> selectAllDepart();
    void deleteByDid(Long tDepartinfoId);
    void deleteDeparts(@Param(value="array")String[] array);
    void updateDepart(@Param("tDepartinfo") TDepartinfo tDepartinfo);
    void addDepart(@Param("tDepartinfo") TDepartinfo tDepartinfo);
    List<TDepartinfo> selectDepartByBranch(@Param("tBranchinfo") TBranchinfo tBranchinfo);
    int selectbranchID(Long deptid);
    TDepartinfo selectDepartByid(Long deptid);
}