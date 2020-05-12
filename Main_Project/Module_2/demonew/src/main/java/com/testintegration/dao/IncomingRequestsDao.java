package com.testintegration.dao;


import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.testintegration.model.IncomingRequests;
@Repository
public interface IncomingRequestsDao extends CrudRepository<IncomingRequests, Integer>{
	
	@Query(value="SELECT * FROM incoming_requests WHERE request_status = 0",nativeQuery = true)
	public List<IncomingRequests> findAllRequests(int i);
	
	
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE incoming_requests SET request_status=1 WHERE request_id = ?1 ", nativeQuery = true)//updated status=1
	public void updatedStatus(Integer requestId);
	
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE incoming_requests SET request_status=1 WHERE request_id = ?1 ", nativeQuery = true)//completed status=1
	public void completedStatus(Integer requestId);

}
