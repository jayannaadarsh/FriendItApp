package com.friendit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.friendit.bean.UserBean;
import com.friendit.services.LoginService;

@Controller
public class AuthenticationController {
	@Autowired
	LoginService loginservice;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(@ModelAttribute("user") UserBean ub, Model model) {
		System.out.println(ub.toString());

		if (ub.getEmail() != "") {
			if (loginservice.validateLogin(ub)) {
				return "Home";
			}
		}
		return "Landing";
	}

}
