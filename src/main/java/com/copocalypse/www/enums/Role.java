package com.copocalypse.www.enums;

public enum Role {
	ADMIN(1), DEFAULT(2), CLIENT(3);

	private final int role;

	Role(int val) {
		this.role = val;
	}

	public static Role valueOf(int value) {
		switch (value) {
		case 1:
			return ADMIN;
		case 2:
			return DEFAULT;
		case 3:
			return CLIENT;
		default:
			throw new AssertionError("Unknown value : " + value);
		}
	}

	@Override
	public String toString() {
		String result = "";

		switch (this.role) {
		case 1:
			result = "ADMIN";
		case 2:
			result = "DEFAULT";
		case 3:
			result = "CLIENT";
		}
		return result;
	}
}
