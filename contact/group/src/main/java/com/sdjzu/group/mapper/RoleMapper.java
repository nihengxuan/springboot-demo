package com.sdjzu.group.mapper;


import com.sdjzu.group.domain.UserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RoleMapper {
    @Select("select * from user_role where user_id = #{userId}")
    UserRole selectRoleIdByUserId(Integer userId);
}
