package com.testintegration.dao;

//import java.sql.Date;
//import java.sql.Time;
import java.util.List;



import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.testintegration.model.Room;


@Repository
public interface RoomDao extends CrudRepository<Room, Integer>{


	//@Query("Select r.roomId,r.roomNo,r.capacity,r.roomAvailFromDate,r.roomAvailTillDate,r.roomAvailFromTime,r.roomAvailTillTime,r.alreadyAssigned from room r where r.roomAvailFromDate<= ?1 and r.roomAvailTillDate>= ?2 and r.roomAvailFromTime<=?3 and r.roomAvailTillTime>= ?4 and r.capacity>= ?5")
	//public List<String> findByQuery(Date dt1,Date dt2, Time t3, Time t4, Integer c5);

	@Query(value ="SELECT * FROM Room  WHERE capacity >= ?1 AND already_assigned=0 ",nativeQuery = true)
	public List<Room> findByRoomCapacity(int candidateCount);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE Room SET already_assigned=1 WHERE room_id = ?1 ", nativeQuery = true)
	public void updateRoom(Integer roomId);
}
