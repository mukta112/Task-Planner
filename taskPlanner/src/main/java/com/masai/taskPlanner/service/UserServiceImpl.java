package com.masai.taskPlanner.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.taskPlanner.entity.Task;
import com.masai.taskPlanner.entity.User;
import com.masai.taskPlanner.exception.TaskException;
import com.masai.taskPlanner.exception.UserException;
import com.masai.taskPlanner.repository.TaskRepository;
import com.masai.taskPlanner.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private TaskRepository taskRepo;

	@Override
	public User addUser(User user) throws UserException {

		User newUser = userRepo.save(user);
		return newUser;
	}

	@Override
	public User getUserById(Long userId) throws UserException {
		User user = userRepo.findById(userId)
				.orElseThrow(() -> new UserException("User not found with this Id :-" + userId));
		return user;
	}

	@Override
	public User updateUser(Long userId, String firstName, String lastName, String email, String phone, String password)
			throws UserException {
		User user = userRepo.findById(userId)
	            .orElseThrow(() -> new UserException("User not found with given Id :-" + userId));
	
	 		Optional<User> newUser = userRepo.findById(userId);

	 		User newUser1 = newUser.get();

	 		if (firstName != null) {
	 			newUser1.setFirstName(firstName);;
	 		}
	 		if (lastName != null) {
	 			newUser1.setLastName(lastName);;
	 		}
	 		if (email != null) {
	 			newUser1.setEmail(email);
	 		}
	 		if (password != null) {
	 			newUser1.setPassword(password);
	 		}

	 		User updated = userRepo.save(newUser1);

	 		return updated;
	}

	@Override
	public User deleteUser(Long userId) throws UserException {
		User user = userRepo.findById(userId)
	            .orElseThrow(() -> new UserException("User not found with given Id :-" + userId));
		
		userRepo.delete(user);
		return user;
	}

	@Override
	public String assignTaskToUser(Long userId, Long taskId) throws UserException, TaskException {
		User fUser = userRepo.findById(userId).orElseThrow(() -> new UserException("User not found with given Id :" + userId));
		Task fTask = taskRepo.findById(taskId).orElseThrow(() -> new TaskException("Task not added with given Id :" + taskId));
		
		if(fTask.getAssignedTo() != null) {
			throw new UserException("task already assign to user with given Id :" + userId);
		} else {
			fTask.setAssignedTo(fUser);
			fUser.getTasks().add(fTask);
			taskRepo.save(fTask);
			userRepo.save(fUser);
			return "Task " + taskId + ":- Assigned to user with userId " + userId;	
		}
	}

}
