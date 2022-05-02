package com.sdjzu.group.service;

import com.sdjzu.group.domain.Permission;
import com.sdjzu.group.domain.RolePermission;
import com.sdjzu.group.mapper.PermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    PermissionMapper permissionMapper;
    @Override
    public List<RolePermission> selectPermissionIdByRoleId(Integer roleId) {
        return permissionMapper.selectPermissionIdByRoleId(roleId);
    }

    @Override
    public Permission selectPermissionById(Integer permissionId) {
        return permissionMapper.selectPermissionById(permissionId);
    }

}
