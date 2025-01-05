package com.wedding.planner.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.wedding.planner.entity.Address;
import com.wedding.planner.entity.Cities;
import com.wedding.planner.entity.Users;
import com.wedding.planner.entity.Vendor;
import com.wedding.planner.service.StatesService;
import com.wedding.planner.service.VendorService;

@Controller
public class VendorsController {

	@Autowired
	private StatesService statesService;

	@Autowired
	private VendorService vendorService;

	@RequestMapping("/vendors")
	public ModelAndView vendors(ModelAndView mv,@RequestParam(name="search",required = false) String search) {
		mv.setViewName("vendors");
		if(search!=null) {
			mv.addObject("vendorList", vendorService.getVendors(search).getBody());
		}else {
			mv.addObject("vendorList", vendorService.getVendors().getBody());
		}
		return mv;
	}

	@GetMapping("/vendor")
	public ModelAndView vendors(ModelAndView mv, @RequestParam("vendor") Vendor vendor) {
		mv.setViewName("vendor-view");
		mv.addObject("vendor", vendor);
		mv.addObject("states", statesService.getStates().getBody());

		return mv;
	}

	@PostMapping("/update-vendor")
	public ModelAndView updateVendor(
			@RequestParam(name = "loginStatus", required = false, defaultValue = "false") Boolean isLoggedIn,
			@RequestParam(name = "status", required = false, defaultValue = "false") Boolean status,
			@RequestParam("first_name") String firstName, @RequestParam("last_name") String lastName,
			@RequestParam("email") String email, @RequestParam("phone") String phone,
			@RequestParam(name = "password", required = false) String password,
			@RequestParam("business_name") String businessName,
			@RequestParam("business_contact") String businessContact, @RequestParam("city") Cities city,
			@RequestParam("address_line_1") String addressLine1, @RequestParam("address_line_2") String addressLine2,
			@RequestParam("vendor_id") Integer vendorId, @RequestParam("user_id") Long userId,
			@RequestParam("gst_number") String gstNumber) {

		Address address = Address.builder().addressLine1(addressLine1).addressLine2(addressLine2).city(city).build();

		Users user = Users.builder().userId(userId).firstName(firstName).lastName(lastName).email(email)
				.password(password != null ? password : null).phone(phone).address(List.of(address))
				.loggedIn(isLoggedIn).status(status).build();
		Vendor vendor = Vendor.builder().businessName(businessName).businessContact(businessContact).user(user)
				.gstNumber(gstNumber).vendorId(vendorId).build();
		vendorService.updatevendor(vendor);
		ModelAndView mv = new ModelAndView("redirect:/vendors");
		return mv;
	}

	@GetMapping("/vendor/approve/{vendor}")
	public ModelAndView approveVendor(@PathVariable("vendor") Integer vendorId) {
		Vendor vendor = Vendor.builder().vendorId(vendorId).approved(true).build();
		vendorService.updatevendor(vendor);
		return new ModelAndView("redirect:/vendors");
	}
}