package com.icss.dao;

import com.icss.pojo.TPower;

import java.util.List;

public interface TPowerDao {
    List<TPower> selectByManageid(Long tManageId);
}