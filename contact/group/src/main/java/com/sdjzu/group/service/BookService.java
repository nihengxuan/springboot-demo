package com.sdjzu.group.service;

import com.github.pagehelper.PageInfo;
import com.sdjzu.group.domain.Book;
import com.sdjzu.group.mapper.BookMapper;

import java.util.List;

public interface BookService {

    //分页查询
    PageInfo<Book> secletBookByName(Integer pageNum,Integer pageSize,String name);

    //添加操作
    int insertBook(Book book);
    /**
     * 删除user
     */
    int deleteBookById(Integer id);
    /**
     * 更新user
     */
    int updateBook(Book book);
}
