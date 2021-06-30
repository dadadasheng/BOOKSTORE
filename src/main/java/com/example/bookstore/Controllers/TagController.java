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
public class TagController {
    @Autowired
    BookInfoService bookInfoService;
    @ResponseBody
    @RequestMapping("/getBookTagByCategory")
    @CrossOrigin
    public List<String> getBookTagByCategory(String category){
        return bookInfoService.getBookTagByCategory(category);
    }

    @ResponseBody
    @RequestMapping("/getBooksByTag")
    @CrossOrigin
    public List<Book> getBooksByTag(String tag){
        return bookInfoService.getBooksByTag(tag);
    }

}
