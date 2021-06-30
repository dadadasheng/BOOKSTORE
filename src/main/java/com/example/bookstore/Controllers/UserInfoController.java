package com.example.bookstore.Controllers;

import com.example.bookstore.Pojo.Book;
import com.example.bookstore.Pojo.UserInfo;
import com.example.bookstore.Services.BookshelfService.BookshelfService;
import com.example.bookstore.Services.TokenService.TokenService;
import com.example.bookstore.Services.UserInfo.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class UserInfoController {
    @Autowired
    UserInfoService userInfoService;
    @Autowired
    TokenService tokenService;
    @Autowired
    BookshelfService bookshelfService;
    @CrossOrigin
    @ResponseBody
    @RequestMapping("/getUserInfo")
    public UserInfo getUserInfo(HttpServletRequest httpServletRequest){
        String token = httpServletRequest.getHeader("token");
        return userInfoService.getUserInfoByPhone(token);
    }
    @CrossOrigin
    @ResponseBody
    @RequestMapping("/updateUserInfo")
    public boolean updateUserInfo(String name, String phone, String oldPhone, String gender, String birthday){
        userInfoService.updateUserInfo(name,phone,oldPhone,gender,birthday);
        return true;
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping("/updateUserPassword")
    public boolean updateUserPassword(String phone, String passwordNew){
        userInfoService.updateUserPassword(phone,passwordNew);
        return true;
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping("/showBookshelf")
    public List<Book> showBookshelf(String phone){

        return userInfoService.showBookshelf(phone);
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping("/deleteBookFromBookshelf")
    public Boolean deleteBookFromBookshelf(String token,int bookId){
         String phone=tokenService.getPhoneByToken(token);
         if(phone!=null) {
             bookshelfService.deleteBookFromBookshelf(phone, bookId);
             return true;
         }
         return false;
    }
}
