package com.icss.service;

import com.icss.dao.TRoleinfoDao;
import com.icss.pojo.TRoleinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleInfoServiceImp implements RoleInfoService{
@Autowired
    TRoleinfoDao tRoleinfoDao;
    @Override
    public List<TRoleinfo> findRole() {
        return tRoleinfoDao.selectAllRoleInfo();
    }
}
