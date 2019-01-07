package com.tu.curd.service;

import com.tu.curd.model.User;

/**
 * Created by tuyongjian on 2019/1/6.
 */
public interface IUserService {

    public User queryUser(int id);

    void addUser(User user);
}
