package com.zr.demo.dao;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.zr.demo.model.User;

@Mapper
public interface UserDao {  
    public User selectUserById(Integer userId);
    /**
     * 取出所有user
     * @return
     */
    public List<User> selectAllUsers();
  
}  
