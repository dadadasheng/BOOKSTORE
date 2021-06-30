package com.example.bookstore.Services.BookCommentService;

import com.example.bookstore.Pojo.BookCommentOfUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookCommentService {
    public List<BookCommentOfUser> getCommentsByBookId(int bookId);
    public void insertComment(String token,int bookId,String comment);
    public void likeComment(String phone,int bookId,int commentId);
    public Boolean isLikeComment(String phone,int bookId,int commentId);
    public void cancelLikeComment(String phone,int bookId,int commentId);
    public Boolean isCommentOfUser(int bookId,int commentId,String token);
    public void delCommentByPhone(String phone, int bookId,int commentId);

}
