package com.wedding.planner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("terms-of-service")
public class TermsOfServiceController {

	@RequestMapping
	public ModelAndView termsOfService(ModelAndView mv) {
		mv.setViewName("terms-of-service");

		return mv;
	}

}
