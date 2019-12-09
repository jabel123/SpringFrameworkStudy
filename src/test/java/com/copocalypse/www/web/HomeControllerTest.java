package com.copocalypse.www.web;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;

import javax.servlet.ServletException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockServletConfig;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.copocalypse.www.controller.HomeController;
import com.copocalypse.www.vo.User;
import com.copocalypse.www.web.testutil.AbstractDispatcherServletTest;
import com.copocalypse.www.web.testutil.ConfigurableDispatcherServlet;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath:config/*-context.xml", "classpath:web-context.xml" })
public class HomeControllerTest extends AbstractDispatcherServletTest {

	@Test
	public void test() throws ServletException, IOException {
		ConfigurableDispatcherServlet servlet = new ConfigurableDispatcherServlet();
		servlet.setLocations("classpath:config/*-context.xml", "classpath:web-context.xml");
		servlet.init(new MockServletConfig("appServlet"));

		MockHttpServletRequest req = new MockHttpServletRequest("GET", "/sample");
		req.addParameter("id", "1");
		MockHttpServletResponse res = new MockHttpServletResponse();
		servlet.service(req, res);

		ModelAndView mav = servlet.getModelAndView();
		User user = (User) mav.getModel().get("user");
		assertThat(user.getName(), is("주현태"));
	}

	@Test
	public void test2() throws ServletException, IOException {
		ModelAndView mav = setLocations("classpath:config/*-context.xml", "classpath:web-context.xml")
				.initRequest("/sample", RequestMethod.GET).addParameter("id", "1").runService().getModelAndView();
		
		User user = (User) mav.getModel().get("user");
		assertThat(user.getName(), is("주현태"));
	}
}
