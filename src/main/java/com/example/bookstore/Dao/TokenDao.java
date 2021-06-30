package com.example.bookstore.Dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface TokenDao {
    public String getToken(@Param("phone") String phone);
    public void setToken(@Param("phone")String phone,@Param("token")String token);
    public String getPhoneByToken(@Param("token") String token);
}
