package com.copocalypse.www.converter;

import org.springframework.core.convert.converter.Converter;

import com.copocalypse.www.enums.Role;

public class StringToRoleConverter implements Converter<String, Role>{
	@Override
	public Role convert(String from) {
		Role r=Role.valueOf(Integer.parseInt(from));
		return r;
	}
}
