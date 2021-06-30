package com.example.bookstore.Services.UserInfo;

import com.example.bookstore.Dao.BookshelfDao;
import com.example.bookstore.Dao.TokenDao;
import com.example.bookstore.Dao.UserInfoDao;
import com.example.bookstore.Pojo.Book;
import com.example.bookstore.Pojo.UserInfo;
import jdk.nashorn.internal.parser.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoServiceImp implements UserInfoService{
    @Autowired
    TokenDao tokenDao;
    @Autowired
    UserInfoDao userInfoDao;
    @Autowired
    BookshelfDao bookshelfDao;
    @Override
    public UserInfo getUserInfoByPhone(String token) {
        String phone = tokenDao.getPhoneByToken(token);
        if (phone != null) return userInfoDao.getUserInfoByPhone(phone);
        else {
            return null;
        }
    }

    @Override
    public Boolean insertUserInfo(String name, String phone, String password,String gender) {
        userInfoDao.insertUserInfo(name,phone,password,gender);
        return true;
    }

    @Override
    public void updateUserInfo(String name, String phone, String oldPhone, String gender, String birthday) {
        userInfoDao.updateUserInfo(name,phone,oldPhone,gender,birthday);
    }

    @Override
    public void updateUserPassword(String phone, String passwordNew) {
        userInfoDao.updateUserPassword(phone,passwordNew);
    }

    @Override
    public List<Book> showBookshelf(String phone) {
        return bookshelfDao.getBooksFromBookshelf(phone);
    }
}
