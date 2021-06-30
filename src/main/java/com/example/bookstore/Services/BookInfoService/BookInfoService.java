package com.example.bookstore.Services.BookInfoService;

import com.example.bookstore.Pojo.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookInfoService {
    public Book searchBook(String name);
    public List<Book> showNewBook();
    public List<Book> show4Books();
    public List<Book> showHotRankBooks();
    public Book getBookById(int bookId);
    public List<Book> searchBookByText(String text);
    public List<String> getBookTagByCategory(String category);
    public List<Book> getBooksByTag(String tag);
    public List<Book> getRecommendBookById(int bookId);
    public void addLikeNumById(int bookId);
    public void subLikeNumById(int bookId);
    public void delLikeNum(int bookId,String phone);
    public void insLikeNum(int bookId,String phone);
    public Boolean getLikePhoneByBookId(int bookId,String phone);
}
