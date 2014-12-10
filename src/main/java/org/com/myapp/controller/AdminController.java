package org.com.myapp.controller;

import java.util.ArrayList;
import java.util.Locale;

import org.com.myapp.model.UserProfile;
import org.com.myapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AdminController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/admin/index.html")
	public String index(Locale locale, Model model) {
		/*User user = (User) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();*/
		
	/*	System.out.println(user.getAuthorities().toString());*/
		
		ArrayList<UserProfile> users = userService.getUserList(0, 15);
		model.addAttribute("users", users);
		
		return "admin/index";
	}

	@RequestMapping(value = "/admin/search.html", method = RequestMethod.POST)
	@ResponseBody
	public ArrayList<UserProfile> search() {

		ArrayList<UserProfile> users = new ArrayList<UserProfile>();

		return users;
	}

	@RequestMapping(value = "/admin/user/list.html", method = RequestMethod.POST)
	@ResponseBody
	public ArrayList<UserProfile> userList(int from, int to) {

		ArrayList<UserProfile> users = userService.getUserList(from, to);
		return users;
	}

	@RequestMapping(value = "/admin/create.html", method = RequestMethod.GET)
	public String add() {

		return "";
	}

	@RequestMapping(value = "/admin/create.html", method = RequestMethod.POST)
	@ResponseBody
	public String addUser(UserProfile user) {

		return "";
	}

	@RequestMapping(value = "/admin/edit.html", method = RequestMethod.GET)
	public String edit() {

		return "";
	}

	@RequestMapping(value = "/admin/edit.html", method = RequestMethod.POST)
	@ResponseBody
	public String editUser(UserProfile user) {

		return "";
	}

}
