package com.sdjzu.group.mapper;

import com.sdjzu.group.domain.Group;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface GroupMapper {
    //@Select("SELECT group_id, group_name FROM group1")
    List<Group> selectGroupList();

    Group selectGroupById(Integer groupId);

    void insertGroup(Group group);

    void deleteGroupById(Integer groupId);
    void updateGroup(Group group);
}
