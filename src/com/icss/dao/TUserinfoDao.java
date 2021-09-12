package com.icss.dao;

import com.icss.pojo.TBranchinfo;
import com.icss.pojo.TUserinfo;
import com.icss.util.Result;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface TUserinfoDao {
//    TUserinfo selectTUserinfoByuname(String tUserinfoName);
TUserinfo  selectTUserinfoByuname( String tUserinfoName);

List<TUserinfo> selectAllUser();

    List<TUserinfo> selectAllUserFenYe(@Param("page") int page, @Param("pageSize") int pageSize);
    int selectCounts();
    int selectCountsByName(@Param("name")String name);

    List<TUserinfo> selectAllUserByName(@Param("tUserinfoName") String tUserinfoName,@Param("page") int page, @Param("pageSize") int pageSize);

    List<TUserinfo> selectAllUserByRole(@Param("tRoleInfoId") Long tRoleInfoId);
  TUserinfo selectUserRole(@Param("tUserInfoId") Long tUserInfoId);

    /**
     * 批量删除
     * @param
     */
    void deleteAllUser(@Param("tUserinfoId")int tUserinfoId) throws Exception;

    /**
     * 添加用户
     */
    int insertUser(@Param("tUserinfo") TUserinfo tUserinfo);
    /**
     * 修改用户
     */
    void updateUser(@Param("tUserinfo") TUserinfo tUserinfo);
    List<TUserinfo> selectAlluser();
}