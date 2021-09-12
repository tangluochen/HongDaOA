package com.icss.dao;

import com.icss.pojo.TFiletypeinfo;

public interface TFiletypeinfoDao {
    Integer selectIdByName(String filetypename);
}