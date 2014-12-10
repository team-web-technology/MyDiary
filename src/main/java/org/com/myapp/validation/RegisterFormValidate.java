package org.com.myapp.validation;

import org.com.myapp.form.RegisterForm;
import org.com.myapp.model.UserProfile;
import org.com.myapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

@Service
public class RegisterFormValidate extends AbstractValidator {

	@Autowired
	private UserService userService;

	@Override
	public boolean supports(Class<?> clazz) {

		return RegisterForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object form, Errors errors) {
		RegisterForm registerForm = (RegisterForm) form;

		if (!registerForm.getPassword().equals(
				registerForm.getPasswordConfirm())) {
			errors.rejectValue("passwordConfirm",
					"register.passwordConfirmValidate");
		}

		if (isEmailExists(registerForm.getEmail())) {
			errors.rejectValue("email", "register.emailExist");
		}

	}

	public Boolean isEmailExists(String email) {
		System.out.println(email);
		UserProfile userProfile = userService.findUserByName(email);

		if (userProfile != null) {
			return true;
		}

		return false;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
