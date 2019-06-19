package com.zr.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import com.zr.demo.dao.UserDao;
import com.zr.demo.model.User;
import com.zr.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService{
    @Autowired  
    private UserDao userDao;  
    
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    
    @Override
    public User selectUserById(Integer userId) {
        return userDao.selectUserById(userId);  
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<User> selectAllUsers() {
		ValueOperations<String, Object> operations = redisTemplate.opsForValue();
		String key = "users";
		List<User> users;
		// 缓存存在
		boolean hasKey = redisTemplate.hasKey(key);
		if (hasKey) {
			users = (List<User>) operations.get(key);
			System.out.println("从 redis取出数据");
			return users;
		}
		
		users = (List<User>) userDao.selectAllUsers();
		operations.set(key, users);
		
		
		return users;
	}
}