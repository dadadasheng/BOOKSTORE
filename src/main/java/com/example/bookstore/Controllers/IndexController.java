package com.example.bookstore.Controllers;

import com.example.bookstore.Pojo.Book;
import com.example.bookstore.Services.BookInfoService.BookInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@Controller
public class IndexController {
    @Autowired
    BookInfoService bookInfoService;
    @CrossOrigin
    @ResponseBody
    @RequestMapping("/searchBook")
    public Book searchBook(String name){
        return bookInfoService.searchBook(name);
    }
    //新书内容显示
    @ResponseBody
    @RequestMapping("/showNewBook")
    @CrossOrigin
    public List<Book> showNewBook(){
        List<Book> books = bookInfoService.showNewBook();
        return books;
    }

    //图书资讯内容显示
    @ResponseBody
    @RequestMapping("/showBookInfo")
    @CrossOrigin
    public List<Book> showBookInfo(){
        List<Book> books = bookInfoService.showNewBook();
        return books;
    }

    @ResponseBody
    @RequestMapping("/showHotRankBooks")
    @CrossOrigin
    public List<Book> showHotRankBooks(){
        List<Book> books = bookInfoService.showHotRankBooks();
        return books;
    }
    @CrossOrigin
    @ResponseBody
    @RequestMapping("/show4Books")
    public List<Book> show4Books(){

        return bookInfoService.show4Books();
    }
}
