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
public class SearchController {
    @Autowired
    BookInfoService bookInfoService;
    @ResponseBody
    @RequestMapping("/searchBooksByText")
    @CrossOrigin
    public List<Book> searchBooksByText(String text){
        if (text.isEmpty()){
            return null;
        }
        List<Book> books = bookInfoService.searchBookByText(text);
        System.out.println(books.size());
        return books;
    }
}
