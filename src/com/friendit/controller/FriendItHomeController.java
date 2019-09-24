package com.friendit.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.friendit.bean.UserBean;
import com.friendit.services.UserService;

@Controller
public class FriendItHomeController {
	@Autowired
	UserService service;

	@RequestMapping({ "/", "/landing" })
	public String showLandingPage(Model model) {
		model.addAttribute("user", new UserBean());
		return "Landing";
	}

	@RequestMapping("/register")
	public String showRegisterPage(Model model) {
		model.addAttribute("user", new UserBean());
		return "Register";
	}

	@RequestMapping("/saveuser")
	public String saveUser(@ModelAttribute("user") @Valid UserBean ub, BindingResult result, Model model) {
		System.out.println("this is in controlller" + ub);
		if (result.hasErrors())
			return "Register";
		else {
			if(service.createUser(ub))
			model.addAttribute("status", "Registeration Sucess");
			return "RegistrationSuccess";
		}
		

	}

}
