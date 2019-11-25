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
}
