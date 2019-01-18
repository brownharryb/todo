package com.bbh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/login")
@Controller
public class LoginController {
	
	@GetMapping
	public ModelAndView login(Model model, String error, String logout) {
		ModelAndView mv = new ModelAndView();
		if(error != null) {
			mv.addObject("error","Invalid Login Details!");
		}
		mv.setViewName("auth/login.jsp");
		return mv;
	}

}
