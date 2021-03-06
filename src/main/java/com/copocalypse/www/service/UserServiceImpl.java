package com.copocalypse.www.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.copocalypse.www.dao.UserDao;
import com.copocalypse.www.vo.User;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDao userDao;
	
	
	@Override
	public void addUser(User user) {
		userDao.addUser(user);
		userDao.addStatistic();		
	} 	
}
