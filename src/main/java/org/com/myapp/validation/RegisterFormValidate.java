package org.com.myapp.validation;

import org.com.myapp.form.RegisterForm;
import org.com.myapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

@Service
public class RegisterFormValidate extends AbstractValidator{

	@Autowired
	private UserService userService;
	
	@Override
	public boolean supports(Class<?> arg0) {
		
		return RegisterForm.class.equals(arg0);
	}

	@Override
	public void validate(Object form, Errors errors) {
		RegisterForm registerForm = (RegisterForm)form;
		
		 ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username","register.required");
		 ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "register.required");
		 ValidationUtils.rejectIfEmpty(errors, "password", "register.required");
		 ValidationUtils.rejectIfEmpty(errors, "passwordConfirm", "register.required");
		 
		 System.out.println(registerForm.getEmail());
		 
		
		 // check email exist
		 if(userService.findUserByName(registerForm.getEmail())!= null){
			 errors.rejectValue("email","register.emailExist");
			 
		 }else if(!registerForm.getPassword().equals(registerForm.getPasswordConfirm())){
			 errors.reject("passwordConfirm", "register.passwordConfirmValidate");
		 }
		 
		
	}
	

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	
	
}
