package com.copocalypse.www.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.copocalypse.www.dao.UserDao;
import com.copocalypse.www.vo.User;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath:config/*-context.xml", "classpath:web-context.xml" })
public class UserServiceTest {
	@Autowired
	@Qualifier(value = "testUserService")
	UserService testUserService;

	@Autowired
	UserDao userDao;

	
	//해당 메서드에 @Transactional 어노테이션을 붙였었으나 그로인해 트랜잭션이 이 메소드로부터 실행되어 예외가 발생하여도 
	//롤백이 되지 않는 현상이 발생하였음. 테스트를 제대로 하기위해 @Transactional 어노테이션 없앰.
	//단, 트랜잭션 전파속성을 조정하면  @Transactional 어노테이션을 붙여놓아도 될 듯함.
	@Test
	public void addUserTest() {
		
		int sStatistic=userDao.getStatistic();
		
		User user = new User();
		user.setName("한승연");
		user.setAge(20);		
		
		try {
			testUserService.addUser(user);
			fail("Exception existing in the addUser method()");
		}catch(TestUserServiceException e) {
			System.out.println("error exist");
		}
		
		int eStatistic=userDao.getStatistic();	
		System.out.println(eStatistic);
		
		assertThat(0, is(eStatistic-sStatistic));
		
	}
	
	
	@Service("testUserService")
	static class TestUserService extends UserServiceImpl{
		private String name="한승연";
		@Override
		public void addUser(User user) {
			super.addUser(user);
			if(user.getName().equals("한승연")) throw new TestUserServiceException();			
		}
	}

	static class TestUserServiceException extends RuntimeException{}
}
