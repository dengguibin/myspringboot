package com.lshjy.mybatisgenerator.service;

import com.lshjy.mybatisgenerator.model.User;

import java.util.List;

public interface UserService {
    int addUser(User user);

    List<User> findAllUser(int pageNum, int pageSize);
}
