package com.wedding.planner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.wedding.planner.entity.Cities;
import com.wedding.planner.service.SignUpService;
import com.wedding.planner.service.StatesService;

@Controller
@RequestMapping("/sign-up")
public class SignUpController {

	@Autowired
	private StatesService statesService;

	@Autowired
	private SignUpService signUpService;

	@RequestMapping
	public ModelAndView signUp(ModelAndView mv) {
		mv.addObject("states", statesService.getStates().getBody());
		mv.setViewName("sign-up");
		return mv;
	}

	@PostMapping
	public ModelAndView signup(ModelAndView mv, @RequestParam("first_name") String firstName,
			@RequestParam("last_name") String lastName, @RequestParam("email") String email,
			@RequestParam("phone") String phone, @RequestParam("password") String password,
			@RequestParam("business_name") String business_nme,
			@RequestParam("business_contact") String business_contact, @RequestParam("gst_number") String gstNumber,
			@RequestParam("city") Cities city, @RequestParam("address_line_1") String addressLine1,
			@RequestParam(name="address_line_2",required = false,defaultValue = " ") String addressLine2) {

		signUpService.registerVendor(firstName, lastName, email, phone, password, business_nme, business_contact,
				gstNumber, city, addressLine1, addressLine2);

		mv.setViewName("sign-in");
		return mv;
	}
}