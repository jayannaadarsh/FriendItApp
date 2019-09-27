package com.friendit.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.friendit.bean.UserBean;

@Controller
public class WallController {
	@RequestMapping("/wallpost")
	public String postOnWall(@RequestParam("content")String content, HttpSession session){
		UserBean ub = (UserBean) session.getAttribute("MY_SESSION");
		System.out.println(ub);
		System.out.println(content);
		return"Home";
		
	}

}
