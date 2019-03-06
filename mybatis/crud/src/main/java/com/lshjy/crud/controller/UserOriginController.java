package com.lshjy.crud.controller;

import com.lshjy.crud.model.User;
import com.lshjy.crud.service.UserServiceOrigin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collections;

@Controller
@RequestMapping(value = "/user")
public class UserOriginController {

    @Autowired
    private UserServiceOrigin userServiceOrigin;

    @ResponseBody
    @RequestMapping(value = "/add", produces = {"application/json;charset=UTF-8"})
    public int addUser(User user){
        return userServiceOrigin.addUser(user);
    }

    @ResponseBody
    @RequestMapping(value = "/all/{pageNum}/{pageSize}", produces = {"application/json;charset=UTF-8"})
    public Object findAllUser(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize){
        return userServiceOrigin.findAllUser(pageNum,pageSize);
    }

}
