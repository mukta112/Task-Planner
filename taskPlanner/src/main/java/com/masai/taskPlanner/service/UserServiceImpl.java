package com.masai.taskPlanner.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.taskPlanner.entity.User;
import com.masai.taskPlanner.exception.UserException;
import com.masai.taskPlanner.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public User addUser(User user) throws UserException {
		
		User newUser=userRepo.save(user);
		return newUser;
	}

}
