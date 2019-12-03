package com.copocalypse.www.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.copocalypse.www.vo.User;

@Component("userValidator")
public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return (User.class.isAssignableFrom(clazz));
	}

	@Override
	public void validate(Object target, Errors errors) {
		User user = (User) target;
		ValidationUtils.rejectIfEmpty(errors, "name", "field.required");
		ValidationUtils.rejectIfEmpty(errors, "age", "field.required");
		if (errors.getFieldError("age") == null)
			if (user.getAge() <= 0)
				errors.rejectValue("name", "field.min", new Object[] { 0 }, "min default");
	}

}
