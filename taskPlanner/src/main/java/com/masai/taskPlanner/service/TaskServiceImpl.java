package com.masai.taskPlanner.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.taskPlanner.entity.Task;
import com.masai.taskPlanner.exception.TaskException;
import com.masai.taskPlanner.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskRepository taskRepo;
	
	@Override
	public String createTask(Task task) throws TaskException {
		
		taskRepo.save(task);
		return "task created successfully";
	}

}
