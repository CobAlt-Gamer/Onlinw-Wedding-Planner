package com.wedding.planner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.wedding.planner.enums.UserRole;
import com.wedding.planner.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/users")
	public ModelAndView users(ModelAndView mv, @RequestParam(name = "search", required = false) String search) {
		if (search == null) {
			mv.addObject("userList", userService.getUsers(UserRole.USER).getBody());
		} else {
			mv.addObject("userList", userService.getUsers(UserRole.USER, search).getBody());
		}

		mv.setViewName("users");
		return mv;
	}

	@GetMapping("/user/block/{user}")
	public ModelAndView blockUser(@PathVariable("user") Long user) {
		userService.updateUserStatus(user, false);
		return new ModelAndView("redirect:/users");
	}

	@GetMapping("/user/unblock/{user}")
	public ModelAndView unblockUser(@PathVariable("user") Long user) {
		userService.updateUserStatus(user, true);
		return new ModelAndView("redirect:/users");
	}

}
