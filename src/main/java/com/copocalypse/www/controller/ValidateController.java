package com.copocalypse.www.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.copocalypse.www.vo.User;

@Controller
@RequestMapping("validator")
public class ValidateController {

	@RequestMapping(value = "/test")
	public String validateAnnotation(@ModelAttribute @Valid User user, BindingResult result, ModelMap map) {
		if (result.hasFieldErrors()) {
			map.put("mappingResult", false);
		} 
		else {
			map.put("mappingResult", true);
		}

		return "validate";
	}
}
