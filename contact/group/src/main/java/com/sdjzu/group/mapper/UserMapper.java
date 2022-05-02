package com.sdjzu.group.mapper;

import com.sdjzu.group.domain.Group;
import com.sdjzu.group.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface UserMapper {
    //注册
    int register(User user);
    User selectUserByName(String  username);
    //登录
    User login(@Param("username") String username, @Param("password") String password);
    //分页查询
    List<User> selectUserListByName(String  username);
    User selectById(Integer id);
    //一对多查询，左连接
    List<User> selectList();
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
