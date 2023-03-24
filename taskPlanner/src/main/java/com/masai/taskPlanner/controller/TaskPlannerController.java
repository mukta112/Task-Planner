package com.masai.taskPlanner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.taskPlanner.entity.Sprint;
import com.masai.taskPlanner.entity.Task;
import com.masai.taskPlanner.entity.User;
import com.masai.taskPlanner.exception.SprintException;
import com.masai.taskPlanner.exception.TaskException;
import com.masai.taskPlanner.exception.UserException;
import com.masai.taskPlanner.service.SprintService;
import com.masai.taskPlanner.service.TaskService;
import com.masai.taskPlanner.service.UserService;

@RestController
@RequestMapping("/taskPlanner")
public class TaskPlannerController {
	
	@Autowired
	private SprintService sprintServ;
	
	@Autowired
	private TaskService taskServ;
	
	@Autowired
	private UserService userServ;
	
	@PostMapping("/createSprint")
	public ResponseEntity<String> createSprintHandler(Sprint sprint) throws SprintException{
		String out=sprintServ.createSprint(sprint);
		return new ResponseEntity<String>(out, HttpStatus.CREATED);
	}
	@PostMapping("/createTask")
	public ResponseEntity<String> createTaskHandler(Task task) throws TaskException{
		String out=taskServ.createTask(task);
		return new ResponseEntity<String>(out, HttpStatus.CREATED);
	}
	@PostMapping("/addUser")
	public ResponseEntity<User> addUserHandler(User user) throws UserException{
		User newUser=userServ.addUser(user);
		return new ResponseEntity<User>(newUser, HttpStatus.CREATED);
	}
	
	
}
