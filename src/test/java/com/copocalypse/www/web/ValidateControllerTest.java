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
import org.springframework.web.servlet.ModelAndView;

import com.copocalypse.www.web.testutil.ConfigurableDispatcherServlet;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath:config/*-context.xml", "classpath:web-context.xml" })
public class ValidateControllerTest {

	@Test
	public void test() throws ServletException, IOException {
		ConfigurableDispatcherServlet servlet = new ConfigurableDispatcherServlet();
		servlet.setLocations("classpath:config/*-context.xml", "classpath:web-context.xml");
		servlet.init(new MockServletConfig("appServlet"));

		
		MockHttpServletResponse res = new MockHttpServletResponse();
		MockHttpServletRequest req = new MockHttpServletRequest("GET", "/validator/test");
		
		servlet.service(req, res);
		ModelAndView mav = servlet.getModelAndView();
		Boolean mappingResult=(Boolean) mav.getModel().get("mappingResult");
		assertThat(mappingResult, is(false));
		
		req.addParameter("name", "ju");
		servlet.service(req, res);
		mav = servlet.getModelAndView();
		mappingResult=(Boolean) mav.getModel().get("mappingResult");
		assertThat(mappingResult, is(false));
		
		
		req.addParameter("age", "30");
		servlet.service(req, res);
		mav = servlet.getModelAndView();
		mappingResult=(Boolean) mav.getModel().get("mappingResult");
		assertThat(mappingResult, is(true));
		
		
	}
}
