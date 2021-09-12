package com.icss.dao;

import com.icss.pojo.TMynote;

import java.util.List;

public interface TMynoteDao {
    List<TMynote> selectAllNotes();
}