package com.testintegration.dao;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.testintegration.model.*;

@Repository
public interface TechnologyDao extends CrudRepository<Trainer, Integer> {
	
	
}