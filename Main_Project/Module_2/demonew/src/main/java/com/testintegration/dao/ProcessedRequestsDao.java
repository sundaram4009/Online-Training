package com.testintegration.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.testintegration.model.ProcessedRequests;

@Repository
public interface ProcessedRequestsDao extends JpaRepository<ProcessedRequests, Integer>{
	
	public ProcessedRequests findByRequestId(int id);
	

	
	@Transactional
	@Modifying
	@Query(value = "UPDATE processed_requests SET request_status=1 WHERE request_id = ?1 ", nativeQuery = true)//completed status=1
	public void completedStatus(Integer requestId);

	@Transactional
	@Modifying
	@Query(value = "UPDATE processed_requests SET request_status=2 WHERE request_id = ?1 ", nativeQuery = true)//updated status=2
	public void updatedPStatus(Integer requestId);
	
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE processed_requests SET request_status=3 WHERE request_id = ?1 ", nativeQuery = true)//approved status=3
	public void approvedStatus(Integer requestId);
	
	//fetches all the the requests approved by pm
	@Query(value="SELECT * FROM processed_requests WHERE request_status = 3", nativeQuery = true)
	public List<ProcessedRequests> findAllRequest(int status);
	
	
	
	
}
