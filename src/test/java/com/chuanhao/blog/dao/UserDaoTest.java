package com.chuanhao.blog.dao;

import com.chuanhao.blog.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest{
    @Autowired
    private UserDao userDao;
    @Test
    public void getUserById(){
        User user = userDao.getUserById(1);
        System.out.println(user);
    }

    @Test
    public void insert(){
        User user = userDao.getUserById(1);
        user.setUserId(3);
        user.setUserName("dch");
        user.setUserEmail("465658284@qq.com");
        user.setUserUrl("https://daichuanhao.xom");

        int insert = userDao.insert(user);
        System.out.println(insert);
    }

    @Test
    public void update(){
        User user = userDao.getUserById(1);
        user.setUserId(3);
        user.setUserName("daichuanhao");
        user.setUserEmail("465658284@qq.com");
        user.setUserUrl("https://daichuanhao.xom");
        user.setUserNickname("nickname");
        int update = userDao.update(user);
        System.out.println(update);
    }

    @Test
    public void listUser(){
        List<User> users = userDao.listUser();
        for (User user : users) {
            System.out.println(user);
        }
    }
    @Test
    public void getUserByNameOrEmail(){
        User user = userDao.getUserByEmail("465658284@qq.com");
        System.out.println(user);
    }

}
