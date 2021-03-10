package com.shop.test;

import com.shop.bean.User;
import com.shop.dao.UserDao;
import com.shop.dao.impl.UserDaoImpl;
import org.junit.Test;

/**
 * @author WuLiangHang
 */
public class UserDaoTest {

    UserDao userDao = new UserDaoImpl();
    @Test
    public void queryUserByUsername(){
        System.out.println(userDao.queryUserByUsername("admin"));
    }

    @Test
    public void addUser(){
        User user = new User();
//        user.setId(3);
        user.setUsername("3434");
        user.setPassword("2131");
        user.setEmail("3123@qq.com");
        System.out.println(userDao.addUser(user)
        );
    }

}
