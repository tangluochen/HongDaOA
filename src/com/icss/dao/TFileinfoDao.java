package com.icss.dao;

import com.icss.pojo.TFileinfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TFileinfoDao {
    List<TFileinfo> selectAllFiles();
    int selectAllFileCount();
    int selectAllTrashCount();
    List<TFileinfo> selectAllTrash();
    void insertFileinfo(@Param("tFileinfo") TFileinfo tFileinfo);
    void updateIsDelTrash(int id);
    void updateIsDelFile(int id);
    void deleteFile(int id);
    TFileinfo selectFileById(int id);
    List<TFileinfo> selectAllFilesByName(@Param("name") String name);
    List<TFileinfo> selectAllTrashByName(@Param("name") String name);
}