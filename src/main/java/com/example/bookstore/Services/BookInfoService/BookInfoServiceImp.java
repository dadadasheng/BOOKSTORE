package com.example.bookstore.Services.BookInfoService;

import com.example.bookstore.Dao.BookDao;
import com.example.bookstore.Pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookInfoServiceImp implements BookInfoService {
    @Autowired
    BookDao bookDao;
    @Override
    public Book searchBook(String name) {
        return bookDao.getBookByName(name);
    }

    @Override
    public List<Book> showNewBook() {
        return bookDao.getTop5NewBookInfo();
    }

    @Override
    public List<Book> show4Books() {
        return bookDao.get4BookInfo();
    }

    @Override
    public List<Book> showHotRankBooks() {
        return bookDao.getHotRankBooks();
    }

    @Override
    public Book getBookById(int bookId) {
        return bookDao.getBookById(bookId);
    }

    @Override
    public List<Book> searchBookByText(String text) {
        List<Book> books = bookDao.getBookByNameOrAuthor(text);
        return books;
    }

    @Override
    public List<String> getBookTagByCategory(String category) {
        return bookDao.getBookTagByCategory(category);
    }

    @Override
    public List<Book> getBooksByTag(String tag) {
        return bookDao.getBooksByTag(tag);
    }

    @Override
    public List<Book> getRecommendBookById(int bookId) {
        return bookDao.getRecommendBookById(bookId);
    }

    @Override
    public void addLikeNumById(int bookId) {
        bookDao.addLikeNumById(bookId);
    }

    @Override
    public void subLikeNumById(int bookId) {
        bookDao.subLikeNumById(bookId);
    }

    @Override
    public void delLikeNum(int bookId, String phone) {
        bookDao.delLikeNum(bookId, phone);
    }

    @Override
    public void insLikeNum(int bookId, String phone) {
        bookDao.insLikeNum(bookId, phone);
    }

    @Override
    public Boolean getLikePhoneByBookId(int bookId, String phone) {

        return bookDao.getLike(bookId, phone) != null;
    }

}
