package com.icss.service;

import com.icss.pojo.TLoginlog;

import java.util.List;

public interface LogService {
    void saveLoginlog(Long userid,String ip);
    List<TLoginlog> queryAllLog();
    void removeLog(Long id);
}
