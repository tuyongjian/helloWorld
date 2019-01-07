package com.tu.curd.dao;

import com.tu.curd.model.User;

/**
 * Created by tuyongjian on 2019/1/6.
 */
public interface UserDao {

    public User selectUser(int id);

    void insert(User user);
}
