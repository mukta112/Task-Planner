package com.masai.taskPlanner.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Sprint {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long sprintId;
	private LocalDate startDate;
	private LocalDate endDate;
	@OneToMany
	private List<Task> tasks=new ArrayList<>();
}
