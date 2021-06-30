package com.example.bookstore.Dao;

import com.example.bookstore.Pojo.BookCommentOfUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface CommentsDao {
    public List<BookCommentOfUser> getCommentsByBookId(@Param("bookId") int bookId);
    public void insertComment(@Param("phone") String phone,@Param("bookId") int bookId,@Param("comment") String comment);
    public void likeComment(@Param("phone") String phone,@Param("bookId") int bookId,@Param("commentId") int commentId);
    public String isLikeComment(@Param("phone") String phone,@Param("bookId") int bookId,@Param("commentId") int commentId);
    public void cancelLikeComment(@Param("phone") String phone,@Param("bookId") int bookId,@Param("commentId") int commentId);
    public String getPhoneByCommentId(@Param("bookId") int bookId,@Param("commentId") int commentId);
    public void delCommentByPhone(@Param("phone") String phone,@Param("commentId") int commentId);
    public void addCommentLikeNum(@Param("commentId") int commentId);
    public void subCommentLikeNum(@Param("commentId") int commentId);
}
