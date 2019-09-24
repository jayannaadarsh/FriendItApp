package com.friendit.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.friendit.bean.UserBean;
import com.friendit.services.LoginService;

@Controller
@SessionAttributes("ub")
public class AuthenticationController {
	@Autowired
	LoginService loginservice;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(@ModelAttribute("user") UserBean ub, Model model, HttpServletRequest request) {
		if (ub.getEmail() != "" && ub.getPassword() != "") {
			if (loginservice.validateLogin(ub)) {
				UserBean ub_session_obj = loginservice.getUserByEmail(ub.getEmail());
				UserBean session_Obj = (UserBean) request.getSession().getAttribute("MY_SESSION");
				ub = ub_session_obj;
				session_Obj = ub_session_obj;
				request.getSession().setAttribute("MY_SESSION", session_Obj);
				model.addAttribute("ub", ub);
				System.out.println("inside login session" + ub.toString());
				return "Home";
			}
		}
		model.addAttribute("status", "Invalid credentials. Please provide valid information.");
		return "Landing";
	}

	@RequestMapping("/logout")
	public String logout(@ModelAttribute("user") UserBean ub, HttpServletRequest request) {
		request.getSession().invalidate();
		return "Landing";
	}

}
