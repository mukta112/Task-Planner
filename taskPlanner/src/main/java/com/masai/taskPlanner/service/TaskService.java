package com.masai.taskPlanner.service;

import com.masai.taskPlanner.entity.Task;
import com.masai.taskPlanner.exception.TaskException;

public interface TaskService {
	
	public String createTask(Task task)throws TaskException;
}
