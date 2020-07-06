package com.simple.service;

import java.util.List;

import com.simple.dao.TodoDao;
import com.simple.dto.TodoDto;

public class TodoService {

	private TodoDao todoDao = new TodoDao();
	
	public List<TodoDto> getRecentTodos() throws Exception {
		List<TodoDto> dtos = todoDao.getRecentTodos();
		
		return dtos;
	}
}
