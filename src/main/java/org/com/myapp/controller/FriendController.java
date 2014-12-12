package org.com.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FriendController {
	@RequestMapping(value = "/friend", method = RequestMethod.GET)
	public String friendPage(Model model){
		return "friend";
	}
}
