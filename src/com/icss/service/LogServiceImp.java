package com.icss.service;

import com.icss.dao.TLoginlogDao;
import com.icss.pojo.TLoginlog;
import org.aspectj.lang.annotation.After;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogServiceImp implements  LogService{
    @Autowired
    TLoginlogDao tLoginlogDao;
    @Override
    public void saveLoginlog(Long userid, String ip) {
        tLoginlogDao.insertLoginLog(userid,ip);
    }

    @Override
    public List<TLoginlog> queryAllLog() {
        return tLoginlogDao.selectAllLog();
    }

    @Override
    public void removeLog(Long id) {
        tLoginlogDao.deleteLog(id);
    }
}
