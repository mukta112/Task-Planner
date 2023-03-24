package com.masai.taskPlanner.service;

import com.masai.taskPlanner.entity.User;
import com.masai.taskPlanner.exception.UserException;

public interface UserService {
	
	public User addUser(User user)throws UserException;
}
