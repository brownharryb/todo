package com.bbh.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.bbh.repository.UserRepo;

@RequestMapping("/login")
@Controller
public class LoginController {
	
	@Autowired
	private UserRepo userRepo;
	
	@GetMapping
	public ModelAndView login(Model model, String error, String logout, Principal principal) {
		ModelAndView mv = new ModelAndView();
		if(principal != null) {
			mv.setViewName("redirect:/");
			return mv;
		}
		int count = userRepo.findAll().size();
		mv.addObject("userCount",count);
		if(error != null) {
			mv.addObject("error","Invalid Login Details!");
		}
		mv.setViewName("auth/login.jsp");
		return mv;
	}

}
