package com.wedding.planner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.wedding.planner.service.ForgetPasswordService;

@Controller
@RequestMapping("/forgetPassword")
public class ForgetPasswordController {

	@Autowired
	private ForgetPasswordService forgotPasswordService;

	@RequestMapping
	public ModelAndView forgetPassword(ModelAndView mv) {
		mv.setViewName("forgot-password");
		return mv;

	}

	@PostMapping("/reset-email")
	public ResponseEntity<String> sendPasswordResetMail(@RequestParam("email") String email) {
		return forgotPasswordService.sendPasswordResetMail(email);
	}

	@GetMapping("/reset-password")
	public String resetPassword(@RequestParam("token") String token, RedirectAttributes redirectAttributes) {
		ModelAndView mv = new ModelAndView("forgot-password");
		if (forgotPasswordService.validateResetPasswordToken(token).getBody()) {
			mv.addObject("token", token);
			mv.addObject("status", HttpStatus.OK);
		} else {
			mv.addObject("status", HttpStatus.UNAUTHORIZED);
		}

		redirectAttributes.addFlashAttribute("modelAndView", mv);

		return "redirect:/forgetPassword";
	}

	@PostMapping("/set-new-password")
	public ResponseEntity<String> setNewPassword(@RequestParam("password") String password,
			@RequestParam("con-password") String conPassword, @RequestParam("token") String token) {
		if (password.trim().equals(conPassword.trim())
				&& forgotPasswordService.validateResetPasswordToken(token).getBody()
				&& forgotPasswordService.resetPassword(token,password).getBody()) {
			return ResponseEntity.ok("Password Reset Successfully");
		}

		return ResponseEntity.badRequest().body("Password and confirm password do not match. Please try again.");
	}
}
