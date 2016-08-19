package com.nibnait.service;

import com.nibnait.dao.UserDao;
import com.nibnait.entity.User;

import java.util.List;

/**
 * Created by nibnait on 2016/8/19.
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public User getUser(String id) {
        return userDao.getUser(id);
    }

    public List<User> getAllUser() {
        return userDao.getAllUser();
    }

    public void addUser(User user) {
        userDao.addUser(user);
    }

    public boolean delUser(String id) {

        return userDao.delUser(id);
    }

    public boolean updateUser(User user) {
        return userDao.updateUser(user);
    }

}
