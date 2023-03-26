package com.masai.taskPlanner.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.taskPlanner.entity.Sprint;
import com.masai.taskPlanner.entity.Status;
import com.masai.taskPlanner.entity.Task;
import com.masai.taskPlanner.entity.TaskType;
import com.masai.taskPlanner.entity.User;
import com.masai.taskPlanner.exception.SprintException;
import com.masai.taskPlanner.exception.TaskException;
import com.masai.taskPlanner.exception.UserException;
import com.masai.taskPlanner.service.SprintService;
import com.masai.taskPlanner.service.TaskService;
import com.masai.taskPlanner.service.UserService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

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
	public ResponseEntity<String> createSprintHandler(@RequestBody Sprint sprint) throws SprintException{
		String out=sprintServ.createSprint(sprint);
		return new ResponseEntity<String>(out, HttpStatus.CREATED);
	}
	@PostMapping("/createTask")
	public ResponseEntity<String> createTaskHandler(@RequestBody Task task) throws TaskException{
		String out=taskServ.createTask(task);
		return new ResponseEntity<String>(out, HttpStatus.CREATED);
	}
	@PostMapping("/addUser")
	public ResponseEntity<User> addUserHandler(@RequestBody User user) throws UserException{
		User newUser=userServ.addUser(user);
		return new ResponseEntity<User>(newUser, HttpStatus.CREATED);
	}
	@PostMapping("/addTask/{taskId}")
	public ResponseEntity<Task> addTaskToSprintHandler(@RequestBody Sprint sprint, @PathVariable Long taskId) throws TaskException{
		Task task1=sprintServ.addTaskToSprint(sprint, taskId);
		return new ResponseEntity<Task>(task1, HttpStatus.CREATED);
	}
	@GetMapping("getTasks/{sprintId}")
	public ResponseEntity<List<Task>> getAllTasksInSprintHandler(@PathVariable Long sprintId) throws SprintException{
		List<Task> tasks=sprintServ.getAllTasksInSprint(sprintId);
		return new ResponseEntity<List<Task>>(tasks, HttpStatus.OK);
	}
	@GetMapping("/getSprint/{sprintId}")
	public ResponseEntity<Sprint> getSprintByIdHandler(@PathVariable Long sprintId) throws SprintException{
		Sprint sp=sprintServ.getSprintById(sprintId);
		return new ResponseEntity<Sprint>(sp, HttpStatus.OK);
	}
	@PutMapping("/updateSprint")
	public ResponseEntity<Sprint> updateSprintHandler( Long sprintId, String sprintName, String description, LocalDate startDate,
			LocalDate endDate) throws SprintException{
		Sprint sp=sprintServ.updateSprint(sprintId, sprintName, description, startDate, endDate);
		return new ResponseEntity<Sprint>(sp, HttpStatus.ACCEPTED);
	}
	@DeleteMapping("/deleteSprint/{sprintId}")
	public ResponseEntity<Sprint> deleteSprintByIdHandler(@PathVariable Long sprintId) throws SprintException{
		Sprint sp=sprintServ.deleteSprintById(sprintId);
		return new ResponseEntity<Sprint>(sp, HttpStatus.OK);
	}
	@PutMapping("changeAssignee/{taskId}")
	public ResponseEntity<Task> changeAssigneeHandler(@PathVariable Long taskId,@RequestParam String newAssign) throws TaskException{
		Task t=taskServ.changeAssignee(taskId, newAssign);
		return new ResponseEntity<Task>(t, HttpStatus.ACCEPTED);
	}
	@GetMapping("/getTask/{taskId}")
	public ResponseEntity<Task> getTaskByIdHandler(@PathVariable Long taskId) throws TaskException{
		Task t=taskServ.getTaskById(taskId);
		return new ResponseEntity<Task>(t, HttpStatus.ACCEPTED);
	}
	@PutMapping("/updateTask/{tId}")
	public ResponseEntity<Task> updateTaskHandler(@PathVariable Long tId,@RequestParam String desc,@RequestParam TaskType type,@RequestParam User assignTo,@RequestParam Status status)
			throws TaskException{
		Task t=taskServ.updateTask(tId, desc, type, assignTo, status);
		return new ResponseEntity<Task>(t, HttpStatus.ACCEPTED);
	}
	@DeleteMapping("/deleteTask/{taskId}")
	public ResponseEntity<Task> deleteTaskByIdHandler(@PathVariable Long taskId) throws TaskException{
		Task t=taskServ.deleteTaskById(taskId);
		return new ResponseEntity<Task>(t, HttpStatus.OK);
	}
	@GetMapping("/getUser/{userId}")
	public ResponseEntity<User> getUserByIdHandler(@PathVariable Long userId) throws UserException{
		User user=userServ.getUserById(userId);
		return new ResponseEntity<User>(user, HttpStatus.ACCEPTED);
	}
	@PutMapping("updateUser/{userId")
	public ResponseEntity<User> updateUserHandler(@PathVariable Long userId,@RequestParam String firstName,@RequestParam String lastName,@RequestParam String email,@RequestParam String phone,@RequestParam String password)
			throws UserException{
		User user=userServ.updateUser(userId, firstName, lastName, email, phone, password);
		return new ResponseEntity<User>(user, HttpStatus.ACCEPTED);
	}
}
