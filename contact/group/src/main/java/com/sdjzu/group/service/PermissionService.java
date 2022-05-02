package com.sdjzu.group.service;

import com.sdjzu.group.domain.Permission;
import com.sdjzu.group.domain.RolePermission;

import java.util.List;

public interface PermissionService {
    List<RolePermission> selectPermissionIdByRoleId(Integer roleId);
    Permission selectPermissionById(Integer permissionId);
}
