package com.sdjzu.group.service;

import com.sdjzu.group.domain.UserRole;
import com.sdjzu.group.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleMapper roleMapper;
    @Override
    public UserRole selectRoleIdByUserId(Integer userId) {
        return roleMapper.selectRoleIdByUserId(userId);
    }
}
