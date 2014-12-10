package org.com.myapp.controller;

import java.util.Locale;

import org.com.myapp.form.ROLE;
import org.com.myapp.form.RegisterForm;
import org.com.myapp.form.User;
import org.com.myapp.hash.HashCode;
import org.com.myapp.model.Role;
import org.com.myapp.model.UserProfile;
import org.com.myapp.service.RoleService;
import org.com.myapp.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
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
	private RoleService roleService;
	
	@Autowired
	private HashCode hashCode;

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
			System.out.println(result.toString());
			return "signin/signup";

		}

		User user = new User();
		user.setUsername(registerForm.getUsername());
		user.setEmail(registerForm.getEmail());
		user.setPassword(hashCode.getHashPassword(registerForm.getPassword()));
		user.setEnabled(true);

		Role r = roleService.findRoleByName(ROLE.ROLE_USER.toString());
		user.setRole(r);

		UserProfile userProfile = user.getUserProfile();
		userService.createUser(userProfile);

		user.setId(userProfile.getId());
		if(auttoLogin(user)){
			return "redirect:/";
		}

		return "signin/signup";

		
	}

	// auto login after register
	public boolean auttoLogin(User user) {

		System.out.println("Register: "+user.getId());
		
		// set authentication here
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
				user, user.getPassword(),
				user.getAuthorities());

		/*authenticationManager.authenticate(token);*/
		/*authenticationManager.authenticate(token);*/
		
		// redirect into secured main page if authentication successful
		if(token.isAuthenticated()){
			SecurityContextHolder.getContext().setAuthentication(token);
			
			return true;
		}
		
		
		return false;
	}
}
