package com.masai.taskPlanner.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.taskPlanner.entity.Sprint;
import com.masai.taskPlanner.exception.SprintException;
import com.masai.taskPlanner.repository.SprintRepository;

@Service
public class SprintServiceImpl implements SprintService {
	
	@Autowired
	private SprintRepository sprintRepo;

	@Override
	public String createSprint(Sprint sprint) throws SprintException {
		LocalDate start=LocalDate.now();
		sprint.setStartDate(start);
		LocalDate end=start.plusDays(14);
		sprint.setEndDate(end);
		sprintRepo.save(sprint);
		return "sprint created successfully";
	}

}
