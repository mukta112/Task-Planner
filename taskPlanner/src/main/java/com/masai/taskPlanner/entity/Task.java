package com.masai.taskPlanner.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long taskId;
	private String taskName;
	
	@Enumerated(EnumType.STRING) //BUG, FEATURE, STORY
	private TaskType taskType;
	
	@Enumerated(EnumType.STRING) //NOT_STARTED, WORK_IN_PROGRESS, COMPLETED
	private Status status;
	
	@OneToOne
	private User assignedTo;
	
}
