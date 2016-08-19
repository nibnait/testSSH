package com.nibnait.dao;

import com.nibnait.entity.User;

import java.util.List;

/**
 * Created by nibnait on 2016/8/19.
 */
public interface UserDao {
    public User getUser(String id);

    public List<User> getAllUser();

    public void addUser(User user);

    public boolean delUser(String id);

    public boolean updateUser(User user);

}
