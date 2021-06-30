package com.example.bookstore.Controllers;

import com.example.bookstore.Services.LoginService.LoginService;
import com.example.bookstore.Services.TokenService.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@Controller
public class LoginController {
    @Autowired
    LoginService loginService;
    @Autowired
    TokenService tokenService;
    @CrossOrigin
    //@RequestMapping(value = "/login",method = RequestMethod.POST)
    @RequestMapping("/login")
    @ResponseBody
    public String Login(String phone,String password){
        if(loginService.login(phone,password)){
            //生成token令牌
            System.out.println("登录成功");
            String token = UUID.randomUUID()+"";
            tokenService.setToken(phone,token);
            return token;
        }else {
            return null;
        }

    }

}
