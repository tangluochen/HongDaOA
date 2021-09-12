package com.icss.dao;

import com.icss.pojo.TBranchinfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TBranchinfoDao {
    List<TBranchinfo> selectAllBranchs(@Param("page") int page, @Param("pageSize") int pageSize);
    //查询总记录
    int selectCounts();
    List<TBranchinfo> selectAllBranchsByname(@Param("name") String name);
    int selectCountsByname(@Param("name") String name);

    void updateBranchInfo(@Param("tBranchinfo") TBranchinfo tBranchinfo);

    void deleteBranchbYID(Long tBranchinfoId) throws Exception;

    void addBranch(@Param("tBranchinfo") TBranchinfo tBranchinfo);
    public void deleteAllBranch(@Param(value="array")String[] array);

    List<TBranchinfo> selectAllBranch();
}