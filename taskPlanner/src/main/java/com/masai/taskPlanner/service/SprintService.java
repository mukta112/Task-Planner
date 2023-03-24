package com.masai.taskPlanner.service;

import com.masai.taskPlanner.entity.Sprint;
import com.masai.taskPlanner.entity.Task;
import com.masai.taskPlanner.exception.SprintException;
import com.masai.taskPlanner.exception.TaskException;

public interface SprintService {
	
	public String createSprint(Sprint sprint)throws SprintException;
//	public Task addTaskToSprint(Sprint sprint, Long taskId)throws TaskException;

}
