package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/meeting")
public class MeetingController {

	 @Autowired
	 private MeetingServiceImpl meetingService;
	 
	 @RequestMapping(value= {"/", "/list"}, method=RequestMethod.GET)
	 public ModelAndView getAllData() {
	  ModelAndView model = new ModelAndView();
	  List<Meeting> list = meetingService.getAllData();
	  
	  model.addObject("employee_list", list);
	  model.setViewName("employee_list");
	  return model;
	 }
	 
	 @RequestMapping(value="/add", method=RequestMethod.GET)
	 public ModelAndView addEmployee() {
	  ModelAndView model = new ModelAndView();
	  
	  Meeting meeting = new Meeting();
	  model.addObject("employeeForm", meeting);
	  
	  model.setViewName("employee_form");
	  return model;
	 }
	 
	 @RequestMapping(value="/save", method=RequestMethod.POST)
	 public ModelAndView saveOrUpdate(@ModelAttribute("employeeForm") Meeting meeting) {
	  if(meeting.getEmployeeId() != null) {
		  meetingService.updateEmployee(meeting);
	  } else {
	   meetingService.addEmployee(meeting);
	  }
	  
	  return new ModelAndView("redirect:/meeting/list");
	 }
	 
	 @RequestMapping(value="/update/{id}", method=RequestMethod.GET)
	 public ModelAndView editEmployee(@PathVariable int id) {
	  ModelAndView model = new ModelAndView();
	  
	  Meeting meeting = meetingService.findEmployeeById(id);
	  model.addObject("employeeForm", meeting);
	  
	  model.setViewName("employee_form");
	  return model;
	 }
}
