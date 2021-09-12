package com.icss.service;

import com.icss.dao.TDepartinfoDao;
import com.icss.dao.TUserinfoDao;
import com.icss.pojo.TBranchinfo;
import com.icss.pojo.TDepartinfo;
import com.icss.pojo.TUserinfo;
import com.icss.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImp implements AdminService{
    @Autowired
    TUserinfoDao tUserinfoDao;
    @Autowired
    TDepartinfoDao tDepartinfoDao;
    @Override
    public Result<List<TUserinfo>> queryUser(int page, int pageSize) {
        Result<List<TUserinfo>> result = new Result<List<TUserinfo>>();
        int totalRecord = tUserinfoDao.selectCounts();
        int a = (page-1)*pageSize+1;
        int b = pageSize*page;
        List<TUserinfo> tUserinfoList = tUserinfoDao.selectAllUserFenYe(a,b);
        result.setObject(tUserinfoList);
        result.setNumber(totalRecord);
        return result;
    }

    @Override
    public Result<List<TUserinfo>> queryUserByName(String tUserinfoName ,int page,int pageSize) {
        Result<List<TUserinfo>> result = new Result<List<TUserinfo>>();
        int totalRecord = tUserinfoDao.selectCountsByName( tUserinfoName);
        int a = (page-1)*pageSize+1;
        int b = pageSize*page;
        List<TUserinfo> tUserinfoList =  tUserinfoDao.selectAllUserByName(tUserinfoName,a,b);
        result.setObject(tUserinfoList);
        result.setNumber(totalRecord);
        return result;
    }

    @Override
    public List<TUserinfo> selectAlluser() {
        return tUserinfoDao.selectAllUser();
    }

    @Override
    public void deleteAllUser(int array) throws Exception {
        tUserinfoDao.deleteAllUser(array);
    }

    @Override
    public int addUser(TUserinfo tUserinfo) {

        return tUserinfoDao.insertUser(tUserinfo);

    }

    @Override
    public void updateUser(TUserinfo tUserinfo) {
        tUserinfoDao.updateUser(tUserinfo);
    }

    @Override
    public List<TDepartinfo> queryDepartByBranch(TBranchinfo tBranchinfo) {
        return tDepartinfoDao.selectDepartByBranch(tBranchinfo);
    }

    @Override
    public TUserinfo selectTUserinfoByuname(String tUserinfoName) {
        return tUserinfoDao.selectTUserinfoByuname(tUserinfoName);
    }

    @Override
    public long queryBranchID(long deptid) {
        return tDepartinfoDao.selectbranchID( deptid);
    }
}
