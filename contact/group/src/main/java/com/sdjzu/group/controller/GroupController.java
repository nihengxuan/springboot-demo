package com.sdjzu.group.controller;

import com.sdjzu.group.domain.Group;
import com.sdjzu.group.service.GroupService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class GroupController {

    @Autowired
    GroupService groupService;

    @GetMapping("/selectList")
    public List<Group> selectList() {
        log.info("这是我写的日志！");

        List<Group> groups = groupService.selectGroupList();
        return groups;
    }
}
