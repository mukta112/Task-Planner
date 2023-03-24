package com.masai.taskPlanner.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.taskPlanner.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
