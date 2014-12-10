package org.com.myapp.controller;

import java.util.Locale;

import javax.validation.Valid;

import org.com.myapp.form.RegisterForm;
import org.com.myapp.form.User;
import org.com.myapp.service.UserService;
import org.com.myapp.validation.RegisterFormValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegisterController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private RegisterFormValidate registerFormValidate;

	@RequestMapping(value = "/user/signup", method = RequestMethod.GET)
	public String registerForm(Locale locale, Model model) {

		RegisterForm registerForm = new RegisterForm();

		model.addAttribute("user", registerForm);
		return "signin/signup";
	}

	@RequestMapping(value = "/user/signup", method = RequestMethod.POST)
	public String register(
			@ModelAttribute("user") @Valid RegisterForm registerForm,
			BindingResult result) {

		registerFormValidate.validate(registerForm, result);
		if (result.hasErrors()) {
			System.out.println("RegisterController: " + result.toString());
			return "signin/signup";
		}

		User user = userService.createUser(registerForm);
		if (userService.autoLogin(user)) {
			return "redirect:/";
		}

		return "signin/signup";

	}

}
