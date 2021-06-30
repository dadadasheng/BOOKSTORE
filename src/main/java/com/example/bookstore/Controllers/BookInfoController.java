package com.example.bookstore.Controllers;

import com.example.bookstore.Dao.TokenDao;
import com.example.bookstore.Pojo.Book;
import com.example.bookstore.Pojo.BookCommentOfUser;
import com.example.bookstore.Services.BookCommentService.BookCommentService;
import com.example.bookstore.Services.BookInfoService.BookInfoService;
import com.example.bookstore.Services.BookshelfService.BookshelfService;
import com.example.bookstore.Services.TokenService.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class BookInfoController {
    @Autowired
    BookInfoService bookInfoService;
    @Autowired
    BookshelfService bookshelfService;
    @Autowired
    BookCommentService bookCommentService;
    @Autowired
    TokenService tokenService;
    @CrossOrigin
    @ResponseBody
    @RequestMapping("/getBookById")
    public Book searchBook(int bookId){
        return bookInfoService.getBookById(bookId);
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping("/getRecommendBookById")
    public List<Book> getRecommendBookById(int bookId){
        return bookInfoService.getRecommendBookById(bookId);
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping("/addToBookshelf")
    public Boolean addToBookshelf(String token,String bookId){
        return bookshelfService.addToBookshelf(token, bookId);
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping("/getComment")
    public List<BookCommentOfUser> getComment(int bookId){
        return bookCommentService.getCommentsByBookId(bookId);
    }
    @CrossOrigin
    @ResponseBody
    @RequestMapping("/submitComment")
    public Boolean insertComment(int bookId,String token,String comment){
        bookCommentService.insertComment(token, bookId, comment);
        return true;
    }


    @CrossOrigin
    @ResponseBody
    @RequestMapping("/addLikeNumById")
    public Boolean addLikeNumById(int bookId,String token){
        String phone = tokenService.getPhoneByToken(token);
        bookInfoService.addLikeNumById(bookId);
        bookInfoService.insLikeNum(bookId, phone);
        return true;
    }


    @CrossOrigin
    @ResponseBody
    @RequestMapping("/subLikeNumById")
    public Boolean subLikeNumById(int bookId,String token){
        String phone = tokenService.getPhoneByToken(token);
        bookInfoService.subLikeNumById(bookId);
        bookInfoService.delLikeNum(bookId,phone);
        return true;
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping("/isLike")
    public Boolean isLike(int bookId,String token){
        String phone = tokenService.getPhoneByToken(token);
        Boolean x = bookInfoService.getLikePhoneByBookId(bookId,phone);
        return x;
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping("/isInBookshelf")
    public Boolean isInBookshelf(int bookId,String token){
        String phone = tokenService.getPhoneByToken(token);
        Boolean x = bookshelfService.isInBookshelf(phone,bookId);
        return x;
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping("/likeComment")
    public Boolean likeComment(int bookId,int commentId,String token){
        String phone = tokenService.getPhoneByToken(token);
        System.out.println("点击喜欢的手机号："+phone);
        bookCommentService.likeComment(phone,bookId,commentId);
        return true;
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping("/isLikeComment")
    public Boolean isLikeComment(int bookId,int commentId,String token){
        String phone = tokenService.getPhoneByToken(token);
        Boolean x =bookCommentService.isLikeComment(phone,bookId,commentId);
        return x;
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping("/cancelLikeComment")
    public Boolean cancelLikeComment(int bookId,int commentId,String token){
        String phone = tokenService.getPhoneByToken(token);
        bookCommentService.cancelLikeComment(phone,bookId,commentId);
        return true;
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping("/isCommentOfUser")
    public Boolean isCommentOfUser(int bookId,int commentId,String token){
        System.out.println("书："+bookId+"评论："+commentId+"Token："+token);
        Boolean result = bookCommentService.isCommentOfUser(bookId, commentId, token);
        System.out.println("是否为本人的评论："+result);
        return result;
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping("/delCommentByPhone")
    public void delCommentByPhone(String token, int bookId,int commentId){
        String phone = tokenService.getPhoneByToken(token);
        bookCommentService.delCommentByPhone(phone,bookId,commentId);
    }

}
