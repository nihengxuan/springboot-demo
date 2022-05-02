package com.sdjzu.group.controller;

import com.github.pagehelper.PageInfo;
import com.sdjzu.group.domain.*;
import com.sdjzu.group.mapper.UserMapper;
import com.sdjzu.group.service.PermissionService;
import com.sdjzu.group.service.RoleService;
import com.sdjzu.group.service.UserService;
import com.sdjzu.group.utils.TokenUtils;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;
    @Autowired
    PermissionService permissionService;
    @PostMapping("/register")
    public  Result register(@RequestBody User user){
        Result result = new Result();

        User users = userService.selectUserByName(user.getUsername());
        if (users != null){
            result.setCode("400");
            return result;
        }else {
            userService.register(user);
            result.setCode("200");
            return result;
        }
    }
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        return Result.success(userService.selectById(id));
    }


    /*
        登录
     */
    @GetMapping("/login")
    public Result login(@RequestParam(value = "username") String username,
                        @RequestParam(value = "password") String password){
        Result result=new Result();
        User  loginuser= userService.login(username, password);

        if(loginuser == null ){
            result.setCode("400");
            return result;
        }
        User user1 = userService.selectUserByName(username);
//        session.setAttribute("user1",user1);
//        String token = TokenUtils.genToken(user1);
//        user1.setToken(token);
        /**
         * 拿到登陆用户的id，
         * 去role_user表里查到对应的roleId，
         * 然后通过roleId查到permissionId，
         * 通过permissionId去permissions表里查询，
         */
        HashSet<Permission> permissionHashSet = new HashSet<>();
        UserRole userRole = roleService.selectRoleIdByUserId(user1.getId());
        List<RolePermission> rolePermissions = permissionService.selectPermissionIdByRoleId(userRole.getRoleId());
        for (RolePermission rolePermission : rolePermissions ){
            Permission permission = permissionService.selectPermissionById(rolePermission.getPermissionId());
            permissionHashSet.add(permission);
        }
        user1.setPermission(permissionHashSet);
        result.setData(user1);
        result.setCode("200");
        return result;

    }


    @PostMapping
    public User addUser(@RequestBody User user){
        if(user.getPassword() == null){
            user.setPassword("123456");
        }
        userService.insertUser(user);
        return user;

    }

    @PutMapping
    public User updateUser(@RequestBody User user){
        if(user.getPassword() == null){
            user.setPassword("123456");
        }
        userService.updateUser(user);
        return user;

    }
    @DeleteMapping("/{id}")
    public int  updateUser(@PathVariable Integer id){

        int i = userService.deleteUserById(id);

        return i;

    }

    @GetMapping
    public Map<String, Object> selectUserByPage(  @RequestParam(value="username")String username,
                                         @RequestParam(value="pageNum") Integer pageNum,
                                         @RequestParam(value="pageSize") Integer pageSize) {
        PageInfo<User> userPageInfo = userService.selectUserListByName(username, pageNum, pageSize);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("pagedata", userPageInfo);
        map.put("number", userPageInfo.getTotal());
        //System.out.println(userPageInfo);
        return map;
    }
    //获取列表
    @GetMapping("/list")
    public Result selectList(){
        List<User> users= userService.selectList();
        return Result.success(users);
    }
}
