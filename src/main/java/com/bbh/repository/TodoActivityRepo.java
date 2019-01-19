package com.bbh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bbh.model.TodoActivity;

public interface TodoActivityRepo extends JpaRepository<TodoActivity, Integer> {

}
