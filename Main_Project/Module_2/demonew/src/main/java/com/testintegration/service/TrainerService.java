package com.testintegration.service;

//import java.sql.Connection;
//import java.sql.Date;
//import java.sql.SQLException;
//import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testintegration.dao.IncomingRequestsDao;
import com.testintegration.dao.ProcessedRequestsDao;
import com.testintegration.dao.RoomDao;
import com.testintegration.dao.TrainerDao;
import com.testintegration.model.IncomingRequests;
import com.testintegration.model.ProcessedRequests;
import com.testintegration.model.Room;
import com.testintegration.model.Trainer;

@Service
public class TrainerService {

	@Autowired
	private IncomingRequestsDao incomingRequests;
	
	@Autowired
	private ProcessedRequestsDao processedRequestsDao;

	public List<IncomingRequests> findAllRequests() {
		List<IncomingRequests> incReq = new ArrayList<>();
		incReq = incomingRequests.findAllRequests(0);
		return incReq;		
		/*
		List<IncomingRequests> incReq = new ArrayList<>();
		Iterable<IncomingRequests> requestList = incomingRequests.findAll();
		requestList.forEach(incReq::add);
		return incReq;*/
	}
	
	public List<ProcessedRequests> findApprovedRequests() {
		List<ProcessedRequests> apprReq = new ArrayList<>();
		apprReq = processedRequestsDao.findAllRequest(3);
		return apprReq;
	}
	
	
	public List<ProcessedRequests> findAllProcessedRequests() {
		List<ProcessedRequests> procReq = new ArrayList<>();
		Iterable<ProcessedRequests> requestList = processedRequestsDao.findAll();
		requestList.forEach(procReq::add);
		return procReq;
	}
	
	//Modify request status to completed for /finalrequest URL
	public void completedStatus(int requestId) {
		processedRequestsDao.completedStatus(requestId);
		incomingRequests.completedStatus(requestId);
	}
	
	//Modify request status to updated for /updated URL in processed_requests table
	public void updatedPStatus(int requestId) {
		processedRequestsDao.updatedPStatus(requestId);
	}
	
	
	//Modify request status to approved for /approvedRequest URL in processed_requests table
		public void approvedStatus(int requestId) {
			processedRequestsDao.approvedStatus(requestId);
		}
	
	
	public Optional<IncomingRequests> findSingleRequest(int id){
//		List<IncomingRequests> singleRequest = new ArrayList<>();
		Optional<IncomingRequests> requestList = incomingRequests.findById(id);
//		requestList.forEach(singleRequest::add);
		return requestList;
	}
	

	public Optional<ProcessedRequests> findApprovedRequestById(int id) {
		Optional<ProcessedRequests> requestList = processedRequestsDao.findById(id);
		return requestList;
	}
	
	public Optional<ProcessedRequests> findUpdatedSingleRequest(int id){
		Optional<ProcessedRequests> newList = processedRequestsDao.findById(id);
		return newList;
	}
	
	
	//Modify request status to updated for /updated URL in incoming_requests table
	public void updatedStatus(int requestId) {
		incomingRequests.updatedStatus(requestId);
	}
	
	@Autowired
	private TrainerDao trainerDao;
	

	public List<Trainer> findAllTrainers() {
		List<Trainer> trainers = new ArrayList<>();
		Iterable<Trainer> trainerList = trainerDao.findAll();
		trainerList.forEach(trainers::add);
		return trainers;
	}
	
	public List<Trainer> findByTechnologyName(String technologyName) {
		List<Trainer> trainerList = trainerDao.findByTechnologyName(technologyName); 	
		return trainerList;
	}
	
	
	public void updateTrainer(int trainerId) {
		trainerDao.updateTrainer(trainerId);
	}
	
	
	
	@Autowired
	private RoomDao roomDao;
	
	public List<Room> findAllRooms(){
		List<Room> room= new ArrayList<>();
		Iterable<Room> roomList=roomDao.findAll();
		roomList.forEach(room::add);
		return room;
	}
	
	public List<Room> findByRoomCapacity(int candidateCount){
		List<Room> roomList = roomDao.findByRoomCapacity(candidateCount); 	
		return roomList;
	}

	
	
	public void updateRoom(int roomId) {
		roomDao.updateRoom(roomId);
	}

	
	
	
	/*
	public List<String> findRoomNumber(Date roomAvailFromDate,Date roomAvailTillDate,Time roomAvailFromTime,Time roomAvailTillTime,int capacity){
		List<String> list= new ArrayList<>();
		list=roomDao.findByQuery(roomAvailFromDate,roomAvailTillDate,roomAvailFromTime,roomAvailTillTime,capacity);
		return list;
	}*/
	
	/*
	public List<String> findTrainerNames(Date trainerAvailFromDate,Date trainerAvailTillDate,Time trainerAvailFromTime,Time trainerAvailTillTime,Integer technologyId) throws SQLException
	{
		List<IncomingRequests> trainers = new ArrayList<>();
		trainers=findAllRequests();
		List<String> list=new ArrayList<>();
		list=trainerDao.findByQuery(trainerAvailFromDate,trainerAvailTillDate,trainerAvailFromTime,trainerAvailTillTime,technologyId);
		return list;		
	}*/

}
