package org.com.myapp.controller;

import java.util.Locale;

import org.com.myapp.form.RegisterForm;
import org.com.myapp.form.User;
import org.com.myapp.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegisterController {

	@Autowired
	private UserService userService;
	
	

	@Autowired
	@Qualifier("authenticationManager")
	private AuthenticationManager authenticationManager;

	@Autowired
	@Qualifier("registerFormValidate")
	private Validator validator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	private static final Logger logger = LoggerFactory
			.getLogger(RegisterController.class);

	@RequestMapping(value = "/user/signup", method = RequestMethod.GET)
	public String registerForm(Locale locale, Model model) {

	
		
		
		RegisterForm registerForm = new RegisterForm();
		
		model.addAttribute("user", registerForm);
		return "signin/signup";
	}

	@RequestMapping(value = "/user/signup", method = RequestMethod.POST)
	public String register(
			@ModelAttribute("user") @Validated RegisterForm registerForm,
			BindingResult result) {

		if (result.hasErrors()) {
			System.out.println("RegisterController: "+result.toString());
			return "signin/signup";

		}

		User user = userService.createUser(registerForm);
		if(userService.autoLogin(user)){
			return "redirect:/";
		}

		return "signin/signup";

		
	}

}
