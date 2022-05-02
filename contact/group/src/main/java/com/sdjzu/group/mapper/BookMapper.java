package com.sdjzu.group.mapper;

import com.sdjzu.group.domain.Book;
import com.sdjzu.group.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface BookMapper {
    //分页查询
    List<Book> secletBookByName(String name);
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
