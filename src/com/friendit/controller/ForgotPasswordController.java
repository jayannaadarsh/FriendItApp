package com.friendit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.friendit.services.ForgotPasswordService;

@Controller
public class ForgotPasswordController {

	@Autowired
	ForgotPasswordService passwordservice;

	@RequestMapping("/ForgotPassword")
	public String forgotPassword_Enter_Email() {
		return "ForgotPassword";
	}

	@RequestMapping("/ResetPassword")
	public String sendNewPassword(@RequestParam("email") String email, Model model) {
		if (email != "") {

			boolean resetPassword = passwordservice.resetPassword(email);
			if (resetPassword) {
				model.addAttribute("message", "Your password has been reset. Please check your e-mail");
				return "ForgotPassword";
			} else {
				model.addAttribute("message", "Something went wrong!");
				return "ForgotPassword";

			}
		} else {
			model.addAttribute("message", "Something went wrong!");
			return "ForgotPassword";
		}

	}

}
