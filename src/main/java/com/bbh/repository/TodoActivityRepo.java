package com.bbh.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bbh.model.TodoActivity;
import com.bbh.model.User;

public interface TodoActivityRepo extends JpaRepository<TodoActivity, Integer>{
	
	public List<TodoActivity> findByUser(User user);

}
