package com.copocalypse.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.copocalypse.www.dao.UserDao;
import com.copocalypse.www.enums.Role;

/**
 * Handles requests for the application home page.
 */
@Controller
@SessionAttributes("user")
public class HomeController {

	@Autowired
	UserDao userDao;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String rootPath() {		
		return "home";
	}

	@RequestMapping(value = "/sample")
	public String pathVariableSamplePOST(@RequestParam int id, Model model) {
		model.addAttribute("user", userDao.getUser(id));
		return "samplePath";
	}

}
