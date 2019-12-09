package com.copocalypse.www.service;

import org.springframework.transaction.annotation.Transactional;

import com.copocalypse.www.vo.User;

public interface UserService {
	@Transactional
	public void addUser(User user);	
}
