package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MeetingServiceImpl implements MeetingService {

	@Autowired
	private MeetingDaoImpl meetingDao;
	 
	@Override
	public List<Meeting> getAllData() {
		return meetingDao.getAllData();
	}

	@Override
	public Meeting findEmployeeById(int id) {
		return meetingDao.findEmployeeById(id);
	}

	@Override
	public void addEmployee(Meeting meeting) {
		meetingDao.addEmployee(meeting);
	}

	@Override
	public void updateEmployee(Meeting meeting) {
		meetingDao.updateEmployee(meeting);
	}

}
