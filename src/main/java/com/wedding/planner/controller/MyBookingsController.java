package com.wedding.planner.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wedding.planner.service.BookingService;

@Controller
@RequestMapping("/my-bookings")
public class MyBookingsController {

	@Autowired
	private BookingService bookingService;

	@RequestMapping
	public ModelAndView myBookings(ModelAndView mv) {
		mv.setViewName("my-bookings");
		mv.addObject("bookingsList", bookingService.getBookings(Optional.empty()).getBody());
		return mv;
	}
}
