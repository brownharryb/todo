package com.bbh.model;


import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TodoActivity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int todoId;
	private String activity;
	private LocalDateTime datetime;
	
	public TodoActivity() {
		
	}
	
	public TodoActivity(LocalDateTime datetime, String activity) {
		this.datetime = datetime;
		this.activity = activity;
	}

	public int getTodoId() {
		return todoId;
	}

	public void setTodoId(int todoId) {
		this.todoId = todoId;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public LocalDateTime getDatetime() {
		return datetime;
	}

	public void setDatetime(LocalDateTime datetime) {
		this.datetime = datetime;
	}
	
	
	
	
	
	
	
}
