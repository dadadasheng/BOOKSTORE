package com.example.bookstore.Services.TokenService;

public interface TokenService {
    public String getToken(String phone);
    public String getPhoneByToken(String token);
    public void setToken(String phone,String token);
}
