package com.main.controler;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.main.entity.PageCondition;
import com.main.entity.PageList;
import com.main.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import com.main.mapper.UserMapper;
import com.main.model.UserEntity;

@RestController
@RequestMapping("/user")
public class UserEntityControler {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getUsersList/{currentPage}/{pageSize}", method = RequestMethod.POST)
    public PageList<UserEntity> getUsers(@RequestBody UserEntity user, @PathVariable("currentPage") Integer currentPage,
                                         @PathVariable("pageSize") Integer pageSize) {
        Assert.notNull(currentPage, "currentPage不能为空");
        PageList<UserEntity> userList = userService.getUserList(user, currentPage, pageSize);
        return userList;
    }

    @RequestMapping("/getUser")
    public UserEntity getUser(Long id) {
        UserEntity user = userMapper.getOne(id);
        return user;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Long save(@RequestBody UserEntity user) {
        return userService.insertData(user);
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public void update(UserEntity user) {
        userMapper.update(user);
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        userMapper.delete(id);
        return "success";
    }
}
