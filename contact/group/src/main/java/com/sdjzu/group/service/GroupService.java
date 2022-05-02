package com.sdjzu.group.service;

import com.sdjzu.group.domain.Group;
import org.springframework.stereotype.Service;

import java.util.List;


public interface GroupService {
    List<Group> selectGroupList();

    Group selectGroupById(Integer groupId);

    void insertGroup(Group group);

    void deleteGroupById(Integer groupId);

    void updateGroup(Group group);


}