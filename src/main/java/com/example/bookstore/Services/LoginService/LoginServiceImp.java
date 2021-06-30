package com.example.bookstore.Services.LoginService;

import com.example.bookstore.Dao.UserInfoDao;
import com.example.bookstore.Pojo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoginServiceImp implements LoginService{
    @Autowired
    UserInfoDao userInfoDao;
    public boolean login(String phone,String password){
        UserInfo userInfo = userInfoDao.getUserInfo(phone,password);
        System.out.println("控制器传过来的"+phone+"  "+password);
        if(userInfo!=null) {
            System.out.println(userInfo.getPhone()+userInfo.getPassword());
            return true;
        }
        return false;
    }

}
