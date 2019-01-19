package com.bbh.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bbh.model.User;
import com.bbh.repository.UserRepo;
import com.bbh.service.TodoUserDetailsService;

@RequestMapping("/register")
@Controller
public class RegisterController {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private TodoUserDetailsService userService;

	@GetMapping
	@ResponseBody
	public Map<String, String> register(@RequestParam("username") String username,
								@RequestParam("password") String password) {
		HashMap<String, String> map = new HashMap();
//		Check username already exists
		User user = userRepo.findByUsername(username);
		int count = userRepo.findAll().size();
		if(user == null && count < 5 && username != null && username != ""
			&& password != null && password != "") {
			userService.addUser(username, password, new String[] {"USER"});
			map.put("error", "");
		}else {
			if(user != null) {
				map.put("error", "User already exists!");
			}else if(count >= 5) {
				map.put("error", "User limit reached!");
			}else if(username == null || username == "" || password == null || password == "") {
				map.put("error", "Username or Password should not be empty!!");
			}
		}
		return map;
	}

}
