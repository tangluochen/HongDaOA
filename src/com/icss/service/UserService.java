package com.icss.service;

import com.icss.pojo.*;
import com.icss.util.Result;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserService {

    Result<TUserinfo> queryUserInfo(String tUserinfoName, String tUserinfoPassword);
//传roleinfo
    Map<String, List<TPower>> queryMenu(TUserinfo userinfo);

    Result<List<TBranchinfo>> queryBranch(int page,int pageSize);

    Result<List<TBranchinfo>> queryBranchByname(String name);
    void updateBranchInfo(TBranchinfo tBranchinfo);
    void deleteBranch(Long T_BRANCHINFO_ID) throws  Exception;
    void addBranch(TBranchinfo tBranchinfo);
    void deleteAllBranch(String[] array);
    List<TBranchinfo> queryAllBranch();
    List<TDepartinfo> queryAllDepart();
    List<TUserinfo> queryAllUser();
    List<TUserinfo> queryUserByRole(Long tRoleInfoId);

    TUserinfo findUserRole(Long tUserInfoId);
    void deleteAllDeparts(String[] array);



    void deleteDepartByDid(Long tDepartinfoId);
    void updateDepart(TDepartinfo tDepartinfo);
    void addDepart(TDepartinfo tDepartinfo);
    TDepartinfo queryDepartByid(Long deptid);
    List<TManualsign> selectSignByUser(@Param("id") Long id);
    List<TManualsign> selectSign();
    int insertSign( Long id,int status);
    TManualsign querySignByStatus(int status, long userId);
    void updateTime(long tManualsignId);

    List<TManualsign> selectSignByUsername(String username);

}
