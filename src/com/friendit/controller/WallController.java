package com.friendit.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.friendit.bean.UserBean;
import com.friendit.bean.WallContents;
import com.friendit.services.WallService;

@Controller
public class WallController {
	@Autowired
	WallService wallservice;

	@RequestMapping("/wallpost")
	public String postOnWall(@RequestParam("content") String content, Model model, HttpSession session) {
		UserBean ub = (UserBean) session.getAttribute("MY_SESSION");
		System.out.println(ub);
		System.out.println(content);
		WallContents wallcontent = new WallContents();
		wallcontent.setContent(content);
		wallcontent.setWallid(ub);
		wallservice.addWallPost(ub, wallcontent);
		return "Home";

	}

	@RequestMapping("/likes")
	public String likeWallPost(@RequestParam("sl") Long sl, Model model, HttpSession session) {
		UserBean ub = (UserBean) session.getAttribute("MY_SESSION");
		System.out.println(sl);
		wallservice.likePost(sl);
		List<WallContents> wallContents = wallservice.getWallContents(ub);
		model.addAttribute("wallcontents", wallContents);
		return "Home";

	}

	@RequestMapping("/dislikes")
	public String dislikeWallPost(@RequestParam("sl") Long sl, Model model, HttpSession session) {
		UserBean ub = (UserBean) session.getAttribute("MY_SESSION");
		wallservice.dislikePost(sl);
		List<WallContents> wallContents = wallservice.getWallContents(ub);
		model.addAttribute("wallcontents", wallContents);
		return "Home";

	}

}
