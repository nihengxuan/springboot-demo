package com.sdjzu.group.service;

import com.github.pagehelper.PageInfo;
import com.sdjzu.group.domain.User;

import java.util.List;

public interface UserService {
    //注册
    int register(User user);
    User selectUserByName(String  username);
    //登录
    User login(String username,String password);
    User selectById(Integer id);
    //列表左连接
    List<User> selectList();
    /**
     * 分页查询
     * @param username  按username模糊查询
     * @param pageNum
     * @param pageSize
     * @return
     */
     PageInfo<User> selectUserListByName(String username,Integer pageNum, Integer pageSize);
    /**
     * 新增user
     * @return
     */
    int insertUser(User user);
    /**
     * 删除user
     */
    int deleteUserById(Integer id);
    /**
     * 更新user
     */
    int updateUser(User user);

    /**
     * id查询
     * @param id
     * @return
     */
    User selectUserById(Integer id);
}
