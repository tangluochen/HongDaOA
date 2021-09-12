package com.icss.service;

import com.icss.pojo.TFileinfo;

import java.util.List;

public interface FileService {
    List<TFileinfo> queryAllFile();
    int queryFileCount();
    int queryTrash();
    List<TFileinfo> queryAllTrash();
    Integer queryIdBytypename(String name);
    void addFile(TFileinfo tFileinfo);
    void updateDelTrash(int id);
    void updateDelFile(int id);
    void deleteFile(int id);
    TFileinfo queryFileByI(int id);
    List<TFileinfo> selectAllFilesByName(String name);
    List<TFileinfo> selectAllTrashByName(String name);
}
