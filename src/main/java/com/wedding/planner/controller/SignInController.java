package com.wedding.planner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/sign-in")
public class SignInController {

    @RequestMapping
    public ModelAndView signIn() {
        return new ModelAndView("sign-in");
    }

}
