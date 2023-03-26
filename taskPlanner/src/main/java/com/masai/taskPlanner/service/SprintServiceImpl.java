package com.masai.taskPlanner.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.taskPlanner.entity.Sprint;
import com.masai.taskPlanner.entity.Task;
import com.masai.taskPlanner.exception.SprintException;
import com.masai.taskPlanner.exception.TaskException;
import com.masai.taskPlanner.repository.SprintRepository;
import com.masai.taskPlanner.repository.TaskRepository;

@Service
public class SprintServiceImpl implements SprintService {
	
	@Autowired
	private SprintRepository sprintRepo;
	
	@Autowired
	private TaskRepository taskRepo;

	@Override
	public String createSprint(Sprint sprint) throws SprintException {
		LocalDate start=LocalDate.now();
		sprint.setStartDate(start);
		LocalDate end=start.plusDays(14);
		sprint.setEndDate(end);
		sprintRepo.save(sprint);
		return "sprint created successfully";
	}

	@Override
	public Task addTaskToSprint(Sprint sprint, Long taskId) throws TaskException {
		Optional<Task> opt = taskRepo.findById(taskId);
		if(opt.isEmpty()) throw new TaskException("Task id not found");
		Task task1=opt.get();
		sprint.getTasks().add(task1);
		return task1;
	}

	@Override
	public List<Task> getAllTasksInSprint(Long sprintId) throws SprintException {
		return sprintRepo.findById(sprintId).get().getTasks();
	}

	@Override
	public Sprint getSprintById(Long sprintId) throws SprintException {
		Sprint sprint = sprintRepo.findById(sprintId)
	            .orElseThrow(() -> new SprintException("Sprint not found with given Id :-" + sprintId));
		return sprint;
		
	}

	@Override
	public Sprint updateSprint(Long sprintId, String sprintName, String description, LocalDate startDate,
			LocalDate endDate) throws SprintException {
		Sprint sprint = sprintRepo.findById(sprintId)
	            .orElseThrow(() -> new SprintException("Sprint not found with given Id :-" + sprintId));
	 		
	 		
	 		Optional<Sprint> newSprint = sprintRepo.findById(sprintId);

	 		Sprint newSprint1 = newSprint.get();

	 		if (startDate != null) {
	 			newSprint1.setStartDate(startDate);
	 		}
	 		if (endDate != null) {
	 			newSprint1.setEndDate(endDate);
	 		}

	 		Sprint updated = sprintRepo.save(newSprint1);

	 		return updated;
	}

	@Override
	public Sprint deleteSprintById(Long sprintId) throws SprintException {
		Sprint sprint = sprintRepo.findById(sprintId)
	            .orElseThrow(() -> new SprintException("Sprint not found with given Id :-" + sprintId));
		
		sprintRepo.delete(sprint);
		return sprint;
	}

}
