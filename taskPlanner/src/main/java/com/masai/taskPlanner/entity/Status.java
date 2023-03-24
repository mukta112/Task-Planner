package com.masai.taskPlanner.entity;

public enum Status {
	
	NOT_STARTED("not_started"),
	WORK_IN_PROGRESS("work_in_progress"),
	COMPLETED("completed");
	
	private final String value;

	private Status(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
