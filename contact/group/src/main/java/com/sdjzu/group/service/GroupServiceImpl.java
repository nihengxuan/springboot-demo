package com.sdjzu.group.service;

import com.sdjzu.group.domain.Group;
import com.sdjzu.group.mapper.GroupMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GroupServiceImpl implements GroupService{

    @Autowired
    GroupMapper groupMapper;

    @Override
    public List<Group> selectGroupList() {
        return groupMapper.selectGroupList();
    }

    @Override
    public Group selectGroupById(Integer groupId) {
        return null;
    }

    @Override
    public void insertGroup(Group group) {

    }

    @Override
    public void deleteGroupById(Integer groupId) {

    }

    @Override
    public void updateGroup(Group group) {

    }
}
