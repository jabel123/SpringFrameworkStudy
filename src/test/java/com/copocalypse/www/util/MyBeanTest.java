package com.copocalypse.www.util;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.context.ContextLoaderListener;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/*-context.xml")
public class MyBeanTest {
	@Autowired
	ApplicationContext ac;

	@Test
	public void myTestMethodTest() {
		
		MyBean myBean = (MyBean) ac.getBean("myBean");

		assertThat("test", is(myBean.myTestMethod()));
	}
}
