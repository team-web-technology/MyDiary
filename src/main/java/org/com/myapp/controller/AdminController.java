package org.com.myapp.controller;

import java.util.Locale;

import org.com.myapp.form.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

	@RequestMapping(value="/admin/index.html")
	public String index(Locale locale, Model model){
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println(user.getAuthorities().toString());
		
		
		return "admin/index";
	}
}
