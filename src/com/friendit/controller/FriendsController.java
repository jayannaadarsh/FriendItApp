package com.friendit.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.friendit.bean.UserBean;
import com.friendit.services.FriendsService;

@Controller
public class FriendsController {

	@Autowired
	FriendsService fs;

	@RequestMapping("/friends")
	public String showFriends(Model model, HttpSession session) {
		UserBean ub = (UserBean) session.getAttribute("MY_SESSION");
		System.out.println(ub);
		List<UserBean> friendRequest = fs.getFriendRequest(ub);
		if (friendRequest.isEmpty()) {
			model.addAttribute("requststatus", "False");
		}
		model.addAttribute("requststatus", "True");
		model.addAttribute("friendrequests", friendRequest);
		return "Friends";
	}

	@RequestMapping("/searchfriends")
	public String searchFriends(@RequestParam("searchquery") String searchquery, Model model, HttpSession session) {

		UserBean ub = (UserBean) session.getAttribute("MY_SESSION");
		System.out.println("Session obj" + ub);
		List<UserBean> friends1 = fs.getFriends(searchquery);
		model.addAttribute("searchedUser", friends1);
		System.out.println(friends1);

		return "Friends";
	}

	@RequestMapping(value = "/addasfriend", method = RequestMethod.POST)
	public String sendFriendRequest(@RequestParam("receiverId") Long receiverId, Model model, HttpSession session) {
		UserBean ub = (UserBean) session.getAttribute("MY_SESSION");
		System.out.println("Session obj" + receiverId);
		String sendFriendRequest = fs.sendFriendRequest(ub, receiverId);
		model.addAttribute("requestStatus", sendFriendRequest);
		return "Friends";
	}

	@RequestMapping(value = "/rejectrequest", method = RequestMethod.POST)
	public String rejectFriendRequest(@RequestParam("senderid") Long senderid, Model model, HttpSession session) {
		UserBean ub = (UserBean) session.getAttribute("MY_SESSION");
		String rejectRequeststatus = fs.rejectRequest(ub, senderid);
		System.out.println(rejectRequeststatus);
		return"Friends";
	}

	@RequestMapping(value = "/accceptRequest", method = RequestMethod.POST)
	public String acceptFriendRequest(@RequestParam("senderid") Long senderid, Model model, HttpSession session) {
		UserBean ub = (UserBean) session.getAttribute("MY_SESSION");
		String acceptFriendRequest = fs.acceptFriendRequest(ub, senderid);
		model.addAttribute("acceptStatus", acceptFriendRequest);
		return "Friends";
	}
}
