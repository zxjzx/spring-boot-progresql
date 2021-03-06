package com.main;

import com.github.pagehelper.PageInfo;
import com.main.entity.PageList;
import com.main.mapper.UserMapper;
import com.main.model.User;
import com.main.model.UserEntity;
import com.main.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@org.springframework.boot.test.context.SpringBootTest
public class SpringBootTest {

    @Autowired
    UserService userService;

    @Autowired
    UserMapper userMapper;

    @Test
    public void contextLoads() {
        String myname = userService.getString();
        System.out.println("##################################");
        System.out.println(myname);

        List<User> userList = userService.getMyList();
        System.out.println(userList);

    }

    @Test
    public void testUserList() {
        UserEntity user = new UserEntity();
        user.setUserName("lily");
        PageList<UserEntity> userList = userService.getUserList(user,2,3);
        System.out.println("##################################");
        System.out.println(userList);
    }

    @Test
    public void GetMyList() {
        UserEntity user = new UserEntity();
        user.setUserName("lily");
        userService.getMyList(user,2,3);
        System.out.println("##################################");
    }

    @Test
    public void insert() {
        UserEntity user = new UserEntity();
        user.setUserName("lily");
        user.setPassWord("123456");
        user.setNickName("丽丽");
        user.setUserSex("女");
        userService.insertData(user);

    }

    @Test
    public void delete() {
        Long id = new Long(16);
        Long result = userService.deleteData(id);
        System.out.println("##################################");
        System.out.println(result);
    }

    @Test
    public void update(){
        UserEntity user = new UserEntity();
        user.setId((long) 7);
        user.setUserName("zxj");
        userMapper.update(user, (long) 7);
    }

    @Test
    public void getUser(){
        UserEntity one = userMapper.getOne((long) 7);
        System.out.println("##################################");
        System.out.println(one);
    }

}
