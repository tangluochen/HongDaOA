package com.icss.service;

import com.icss.pojo.TBranchinfo;
import com.icss.pojo.TDepartinfo;
import com.icss.pojo.TUserinfo;
import com.icss.util.Result;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminService {
    Result<List<TUserinfo>> queryUser(int page, int pageSize);
    Result<List<TUserinfo>> queryUserByName(String tUserinfoName,int page,int pageSize);
    List<TUserinfo> selectAlluser();
    void deleteAllUser(int array) throws Exception;
    int addUser(TUserinfo tUserinfo);
    void updateUser(TUserinfo tUserinfo);
    List<TDepartinfo> queryDepartByBranch(TBranchinfo tBranchinfo);
    TUserinfo  selectTUserinfoByuname( String tUserinfoName);
    long queryBranchID(long deptid);
}
