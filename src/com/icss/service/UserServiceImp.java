package com.icss.service;

import com.icss.dao.*;
import com.icss.pojo.*;
import com.icss.util.Page;
import com.icss.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.reflect.generics.tree.Tree;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


@Service
public class UserServiceImp implements UserService{
    @Autowired
    TUserinfoDao tUserinfoDao;
    @Autowired
    TManageDao tManageDao;
    @Autowired
    TPowerDao tPowerDao;
    @Autowired
    TBranchinfoDao tBranchinfoDao;
    @Autowired
    TDepartinfoDao tDepartinfoDao;
    @Autowired
    TManualsignDao tManualsignDao;
    @Override
    public Result<TUserinfo> queryUserInfo(String tUserinfoName, String tUserinfoPassword) {
        Result<TUserinfo> result = new Result<TUserinfo>();
        TUserinfo tUserinfo = tUserinfoDao.selectTUserinfoByuname(tUserinfoName);
        if (tUserinfo==null){
            result.setNumber(1);
        }else{
            if(tUserinfo.gettUserinfoPassword().equals(tUserinfoPassword)){
                result.setObject(tUserinfo);
                result.setNumber(3);
            }else{
                result.setNumber(2);
            }
        }
        return result;
    }

    @Override
    public Map<String, List<TPower>> queryMenu(TUserinfo userinfo) {
        Map<String, List<TPower>> map = new TreeMap<String, List<TPower>>();
        List<TManage> tManageList = tManageDao.selectByRoleInfoid(userinfo.gettRoleinfo().gettRoleinfoId());
        for (TManage tManage : tManageList) {
            List<TPower> tPowerList = tPowerDao.selectByManageid(tManage.gettManageId());
            map.put(tManage.gettManageName(),tPowerList);
        }
        return map;
    }

    @Override
    public Result<List<TBranchinfo>> queryBranch(int page,int pageSize) {
        Result<List<TBranchinfo>> result = new Result<List<TBranchinfo>>();
        int totalRecord = tBranchinfoDao.selectCounts();

        int a = (page-1)*pageSize+1;
        int b = pageSize*page;
        List<TBranchinfo> tBranchinfoList = tBranchinfoDao.selectAllBranchs(a,b);
        result.setObject(tBranchinfoList);
        //将page总数带过去
        result.setNumber(totalRecord);
        return result;
    }

    @Override
    public Result<List<TBranchinfo>> queryBranchByname(String name) {
        Result<List<TBranchinfo>> result = new Result<List<TBranchinfo>>();
        int totalRecord = tBranchinfoDao.selectCountsByname(name);
        List<TBranchinfo> tBranchinfoList = tBranchinfoDao.selectAllBranchsByname(name);
        result.setObject(tBranchinfoList);
        result.setNumber(totalRecord);
        return result;
    }

    @Override
    public void updateBranchInfo(TBranchinfo tBranchinfo) {
        tBranchinfoDao.updateBranchInfo(tBranchinfo);
    }

    @Override
    public void deleteBranch(Long T_BRANCHINFO_ID) throws Exception{
       tBranchinfoDao.deleteBranchbYID(T_BRANCHINFO_ID);

    }

    @Override
    public void addBranch(TBranchinfo tBranchinfo) {
        tBranchinfoDao.addBranch(tBranchinfo);
    }

    @Override
    public void deleteAllBranch(String[] array) {
        tBranchinfoDao.deleteAllBranch(array);
    }

    @Override
    public List<TBranchinfo> queryAllBranch() {
        return tBranchinfoDao.selectAllBranch();
    }

    @Override
    public List<TDepartinfo> queryAllDepart() {
        return tDepartinfoDao.selectAllDepart();
    }

    @Override
    public List<TUserinfo> queryAllUser() {
        return tUserinfoDao.selectAllUser();
    }

    @Override
    public List<TUserinfo> queryUserByRole(Long tRoleInfoId) {
        return tUserinfoDao.selectAllUserByRole(tRoleInfoId);
    }

    @Override
    public TUserinfo findUserRole(Long tUserInfoId) {
        return tUserinfoDao.selectUserRole(tUserInfoId);
    }

    @Override
    public void deleteAllDeparts(String[] array) {
        tDepartinfoDao.deleteDeparts(array);
    }

    @Override
    public void deleteDepartByDid(Long tDepartinfoId) {
        tDepartinfoDao.deleteByDid(tDepartinfoId);
    }

    @Override
    public void updateDepart(TDepartinfo tDepartinfo) {
        tDepartinfoDao.updateDepart(tDepartinfo);
    }

    @Override
    public void addDepart(TDepartinfo tDepartinfo) {
        tDepartinfoDao.addDepart(tDepartinfo);
    }

    @Override
    public TDepartinfo queryDepartByid(Long deptid) {
        return tDepartinfoDao.selectDepartByid(deptid);
    }

    @Override
    public List<TManualsign> selectSignByUser(Long id) {
        return tManualsignDao.selectSignByUser(id);
    }

    @Override
    public List<TManualsign> selectSign() {
        return tManualsignDao.selectSign();
    }

    @Override
    public int insertSign(Long id,int status) {
        String desc = null;
        if(status==1){
            desc = "上班";
        }else if(status==2){
            desc = "下班";
        }else {
            desc = "迟到";
        }
        return tManualsignDao.insertSign(id,desc,status);
    }
    @Override
    public TManualsign querySignByStatus(int status, long userId) {
        return tManualsignDao.selectSignByStatus(status,userId);
    }

    @Override
    public void updateTime(long tManualsignId) {
        tManualsignDao.updateSignTime(tManualsignId);
    }

    @Override
    public List<TManualsign> selectSignByUsername(String username) {
        return tManualsignDao.selectSignByUsername(username);
    }

}
