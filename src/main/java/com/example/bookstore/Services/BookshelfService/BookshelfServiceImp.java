package com.example.bookstore.Services.BookshelfService;

import com.example.bookstore.Dao.BookshelfDao;
import com.example.bookstore.Dao.TokenDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookshelfServiceImp implements BookshelfService{
    @Autowired
    BookshelfDao bookshelfDao;
    @Autowired
    TokenDao tokenDao;
    @Override
    public Boolean addToBookshelf(String token, String bookId) {
        String phone = tokenDao.getPhoneByToken(token);
        System.out.println(phone);
        System.out.println(bookshelfDao.selectBookId(phone,bookId));
        if (bookshelfDao.selectBookId(phone,bookId)==null){
            bookshelfDao.insertBookshelf(phone, bookId);
            return true;
        }
        return false;
    }

    @Override
    public void deleteBookFromBookshelf(String phone, int bookId) {
        bookshelfDao.deleteBookFromBookshelf(phone,bookId);
    }

    @Override
    public Boolean isInBookshelf(String phone, int bookId) {
        return bookshelfDao.isInBookshelf(phone, bookId) != null;
    }
}
