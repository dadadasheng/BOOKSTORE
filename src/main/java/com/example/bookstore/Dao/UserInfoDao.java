package com.example.bookstore.Dao;

import com.example.bookstore.Pojo.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserInfoDao {
    public UserInfo getUserInfo(@Param("phone") String phone,@Param("password") String password);
    public UserInfo getUserInfoByPhone(@Param("phone") String phone);
    public void insertUserInfo(@Param("name")String name,@Param("phone") String phone,@Param("password") String password,@Param("gender") String gender);
    public void updateUserInfo(@Param("name")String name,@Param("phone") String phone,@Param("oldPhone") String oldPhone,@Param("gender") String gender,@Param("birthday") String birthday);
    public void updateUserPassword(@Param("phone")String phone,@Param("passwordNew") String passwordNew);
}
