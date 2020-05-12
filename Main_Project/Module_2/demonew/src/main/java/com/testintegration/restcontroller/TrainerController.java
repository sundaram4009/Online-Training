package com.testintegration.restcontroller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.testintegration.dao.ProcessedRequestsDao;
import com.testintegration.model.*;
import com.testintegration.service.TrainerService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TrainerController {

	@Autowired
	private TrainerService trainerService;
	
	@Autowired
	private ProcessedRequestsDao processedrepository;
	
	
	
	@RequestMapping("/")
	public String home() {
		return "welcome to Integration";
	}
	@RequestMapping("show")
	public List<IncomingRequests> getIncomingRequests(){
		return trainerService.findAllRequests();
	}
	
	@RequestMapping("showApproved")
	public List<ProcessedRequests> getApprovedRequests(){
		return trainerService.findApprovedRequests();
	}
	
	@RequestMapping("show/{id}")
	public Optional<IncomingRequests> getSingleRequest(@PathVariable int id){
		return trainerService.findSingleRequest(id);
	}
	
	
	@RequestMapping("showUpdated/{id}")
	public Optional<ProcessedRequests> getUpdatedRequest(@PathVariable int id){
		return trainerService.findUpdatedSingleRequest(id);
	}
	
	@RequestMapping("trainers")
	public List<Trainer>  getTrainers(){
		return trainerService.findAllTrainers();
	}
	
	@RequestMapping("/trainers/{technologyName}") 
	  public List<Trainer> findByTechnologyName(@PathVariable String technologyName) {
		  return trainerService.findByTechnologyName(technologyName) ;
	  
	  }
	
	@RequestMapping("rooms")
	public List<Room>  getRooms(){
		return trainerService.findAllRooms();
	}
	
	@RequestMapping("/rooms/{candidateCount}") 
	public List<Room> findByRoomCapacity(@PathVariable int candidateCount) {
		  return trainerService.findByRoomCapacity(candidateCount) ;
	  
	  }
	
	
	@RequestMapping("/process")
	public List<ProcessedRequests> getProcessedRequests(){
		return trainerService.findAllProcessedRequests();
	}
	
	@PostMapping("/finalrequest/{trainerId}/{roomId}/{requestId}") 
	  public void updateTrainerAndRoom(@Valid @RequestBody ProcessedRequests processedrequests,@PathVariable("trainerId") int trainerId,
			  @PathVariable("roomId")int roomId,@PathVariable("requestId")int requestId) 
	{
		  trainerService.updateTrainer(trainerId) ;
		  trainerService.updateRoom(roomId) ;
		  processedrepository.save(processedrequests);
		  trainerService.completedStatus(requestId);
	}

	
	
	@PostMapping("/updated/{requestId}")
	public void updatedRequest(@Valid @RequestBody ProcessedRequests processedrequests,@PathVariable("requestId")int requestId) {
		processedrepository.save(processedrequests);
		trainerService.updatedStatus(requestId);
		trainerService.updatedPStatus(requestId);
		
		
	}
	
	@PostMapping("/approvedRequest/{requestId}")
	public void approve(@PathVariable("requestId")int requestId) {
		trainerService.approvedStatus(requestId);
	}
	
	
	@RequestMapping("showApproved/{id}")
	public Optional<ProcessedRequests> getApprovedRequestById(@PathVariable int id){
		return trainerService.findApprovedRequestById(id);
	}
	
	
	/*
	@RequestMapping("/update")
	public ProcessedRequests updateRequest(@Valid @RequestBody ProcessedRequests processedrequests) {
		processedrequests.setRequestStatus(2);
		return processedrepository.save(processedrequests);
	}
	
	@RequestMapping("/approved")
	public ProcessedRequests approvedRequest(@Valid @RequestBody ProcessedRequests processedrequests) 
	{
		ProcessedRequests pr = new ProcessedRequests();
		pr=processedrepository.findByRequestId(processedrequests.getRequestId());
		processedrepository.delete(pr);
		pr.setRequestStatus(3);
		return processedrepository.save(pr);
		
	}
	@RequestMapping("/completed")
	public ProcessedRequests completedRequest(@Valid @RequestBody ProcessedRequests processedrequests){
		ProcessedRequests pr = new ProcessedRequests();
		pr=processedrepository.findByRequestId(processedrequests.getRequestId());
		processedrepository.delete(pr);
		pr.setRequestStatus(1);
		return processedrepository.save(pr);
		
	}*/

	
	/*
	 * 	@RequestMapping("trainers")
	public List<String> getAllTrainers(Date trainerAvailFromDate,Date trainerAvailTillDate,Time trainerAvailFromTime,Time trainerAvailTillTime,Integer technologyId) throws SQLException{
		
		
		List<IncomingRequests> abc = new ArrayList<>();
		abc = trainerService.findAllRequests();
		trainerAvailFromDate = abc.get(0).getTrainingStartDate();
		trainerAvailTillDate = abc.get(0).getTrainingEndDate();
		trainerAvailFromTime = abc.get(0).getTrainingStartTime();
		trainerAvailTillTime = abc.get(0).getTrainingEndTime();
		technologyId=abc.get(0).getTechnologyId();

		return trainerService.findTrainerNamesByTechId(technologyId);
	}*/

	/*
	@RequestMapping("rooms")
	public List<String> getAllRooms(Date roomAvailFromDate,Date roomAvailTillDate,Time roomAvailFromTime,Time roomAvailTillTime,Integer capacity){
		
		List<IncomingRequests> abc = new ArrayList<>();
		abc = trainerService.findAllRequests();
		roomAvailFromDate = abc.get(0).getTrainingStartDate();
		roomAvailTillDate = abc.get(0).getTrainingEndDate();
		roomAvailFromTime = abc.get(0).getTrainingStartTime();
		roomAvailTillTime = abc.get(0).getTrainingEndTime();
		capacity = abc.get(0).getCandidateCount();

		return trainerService.findRoomNumber(roomAvailFromDate,roomAvailTillDate,roomAvailFromTime,roomAvailTillTime,capacity);
		
	}*/
	/*
	 * @DeleteMapping("delete/{id}") 
	 * public List<Trainer> deletetrainer(@PathVariable int id)
	 * { return trainerService.deleteById(id); }
	 */
	
}
