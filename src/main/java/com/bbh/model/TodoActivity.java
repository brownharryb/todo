package com.bbh.model;


import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class TodoActivity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int todoId;
	
	@ManyToOne
	private User user;
	private String activity;
	private boolean done;
	private LocalDateTime datetime;
	
	public TodoActivity() {
		
	}
	
	public TodoActivity(LocalDateTime datetime, String activity, User user) {
		this.datetime = datetime;
		this.activity = activity;
		this.user = user;
	}

	public int getTodoId() {
		return todoId;
	}

	public void setTodoId(int todoId) {
		this.todoId = todoId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean isDone) {
		this.done = isDone;
	}

	public LocalDateTime getDatetime() {
		return datetime;
	}

	public void setDatetime(LocalDateTime datetime) {
		this.datetime = datetime;
	}
	
	
	
	
	
	
	
}
