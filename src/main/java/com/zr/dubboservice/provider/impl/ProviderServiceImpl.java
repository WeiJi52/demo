package com.zr.dubboservice.provider.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.zr.demo.dao.UserDao;
import com.zr.demo.model.User;
import com.zr.dubboservice.provider.ProviderService;

@Service(version="1.0.0")
public class ProviderServiceImpl implements ProviderService {
    @Autowired  
    private UserDao userDao; 
	@Override
	public List<User> selectAllUsers() {
		
		return userDao.selectAllUsers();
	}

}
