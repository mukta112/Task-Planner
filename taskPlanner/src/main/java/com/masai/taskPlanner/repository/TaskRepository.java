package com.masai.taskPlanner.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.taskPlanner.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{

}
