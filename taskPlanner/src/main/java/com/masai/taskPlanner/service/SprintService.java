package com.masai.taskPlanner.service;

import java.time.LocalDate;
import java.util.List;

import com.masai.taskPlanner.entity.Sprint;
import com.masai.taskPlanner.entity.Task;
import com.masai.taskPlanner.exception.SprintException;
import com.masai.taskPlanner.exception.TaskException;

public interface SprintService {

	public String createSprint(Sprint sprint) throws SprintException;

	public Task addTaskToSprint(Sprint sprint, Long taskId) throws TaskException;

	public List<Task> getAllTasksInSprint(Long sprintId) throws SprintException;

	public Sprint getSprintById(Long sprintId) throws SprintException;

	public Sprint updateSprint(Long sprintId, String sprintName, String description, LocalDate startDate,
			LocalDate endDate) throws SprintException;

	public Sprint deleteSprintById(Long sprintId) throws SprintException;
}
