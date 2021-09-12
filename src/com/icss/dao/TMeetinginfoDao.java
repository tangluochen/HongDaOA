package com.icss.dao;

import com.icss.pojo.TMeetinginfo;

import java.util.List;

public interface TMeetinginfoDao {
    List<TMeetinginfo> selectAllMeetingInfo();
}