package com.example.demo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MeetingRowMapper implements RowMapper<Meeting> {

	@Override
	public Meeting mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Meeting meeting = new Meeting();
		
		meeting.setEmployeeId(rs.getInt("employee_Id"));
		meeting.setName(rs.getString("name"));
		meeting.setEmail(rs.getString("email_id"));
		meeting.setDuration(rs.getInt("duration"));
		meeting.setModeOfTraining(rs.getString("training_mode"));
		meeting.setStartDate(rs.getString("start_date"));
		meeting.setEndDate(rs.getString("end_date"));
		meeting.setDomain(rs.getString("domain"));
		meeting.setVenue(rs.getString("venue"));
		meeting.setStatus(rs.getString("status"));
		
		return meeting;
	}

}
