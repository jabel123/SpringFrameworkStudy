package com.copocalypse.www.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.copocalypse.www.vo.User;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:config/*-context.xml","classpath:web-context.xml"})
public class UserDaoTest {

	@Autowired
	ApplicationContext ac;
	@Autowired
	UserDao dao;

	@Test
	public void getUserTest() {
		User user=dao.getUser(1);
		assertThat(user.getName(), is("주현태"));
		assertThat(user.getAge(), is(30));
	}
}
