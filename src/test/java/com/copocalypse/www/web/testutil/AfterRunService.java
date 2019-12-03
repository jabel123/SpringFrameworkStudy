package com.copocalypse.www.web.testutil;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

public interface AfterRunService {
	String getContentString();
	WebApplicationContext getContext();
	<T> T getBean(Class<T> beanType);
	ModelAndView getModelAndView();
	AfterRunService assertViewName(String viewName);
	AfterRunService assertModel(String name, Object value);
}
