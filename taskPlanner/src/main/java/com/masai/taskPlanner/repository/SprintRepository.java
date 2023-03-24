package com.masai.taskPlanner.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.taskPlanner.entity.Sprint;

public interface SprintRepository extends JpaRepository<Sprint, Long>{

}
