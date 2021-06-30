package com.example.bookstore.Dao;

import com.example.bookstore.Pojo.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface BookshelfDao {
    public List<Book> getBooksFromBookshelf(@Param("phone") String phone);
    public void insertBookshelf(@Param("phone") String phone,@Param("bookId") String bookId);
    public String selectBookId(@Param("phone") String phone,@Param("bookId") String bookId);
    public void deleteBookFromBookshelf(@Param("phone") String phone,@Param("bookId") int bookId);
    public String isInBookshelf(@Param("phone") String phone,@Param("bookId") int bookId);
}
