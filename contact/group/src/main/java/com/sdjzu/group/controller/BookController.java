package com.sdjzu.group.controller;

import com.github.pagehelper.PageInfo;
import com.sdjzu.group.domain.Book;
import com.sdjzu.group.domain.Result;
import com.sdjzu.group.domain.User;
import com.sdjzu.group.service.BookService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;
    @GetMapping("/list")
    public Result selectBookByName(@RequestParam(defaultValue = "1") Integer pageNum,
                                   @RequestParam(defaultValue = "10") Integer pageSize,
                                   @RequestParam String name){
        PageInfo<Book> userPageInfo = bookService.secletBookByName(pageNum, pageSize,name);
        Result result = new Result();
        result.setData(userPageInfo);
        result.setCode("200");
        return result;
    }
    @PostMapping("/insert")
    public Result insertBook(@RequestBody Book book){
        bookService.insertBook(book);
        Result result = new Result();
        result.setCode("200");
        result.setData(book);
        return result;
    }
    @DeleteMapping("/{id}")
    public Result deleteBookById(@PathVariable Integer id){
        Result result = new Result();
        bookService.deleteBookById(id);
        result.setCode("200");
        result.setMsg("删除成功");
        return result;
    }
    @PutMapping("/update")
    public Result updateBook(@RequestBody Book book){
        Result result = new Result();
        bookService.updateBook(book);
        result.setCode("200");
        result.setMsg("更新成功");
        return result;
    }

}
