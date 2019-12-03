package com.copocalypse.www.vo;

import com.copocalypse.www.enums.Role;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
	public User() {	
	}
	private int id;
	private String name;
	private int age;
	private Role role;
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + ", role=" + role + "]";
	}
	
}
