package com.friendit.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.friendit.bean.UserBean;
import com.friendit.services.FriendsService;

@Controller
public class FriendsController {
	
	@Autowired
	FriendsService fs;
	
	@RequestMapping("/friends")
	public String showFriends(Model model){
		
		return"Friends";
	}
	
	@RequestMapping("/searchfriends")
	public String searchFriends(@RequestParam("searchquery")String searchquery,Model model,HttpSession session){
	
		UserBean ub = (UserBean)session.getAttribute("MY_SESSION");
		System.out.println("Session obj"+ub);
		List<UserBean> friends1 = fs.getFriends(searchquery);
		model.addAttribute("searchedUser", friends1);
		System.out.println(friends1);
		
		
		return"Friends";
	}
	
	@RequestMapping("/addasfriend")
	public String sendFriendRequest(@RequestParam("sl") Long sl, Model model){
		return"";
		
	}

}
