package org.com.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "signin/signin";
	}
	
	@RequestMapping(value ="/lockme.htm")
	@ResponseBody
	public String lockMe(){
		
		return "csdcsdfsdf";
	}
}
