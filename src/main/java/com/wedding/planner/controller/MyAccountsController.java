package com.wedding.planner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.wedding.planner.entity.Users;
import com.wedding.planner.entity.Vendor;
import com.wedding.planner.enums.UserRole;
import com.wedding.planner.service.UserService;
import com.wedding.planner.service.VendorService;
import com.wedding.planner.utils.UtilityService;

@Controller
@RequestMapping("/my-account")
public class MyAccountsController {

	@Autowired
	private UserService userService;

	@Autowired
	private VendorService vendorService;

	@Autowired
	private UtilityService utility;

	@RequestMapping
	public ModelAndView myAccount(ModelAndView mv) {
		Users user = userService.getUser(utility.getCurrentUsername()).getBody();

		if (user.getRole().equals(UserRole.VENDOR)) {
			Vendor vendor = vendorService.getVendor(user).getBody();
			mv.addObject("vendor", vendor);
		}

		mv.addObject("user", user);
		mv.setViewName("my-account");
		return mv;
	}

	@PostMapping("/user/avatar")
	public ResponseEntity<String> updateAvatar(@RequestParam("user-avatar") MultipartFile image) {
		return userService.updateAvatar(utility.getCurrentUsername(), image);
	}

	@PutMapping("/user/update")
	public ResponseEntity<Users> updateUser(@RequestParam("first_name") String firstName,
			@RequestParam("last_name") String lastName, @RequestParam("email") String email,
			@RequestParam(name = "password", required = false) String password, @RequestParam("user_id") Long userId) {
		Users user = Users.builder().userId(userId).firstName(firstName).lastName(lastName).email(email)
				.password(password != null ? password : null).build();
		return userService.updateUser(user);
	}

	@PutMapping("/vendor/update")
	public ResponseEntity<Vendor> updatevendor(@RequestParam("first_name") String firstName,
			@RequestParam("last_name") String lastName, @RequestParam("email") String email,
			@RequestParam(name = "password", required = false) String password, @RequestParam("user_id") Long userId,
			@RequestParam("gst_number") String gstNumber, @RequestParam("address_line_1") String addressLine1,
			@RequestParam("address_line_2") String addressLine2, @RequestParam("address_id") Long addressId,
			@RequestParam(name = "accepting_orders", required = false, defaultValue = "false") Boolean acceptingOrders,
			@RequestParam("vendor_id") Integer vendorId) {
		Users dbUser = userService.getUser(userId).getBody();
		if (!dbUser.getAddress().isEmpty()) {
			dbUser.getAddress().get(0).setAddressLine1(addressLine1);
			dbUser.getAddress().get(0).setAddressLine2(addressLine2);
		}
		dbUser.setFirstName(firstName);
		dbUser.setLastName(lastName);
		dbUser.setEmail(email);
		if (password != null) {
			dbUser.setPassword(password);
		}
		Vendor vendor = Vendor.builder().user(dbUser).gstNumber(gstNumber).acceptOrders(acceptingOrders)
				.vendorId(vendorId).build();
		return vendorService.updatevendor(vendor);
	}
}
