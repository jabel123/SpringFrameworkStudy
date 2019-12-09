package com.copocalypse.www.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.copocalypse.www.vo.User;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
	@Autowired
	SqlSession sqlSession;

	@Override
	public User getUser(int uerId) {
		User user = sqlSession.selectOne("user.selectUser", uerId);
		return user;
	}

	@Override
	public int addUser(User user) {
		int result=sqlSession.insert("user.insertUser", user);
		return result;
	}

	@Override
	public int addStatistic() {
		int result=sqlSession.update("user.updateStatistic");
		return result;
	}

	@Override
	public int getStatistic() {
		int result=sqlSession.selectOne("user.selectStatistic");
		
		return result;
	}
}
