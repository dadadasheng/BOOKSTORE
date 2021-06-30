package com.example.bookstore.Services.UserInfo;

import com.example.bookstore.Pojo.Book;
import com.example.bookstore.Pojo.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserInfoService {
    public UserInfo getUserInfoByPhone(String token);
    public Boolean insertUserInfo(String name,String phone,String password,String gender);
    public void updateUserInfo(String name,String phone,String oldPhone,String gender,String birthday);
    public void updateUserPassword(@Param("phone")String phone,@Param("passwordNew") String passwordNew);
    public List<Book> showBookshelf(@Param("phone")String phone);

}
