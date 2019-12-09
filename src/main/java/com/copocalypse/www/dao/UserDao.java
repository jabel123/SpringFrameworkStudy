package com.copocalypse.www.dao;

import com.copocalypse.www.vo.User;

public interface UserDao{
	public User getUser(int uerId);
	public int addUser(User user);
	public int addStatistic();
	public int getStatistic();
}
