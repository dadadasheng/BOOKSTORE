package com.example.bookstore.Controllers;

import com.example.bookstore.Services.UserInfo.UserInfoService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RegisterController {
    @Autowired
    UserInfoService userInfoService;
    @CrossOrigin
    @RequestMapping("/register")
    @ResponseBody
    public Boolean register(String name,String phone,String password,String gender){
        userInfoService.insertUserInfo(name,phone,password,gender);
        return true;
    }

}
