package com.copocalypse.www.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.copocalypse.www.enums.Role;
import com.copocalypse.www.vo.User;

@Controller
public class RoleTestController {
	
	@RequestMapping(value = "/roleparamtest")
	public String RoleTest(@RequestParam Role role, ModelMap map) {
		map.put("role", role.name());

		return "home";
	}

	@RequestMapping(value = "/roleobjtest")
	public String RoleObjTest(@ModelAttribute User user) {
		return "home";
	}
}
