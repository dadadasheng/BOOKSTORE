package com.example.bookstore.Services.BookshelfService;

import org.apache.ibatis.annotations.Param;

public interface BookshelfService {
    public Boolean addToBookshelf(String phone,String bookId);
    public void deleteBookFromBookshelf(String phone,int bookId);
    public Boolean isInBookshelf(@Param("phone") String phone,@Param("bookId") int bookId);

}
