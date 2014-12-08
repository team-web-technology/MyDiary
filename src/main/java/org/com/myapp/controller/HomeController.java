package org.com.myapp.controller;

import java.util.Locale;

import org.com.myapp.form.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		if(user == null){
			return "signin/signin";
		}else{
			model.addAttribute("username", user.getUsername());
			return "home";
		}
		
	}
	
}
