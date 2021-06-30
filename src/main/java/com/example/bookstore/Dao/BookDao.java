package com.example.bookstore.Dao;

import com.example.bookstore.Pojo.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BookDao {
    public Book getBookByName(@Param("name") String name);
    public Book getBookById(@Param("bookId") int bookId);
    public List<Book> getTop5NewBookInfo();
    public List<Book> get4BookInfo();
    public List<Book> getHotRankBooks();
    public List<Book> getBookByNameOrAuthor(@Param("text") String text);
    public List<String> getBookTagByCategory(@Param("category") String category);
    public List<Book> getBooksByTag(@Param("tag") String tag);
    public List<Book> getRecommendBookById(@Param("bookId") int bookId);
    public void addLikeNumById(@Param("bookId") int bookId);
    public void subLikeNumById(@Param("bookId") int bookId);
    public void delLikeNum(@Param("bookId") int bookId,@Param("phone")String phone);
    public void insLikeNum(@Param("bookId") int bookId,@Param("phone")String phone);
    public String getLike(@Param("bookId") int bookId,@Param("phone")String phone);
}
