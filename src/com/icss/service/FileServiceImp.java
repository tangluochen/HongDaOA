package com.icss.service;

import com.icss.dao.TFileinfoDao;
import com.icss.dao.TFiletypeinfoDao;
import com.icss.pojo.TFileinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileServiceImp implements FileService {
    @Autowired
    TFileinfoDao tFileinfoDao;
    @Autowired
    TFiletypeinfoDao tFiletypeinfoDao;

    @Override
    public List<TFileinfo> queryAllFile() {
        return tFileinfoDao.selectAllFiles();
    }

    @Override
    public int queryFileCount() {
        return tFileinfoDao.selectAllFileCount();
    }

    @Override
    public int queryTrash() {
        return tFileinfoDao.selectAllTrashCount();
    }

    @Override
    public List<TFileinfo> queryAllTrash() {
        return tFileinfoDao.selectAllTrash();
    }

    @Override
    public Integer queryIdBytypename(String name) {
        return tFiletypeinfoDao.selectIdByName(name);
    }

    @Override
    public void addFile(TFileinfo tFileinfo) {
        tFileinfoDao.insertFileinfo(tFileinfo);
    }

    @Override
    public void updateDelTrash(int id) {
        tFileinfoDao.updateIsDelTrash(id);
    }

    @Override
    public void updateDelFile(int id) {
        tFileinfoDao.updateIsDelFile(id);
    }

    @Override
    public void deleteFile(int id) {
        tFileinfoDao.deleteFile(id);
    }

    @Override
    public TFileinfo queryFileByI(int id) {
        return tFileinfoDao.selectFileById(id);
    }

    @Override
    public List<TFileinfo> selectAllFilesByName(String name) {
        return tFileinfoDao.selectAllFilesByName(name);
    }

    @Override
    public List<TFileinfo> selectAllTrashByName(String name) {
        return tFileinfoDao.selectAllTrashByName(name);
    }
}
