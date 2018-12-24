package com.main;

import com.main.model.User;
import com.main.model.UserEntity;
import com.main.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootProgresqlApplicationTests {

    @Autowired
    UserService userService;

    @Test
    public void contextLoads() {
        String myname = userService.getString();
        System.out.println("##################################");
        System.out.println(myname);

        List<User> userList = userService.getMyList();
        System.out.println(userList);

    }

    @Test
    public void testMy() {
        List<UserEntity> list = userService.testMapping();
        System.out.println("##################################");
        System.out.println(list);
    }

    @Test
    public void testInsert() {
        UserEntity user = new UserEntity();
        user.setUserName("lily");
        user.setPassWord("123456");
        user.setNickName("丽丽");
        user.setUserSex("女");
        userService.insertData(user);
        System.out.println("##################################");
        System.out.println("sucess");
    }

}
