package com.example.demo;

import java.util.List;

public interface MeetingService {

	public List<Meeting> getAllData();
	 
	 public Meeting findEmployeeById(int id);
	 
	 public void addEmployee(Meeting meeting);
	 
	 public void updateEmployee(Meeting meeting);
}
