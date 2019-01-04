package com.main.controler;

import com.github.pagehelper.util.PageObjectUtil;
import com.main.entity.PageList;
import com.main.entity.PagesResult;
import com.main.pagemodel.BaseResult;
import com.main.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.main.mapper.UserMapper;
import com.main.model.UserEntity;

import java.util.Collection;
import java.util.Collections;

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
        PageList<UserEntity> userList = userService.getUserList(user, currentPage, pageSize);
        return userList;
    }

    @RequestMapping(value = "/getUsersList2/{currentPage}/{pageSize}", method = RequestMethod.POST)
    public BaseResult getUsers2(@RequestBody UserEntity user, @PathVariable("currentPage") Integer currentPage,
                               @PathVariable("pageSize") Integer pageSize) {
        PageList<UserEntity> userList = userService.getUserList(user, currentPage, pageSize);
        PagesResult<UserEntity> result = new PagesResult<UserEntity>(userList);
        return result;
    }

    @RequestMapping(value = "/getUser/{id}",method = RequestMethod.GET)
    public UserEntity getUser(@PathVariable("id") Long id) {
        UserEntity user = userMapper.getOne(id);
        return user;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Long save(@RequestBody UserEntity user) {

        return userService.insertData(user);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public void update(@RequestBody  UserEntity user,@PathVariable("id") Long id) {
        userMapper.update(user, id);
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        userMapper.delete(id);
        return "success";
    }
}
