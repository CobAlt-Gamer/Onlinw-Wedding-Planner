package com.wedding.planner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wedding.planner.service.HomeService;

@Controller
public class HomeController {

	@Autowired
	private HomeService homeService;

	@RequestMapping("/home")
	public ModelAndView home(ModelAndView mv) {
		mv.setViewName("home");
		mv.addObject("statistics", homeService.getStatistics().getBody());
		return mv;
	}

	@RequestMapping
	public ModelAndView redirectToLanding() {
		return new ModelAndView("index");
	}
}
