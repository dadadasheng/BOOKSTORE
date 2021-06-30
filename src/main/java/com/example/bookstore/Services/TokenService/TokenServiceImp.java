package com.example.bookstore.Services.TokenService;

import com.example.bookstore.Dao.TokenDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenServiceImp implements TokenService{
    @Autowired
    TokenDao tokenDao;
    @Override
    public String getToken(String phone) {
        return tokenDao.getToken(phone);
    }
    @Override
    public String getPhoneByToken(String token) {
        return tokenDao.getPhoneByToken(token);
    }

    @Override
    public void setToken(String phone, String token) {
        tokenDao.setToken(phone,token);
    }
}
