package com.masai.taskPlanner.service;

import java.util.List;

import com.masai.taskPlanner.entity.Status;
import com.masai.taskPlanner.entity.Task;
import com.masai.taskPlanner.entity.TaskType;
import com.masai.taskPlanner.entity.User;
import com.masai.taskPlanner.exception.TaskException;
import com.masai.taskPlanner.exception.UserException;

public interface TaskService {

	public String createTask(Task task) throws TaskException;

	public Task changeAssignee(Long taskId, String newAssign) throws TaskException;

	public List<Task> getAllTasksAssignToUser(Long userId) throws UserException;

	public Task getTaskById(Long taskId) throws TaskException;

	public Task updateTask(Long tId, String desc, TaskType type, User assignTo, Status status)
			throws TaskException;

	public Task deleteTaskById(Long taskId) throws TaskException;
}
