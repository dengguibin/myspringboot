package com.lshjy.crud.service;


import com.lshjy.crud.model.User;

import java.util.List;

public interface UserServiceOrigin {
    int addUser(User user);

    List<User> findAllUser(int pageNum, int pageSize);
}
