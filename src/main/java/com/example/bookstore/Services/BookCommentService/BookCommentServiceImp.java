package com.example.bookstore.Services.BookCommentService;

import com.example.bookstore.Dao.CommentsDao;
import com.example.bookstore.Dao.TokenDao;
import com.example.bookstore.Dao.UserInfoDao;
import com.example.bookstore.Pojo.BookCommentOfUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookCommentServiceImp implements BookCommentService{
    @Autowired
    CommentsDao commentsDao;
    @Autowired
    UserInfoDao userInfoDao;
    @Autowired
    TokenDao tokenDao;
    @Override
    public List<BookCommentOfUser> getCommentsByBookId(int bookId) {
        return commentsDao.getCommentsByBookId(bookId);
    }
    @Override
    public void insertComment(String token, int bookId, String comment) {
        String phone=tokenDao.getPhoneByToken(token);
        commentsDao.insertComment(phone, bookId, comment);
    }

    @Override
    public void likeComment(String phone, int bookId, int commentId) {
        commentsDao.likeComment(phone, bookId, commentId);
        commentsDao.addCommentLikeNum(commentId);
    }

    @Override
    public Boolean isLikeComment(String phone, int bookId, int commentId) {
        String Phone = commentsDao.isLikeComment(phone, bookId, commentId);
        return Phone!=null;
    }

    @Override
    public void cancelLikeComment(String phone, int bookId, int commentId) {
        commentsDao.cancelLikeComment(phone, bookId, commentId);
        commentsDao.subCommentLikeNum(commentId);
    }

    @Override
    public Boolean isCommentOfUser(int bookId, int commentId,String token) {
        return tokenDao.getPhoneByToken(token).equals(commentsDao.getPhoneByCommentId(bookId, commentId));
    }

    @Override
    public void delCommentByPhone(String phone, int bookId,int commentId) {
        System.out.println("传进来的phone"+phone);
        commentsDao.delCommentByPhone(phone, commentId);
        commentsDao.cancelLikeComment(phone, bookId, commentId);
    }


}
