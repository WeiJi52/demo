package com.zr.demo.service;

import java.util.List;

import com.zr.demo.model.User;
public interface UserService {
    User selectUserById(Integer userId); 
    List<User> selectAllUsers();
}