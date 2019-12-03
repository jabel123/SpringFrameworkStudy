package com.copocalypse.www.converter;

import org.springframework.core.convert.converter.Converter;

import com.copocalypse.www.enums.Role;

public class RoleToStringConverter implements Converter<Role, String> {
	@Override
	public String convert(Role from) {
		return from.toString();
	}

}
