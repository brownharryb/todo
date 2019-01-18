package com.bbh.controller;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bbh.model.TodoActivity;
import com.bbh.repository.TodoActivityRepo;

@RequestMapping("/")
@Controller
public class TodoController {
	
	@Autowired
	private TodoActivityRepo todoRepo;
	
	@GetMapping
	public ModelAndView todoHome() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("todos.jsp");
		mv.addObject("activities", todoRepo.findAll());
		return mv;
	}
	
	@PostMapping
	public ModelAndView todoHome(@RequestParam("date") String todoDate,
									@RequestParam("time") String todoTime,
									@RequestParam("activity") String activity) {
		ModelAndView mv = new ModelAndView();
		try {
			if(activity == null || activity.equals("")) {
				throw new Exception("Activity should not be empty!");
			}
			LocalDateTime datetime = getDateTime(todoDate, todoTime);
			todoRepo.save(new TodoActivity(datetime,activity));
		}catch(DateTimeParseException e) {
			mv.addObject("error", "Error on submission, please check your values!");
			e.printStackTrace();
		}catch(Exception e) {
			mv.addObject("error", e.getMessage());
			e.printStackTrace();
		}
		
		mv.addObject("activities", todoRepo.findAll());
		mv.setViewName("todos.jsp");
		
		return mv;
	}
	
	@RequestMapping("/deletetodo/:todoId")
	public ModelAndView todoHome(@RequestParam("activity_id") String activityId) {
		ModelAndView mv = new ModelAndView();
		todoRepo.deleteById(Long.parseLong(activityId));
		mv.addObject("activities", todoRepo.findAll());
		mv.setViewName("todos.jsp");		
		return mv;
	}
	

	
	public LocalDateTime getDateTime(String date, String time) throws DateTimeParseException,Exception {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime dateTime = LocalDateTime.parse(date+" "+time, formatter);
		if(LocalDateTime.now().compareTo(dateTime) > 0) {
			throw new Exception("Previous date not allowed!");
		}
		return dateTime;
	}
	
}
