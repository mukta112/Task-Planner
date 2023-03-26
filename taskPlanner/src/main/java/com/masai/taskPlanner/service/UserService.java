package com.masai.taskPlanner.service;

import com.masai.taskPlanner.entity.User;
import com.masai.taskPlanner.exception.TaskException;
import com.masai.taskPlanner.exception.UserException;

public interface UserService {

	public User addUser(User user) throws UserException;

	public User getUserById(Long userId) throws UserException;

	public User updateUser(Long userId, String firstName, String lastName, String email, String phone, String password)
			throws UserException;

	public User deleteUser(Long userId) throws UserException;

	public String assignTaskToUser(Long userId, Long taskId) throws UserException, TaskException;
}
