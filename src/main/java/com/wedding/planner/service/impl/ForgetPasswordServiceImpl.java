package com.wedding.planner.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.wedding.planner.config.auth.jwt.JwtHelper;
import com.wedding.planner.config.general.Configurations;
import com.wedding.planner.service.EmailService;
import com.wedding.planner.service.ForgetPasswordService;
import com.wedding.planner.service.UserService;

@Service
public class ForgetPasswordServiceImpl implements ForgetPasswordService {

	private String mailTemplate = """
						<!doctype html>
			<html lang="en-US">
			<head>
			    <meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
			    <title>Wedding Planner | Password Reset Mail</title>
			    <meta name="description" content="Reset Password Email Template.">
			    <style type="text/css">
			        a:hover {text-decoration: underline !important;}
			    </style>
			</head>
			<body marginheight="0" topmargin="0" marginwidth="0" style="margin: 0px; background-color: #f2f3f8;" leftmargin="0">
			    <table cellspacing="0" border="0" cellpadding="0" width="100%" bgcolor="#f2f3f8"
			        style="@import url(https://fonts.googleapis.com/css?family=Rubik:300,400,500,700|Open+Sans:300,400,600,700); font-family: 'Open Sans', sans-serif;">
			        <tr>
			            <td>
			                <table style="background-color: #f2f3f8; max-width:670px;  margin:0 auto;" width="100%" border="0"
			                    align="center" cellpadding="0" cellspacing="0">
			                    <tr>
			                        <td style="height:80px;">&nbsp;</td>
			                    </tr>
			                    <tr>
			                        <td style="text-align:center;">
			                          <a href="${siteURL}" title="logo" target="_blank">
			                            <img width="100" src="${logo}" title="logo" alt="logo">
			                          </a>
			                        </td>
			                    </tr>
			                    <tr>
			                        <td style="height:20px;">&nbsp;</td>
			                    </tr>
			                    <tr>
			                        <td>
			                            <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0"
			                                style="max-width:670px;background:#fff; border-radius:3px; text-align:center;-webkit-box-shadow:0 6px 18px 0 rgba(0,0,0,.06);-moz-box-shadow:0 6px 18px 0 rgba(0,0,0,.06);box-shadow:0 6px 18px 0 rgba(0,0,0,.06);">
			                                <tr>
			                                    <td style="height:40px;">&nbsp;</td>
			                                </tr>
			                                <tr>
			                                    <td style="padding:0 35px;">
			                                        <h1 style="color:#1e1e2d; font-weight:500; margin:0;font-size:32px;font-family:'Rubik',sans-serif;">You have
			                                            requested to reset your password</h1>
			                                        <span
			                                            style="display:inline-block; vertical-align:middle; margin:29px 0 26px; border-bottom:1px solid #cecece; width:100px;"></span>
			                                        <p style="color:#455056; font-size:15px;line-height:24px; margin:0;">
			                                            We cannot simply send you your old password. A unique link to reset your
			                                            password has been generated for you. To reset your password, click the
			                                            following link and follow the instructions.
			                                        </p>
			                                        <a href="${resetLink}"
			                                            style="background:#884343;text-decoration:none !important; font-weight:500; margin-top:35px; color:#fff;text-transform:uppercase; font-size:14px;padding:10px 24px;display:inline-block;border-radius:50px;">Reset
			                                            Password</a>
			                                    </td>
			                                </tr>
			                                <tr>
			                                    <td style="height:40px;">&nbsp;</td>
			                                </tr>
			                            </table>
			                        </td>
			                    <tr>
			                        <td style="height:20px;">&nbsp;</td>
			                    </tr>
			                    <tr>
			                        <td style="text-align:center;">
			                            <p style="font-size:14px; color:rgba(69, 80, 86, 0.7411764705882353); line-height:18px; margin:0 0 0;"><strong>Wedding Planner</strong></p>
			                        </td>
			                    </tr>
			                    <tr>
			                        <td style="height:80px;">&nbsp;</td>
			                    </tr>
			                </table>
			            </td>
			        </tr>
			    </table>
			</body>
			</html>
						""";

	@Autowired
	private UserService userService;

	@Autowired
	private EmailService emailService;

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private JwtHelper jwtHelper;

	@Override
	public ResponseEntity<String> sendPasswordResetMail(String email) {

		if (userService.getUser(email).getBody() == null) {
			return ResponseEntity.notFound().build();
		}

		UserDetails user = userDetailsService.loadUserByUsername(email);

		String token = jwtHelper.generateToken(user);

		mailTemplate = mailTemplate.replace("${siteURL}", Configurations.SITE_URL);
		mailTemplate = mailTemplate.replace("${logo}", Configurations.LOGO_COMPACT);
		mailTemplate = mailTemplate.replace("${resetLink}",
				Configurations.SITE_URL + "/forgetPassword/reset-password?token=" + token);

		try {
			emailService.sendEmail(email, "Password Reset - Wedding Planner", mailTemplate);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(e.getLocalizedMessage());
		}

		return ResponseEntity.ok("Password Reset Mail sent successfully");
	}

	@Override
	public ResponseEntity<Boolean> validateResetPasswordToken(String token) {
		try {
			jwtHelper.getUsernameFromToken(token);
			return ResponseEntity.ok(true);
		} catch (Exception e) {
			return ResponseEntity.ok(false);
		}
	}

	@Override
	public ResponseEntity<Boolean> resetPassword(String token, String password) {
		try {
			return userService.updatePassword(jwtHelper.getUsernameFromToken(token), password);
		} catch (Exception e) {
			return ResponseEntity.ok(false);
		}
	}
}
