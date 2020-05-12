package com.testintegration.dao;

//import java.sql.Date;
//import java.sql.Time;
import java.util.List;



import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.testintegration.model.*;

@Repository
public interface TrainerDao extends CrudRepository<Trainer, Integer> {
	
//	@Query("Select t.trainerId,t.trainerName,t.technologyId,t.trainerAvailFromDate,t.trainerAvailTillDate,t.trainerAvailFromTime,t.trainerAvailTillTime,t.contact,t.alreadyAssigned from trainer t where t.trainerAvailFromDate<= ?1 and t.trainerAvailTillDate>= ?2 and t.trainerAvailFromTime<=?3 and t.trainerAvailTillTime>= ?4 and t.technologyId= ?5")
//	public List<String> findByQuery(Date dt1,Date dt2,Time t3,Time t4,Integer t5);
	
	@Query(value ="SELECT * FROM Trainer  WHERE technology_name = ?1 AND already_assigned=0 ",nativeQuery = true)
	public List<Trainer> findByTechnologyName(String technologyName);
	//public List<String> findByQueryId(Integer t5);
	@Transactional
	@Modifying
	@Query(value = "UPDATE Trainer SET already_assigned=1 WHERE trainer_id = ?1 ", nativeQuery = true)
	public void updateTrainer(Integer trainerId);

}