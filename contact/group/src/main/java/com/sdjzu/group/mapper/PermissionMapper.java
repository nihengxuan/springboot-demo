package com.sdjzu.group.mapper;

import com.sdjzu.group.domain.Permission;
import com.sdjzu.group.domain.Role;
import com.sdjzu.group.domain.RolePermission;
import com.sdjzu.group.domain.UserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PermissionMapper {
    @Select("select * from role_permission where role_id = #{roleId}")
    List<RolePermission> selectPermissionIdByRoleId(Integer roleId);
    @Select("select * from permissions where id = #{permissionId}")
   Permission selectPermissionById(Integer permissionId);
}
