package com.icss.dao;

import com.icss.pojo.TManage;

import java.util.List;

public interface TManageDao {
    List<TManage> selectByRoleInfoid(Long tRoleinfoId);
}