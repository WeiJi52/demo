package com.zr.dubboservice.provider;
import java.util.List;

import com.zr.demo.model.User;

public interface ProviderService {
	List<User> selectAllUsers();
}
