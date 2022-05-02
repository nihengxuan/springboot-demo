package com.sdjzu.group.service;

import com.sdjzu.group.domain.UserRole;

import java.util.List;

public interface RoleService {
    UserRole selectRoleIdByUserId(Integer userId);
}
