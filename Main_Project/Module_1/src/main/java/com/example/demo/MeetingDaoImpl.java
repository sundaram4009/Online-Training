package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class MeetingDaoImpl implements MeetingDao {

	 @Autowired
	 private JdbcTemplate jdbcTemplate;
	 
	@Override
	public List<Meeting> getAllData() {
		String query = "SELECT * from module";
		  RowMapper<Meeting> rowMapper = new MeetingRowMapper();
		  List<Meeting> list = jdbcTemplate.query(query, rowMapper);
		  
		  return list;
	}

	@Override
	public Meeting findEmployeeById(int id) {
		String query = "SELECT * FROM module WHERE employee_id = ?";
		  RowMapper<Meeting> rowMapper = new BeanPropertyRowMapper<Meeting>(Meeting.class);
		  Meeting meeting = jdbcTemplate.queryForObject(query, rowMapper, id);
		  
		  return meeting;
	}

	@Override
	public void addEmployee(Meeting meeting) {
		String query = "INSERT INTO module(name,email_id,duration,training_mode,start_date,end_date,domain,venue,status) VALUES(?,?,?,?,?,?,?,?,?)";
		jdbcTemplate.update(query,meeting.getName(),meeting.getEmail(),meeting.getDuration(),meeting.getModeOfTraining(),meeting.getStartDate(),meeting.getEndDate(),meeting.getDomain(),meeting.getVenue(),meeting.getStatus());
		
	}

	@Override
	public void updateEmployee(Meeting meeting) {
		 String query = "UPDATE module SET name=?, email_id=?, duration=?, training_mode=?, start_date=?,end_date=?, domain=?, venue=?, status=? WHERE employee_Id=?";
		  jdbcTemplate.update(query, meeting.getName(), meeting.getEmail(),meeting.getDuration(),meeting.getModeOfTraining(), meeting.getStartDate(),meeting.getEndDate(),meeting.getDomain(),
				 meeting.getVenue(),meeting.getStatus(),meeting.getEmployeeId());
	}

}
