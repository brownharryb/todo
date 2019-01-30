package com.bbh.controller;


import java.security.Principal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.bbh.model.TodoActivity;
import com.bbh.model.User;
import com.bbh.repository.TodoActivityRepo;
import com.bbh.repository.UserRepo;

@RequestMapping("/")
@RestController
public class TodoController {
	
	@Autowired
	private TodoActivityRepo todoRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	@GetMapping
	public ModelAndView todoHome(HttpServletRequest req, Principal principal) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("todos.jsp");
		User loggedInUser = getLoggedInUser(principal);
		mv.addObject("activities", todoRepo.findByUser(loggedInUser));
		return mv;
	}
	
	@PostMapping
	public ModelAndView todoHome(@RequestParam("date") String todoDate,
									@RequestParam("time") String todoTime,
									@RequestParam("activity") String activity,
									Principal principal) {
		ModelAndView mv = new ModelAndView();
		try {
			if(activity == null || activity.equals("")) {
				throw new Exception("Activity should not be empty!");
			}
			LocalDateTime datetime = getDateTime(todoDate, todoTime);
			todoRepo.save(new TodoActivity(datetime,activity,getLoggedInUser(principal)));
		}catch(DateTimeParseException e) {
			mv.addObject("error", "Error on submission, please check your values!");
			e.printStackTrace();
		}catch(Exception e) {
			mv.addObject("error", e.getMessage());
			e.printStackTrace();
		}
		
		mv.addObject("activities", todoRepo.findByUser(getLoggedInUser(principal)));
		mv.setViewName("todos.jsp");
		
		return mv;
	}
	
	@RequestMapping("/deletetodo")
	public ModelAndView todoHome(@RequestParam("activity_id") String activityId, Principal principal) {
		ModelAndView mv = new ModelAndView();
		todoRepo.deleteById (Integer.parseInt(activityId));
		mv.addObject("activities", todoRepo.findByUser(getLoggedInUser(principal)));
		mv.setViewName("todos.jsp");		
		return mv;
	}
	
	@RequestMapping("/marktododone")
	public Optional<TodoActivity> markDone(@RequestParam("activity_id") String activityId,
									@RequestParam("done") boolean done) {
		Optional<TodoActivity> todoActivity = todoRepo.findById(Integer.parseInt(activityId));
		if(todoActivity.isPresent()) {
			try {
				TodoActivity activity = todoActivity.get();
				activity.setDone(done);
				todoRepo.save(activity);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return todoActivity;
	}
	

	
	public LocalDateTime getDateTime(String date, String time) throws DateTimeParseException,Exception {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime dateTime = LocalDateTime.parse(date+" "+time, formatter);
		if(LocalDateTime.now().compareTo(dateTime) > 0) {
			throw new Exception("Previous date not allowed!");
		}
		return dateTime;
	}
	
	public User getLoggedInUser(Principal principal) {
		return userRepo.findByUsername(principal.getName());
	}
	
}
