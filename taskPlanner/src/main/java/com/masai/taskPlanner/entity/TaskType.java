package com.masai.taskPlanner.entity;

public enum TaskType {
	
	BUG("bug"),
	FEATURE("feature"),
	STORY("story");
	
	private final String value;
	
	private TaskType(String value) {
		this.value=value;
	}

	public String getValue() {
		return value;
	}
	
}
