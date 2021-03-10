package com.shop.dao.impl;

import com.shop.bean.User;
import com.shop.dao.BaseDao;
import com.shop.dao.UserDao;

/**
 * @author WuLiangHang
 */
public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public User queryUserByUsername(String username) {
        String sql = "SELECT `id`, `username`, `password`, `email` FROM login WHERE `username` = ?";
        return super.queryForOne(User.class, sql, username);
    }


    public User queryCheckUser(String username,String password){
        String sql = "SELECT `id`, `username`, `password`, `email` FROM login WHERE `username` = ? AND `password` = ?";
        return super.queryForOne(User.class, sql, username,password);
    }


//    public User queryUserByPassword(String Password) {
//        String sql = "SELECT `id`, `username`, `password`, `email` FROM login WHERE `password` = ?";
//        return super.queryForOne(User.class, sql, Password);
//    }


    public int addUser(User user) {
        String sql = "INSERT login(id,username,`password`,email) VALUES (?,?,?,?) ";
        Object[] params = {user.getId(),user.getUsername(),user.getPassword(),user.getEmail()};
        return super.update(sql,params);
    }


}
