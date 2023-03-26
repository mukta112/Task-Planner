package com.masai.taskPlanner.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.taskPlanner.entity.Status;
import com.masai.taskPlanner.entity.Task;
import com.masai.taskPlanner.entity.TaskType;
import com.masai.taskPlanner.entity.User;
import com.masai.taskPlanner.exception.TaskException;
import com.masai.taskPlanner.exception.UserException;
import com.masai.taskPlanner.repository.TaskRepository;
import com.masai.taskPlanner.repository.UserRepository;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskRepository taskRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public String createTask(Task task) throws TaskException {
		
		taskRepo.save(task);
		return "task created successfully";
	}

	@Override
	public Task changeAssignee(Long taskId, String newAssign) throws TaskException {
		Task task = taskRepo.findById(taskId)
	            .orElseThrow(() -> new TaskException("Task not added with given Id :-" + taskId));
		return task;
	}

	@Override
	public List<Task> getAllTasksAssignToUser(Long userId) throws UserException {
		User user = userRepo.findById(userId).orElseThrow(() -> new UserException("User not found with given id :"+userId));
		return user.getTasks();
	}
	@Override
	public Task getTaskById(Long taskId) throws TaskException {
		Task task = taskRepo.findById(taskId)
	            .orElseThrow(() -> new TaskException("Task not added with given Id :-" + taskId));
		return task;
	}

	@Override
	public Task updateTask(Long userId, String taskName, TaskType type, User assignTo, Status status) throws TaskException {

		Task task = taskRepo.findById(userId)
				.orElseThrow(() -> new TaskException("Task not added with given Id :-" + userId));


		Optional<Task> newtask = taskRepo.findById(userId);

		Task newTask1 = newtask.get();

		if (taskName != null) {
			newTask1.setTaskName(taskName);
		}
		if (type != null) {
			newTask1.setTaskType(type);;
		}
		if (assignTo != null) {
			newTask1.setAssignedTo(assignTo);;
		}
		if (status != null) {
			newTask1.setStatus(status);
		}

		Task updated = taskRepo.save(newTask1);

		return updated;
	}


	@Override
	public Task deleteTaskById(Long taskId) throws TaskException {
		Task task = taskRepo.findById(taskId)
	            .orElseThrow(() -> new TaskException("Task not added with given Id :-" + taskId));
		taskRepo.delete(task);
		return task;
	}

}
