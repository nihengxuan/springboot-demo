package com.sdjzu.group;

import com.sdjzu.group.domain.Group;
import com.sdjzu.group.mapper.GroupMapper;
import com.sdjzu.group.service.GroupService;
import net.minidev.json.JSONUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class GroupApplicationTests {

    @Autowired
    GroupService groupService;



    @Test
    void contextLoads() {
    }


    @Test
    void testSelectList() {
        List<Group> groups = groupService.selectGroupList();
        groups.forEach(System.out::println);

    }
/*
    @Test
    void testSelectGroupById() {
        Group group1 = groupService.selectGroupById(4);
        System.out.print(group1);

    }

    @Test
    void testInsertGroup(){
        Group group2=new Group();
        group2.setGroupName("客户12");
        groupService.insertGroup(group2);
        *//*
        Boolean aBoolean = groupMapper.insertGroup(group2);
        System.out.println(aBoolean);*//*

    }
    @Test
    void testDeleteGroup(){

        *//*Boolean aBoolean = groupMapper.deleteGroupById(4);
        System.out.println(aBoolean);*//*


    }

    @Test
    void testUpdateGroup(){
        Group group4=new Group();
        group4.setGroupId((long) 1);
        group4.setGroupName("倪某");
        *//*Boolean aBoolean = groupMapper.updateGroup(group4);
        System.out.println(aBoolean);*//*

    }*/

}
