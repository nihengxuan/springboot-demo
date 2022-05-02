package com.sdjzu.group.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sdjzu.group.domain.User;
import com.sdjzu.group.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public int register(User user) {
        return userMapper.register(user);
    }
    @Override
    public User selectUserByName(String username){
        return userMapper.selectUserByName(username);
    }
    @Override
    public User selectById(Integer id){
        return userMapper.selectById(id);
    }
    @Override
    public List<User> selectList(){
        return userMapper.selectList();
    }
    @Override
    public User login(String username,String password) {
        return userMapper.login(username,password);
    }

    @Override
    public PageInfo<User> selectUserListByName(String username,Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> users = userMapper.selectUserListByName(username);
        return new PageInfo<>(users);
    }

    @Override
    public int insertUser(User user) {
        return userMapper.insertUser(user);
    }

    @Override
    public int deleteUserById(Integer id) {
        return userMapper.deleteUserById(id);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public User selectUserById(Integer id) {
        return userMapper.selectUserById(id);
    }


}
