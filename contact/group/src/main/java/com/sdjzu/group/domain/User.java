package com.sdjzu.group.domain;


import ch.qos.logback.classic.db.names.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.HashSet;
import java.util.List;

@Data
public class User {
//    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private String username;
    private String password;
    private String nickName;
    private Integer age;
    private String sex;
    private String address;
    @TableField( exist = false)
    private List<Book> booklist;
    @TableField( exist = false)
    private HashSet<Permission> permission;
}
