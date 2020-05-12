package com.testintegration.model;
import java.sql.Date;
import java.sql.Time;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="room")
public class Room {
		@Id
		private int roomId;
		private int roomNo;
		private int capacity;
		private Date roomAvailFromDate;
		private Date roomAvailTillDate;
		private Time roomAvailFromTime;
		private Time roomAvailTillTime;
		private int alreadyAssigned;
		public int getRoomId() {
			return roomId;
		}
		public void setRoomId(int roomId) {
			this.roomId = roomId;
		}
		public int getRoomNo() {
			return roomNo;
		}
		public void setRoomNo(int roomNo) {
			this.roomNo = roomNo;
		}
		public int getCapacity() {
			return capacity;
		}
		public void setCapacity(int roomCapacity) {
			this.capacity = roomCapacity;
		}
		public Date getRoomAvailFromDate() {
			return roomAvailFromDate;
		}
		public void setRoomAvailFromDate(Date roomAvailFromDate) {
			this.roomAvailFromDate = roomAvailFromDate;
		}
		public Date getRoomAvailTillDate() {
			return roomAvailTillDate;
		}
		public void setRoomAvailTillDate(Date roomAvailTillDate) {
			this.roomAvailTillDate = roomAvailTillDate;
		}
		public Time getRoomAvailFromTime() {
			return roomAvailFromTime;
		}
		public void setRoomAvailFromTime(Time roomAvailFromTime) {
			this.roomAvailFromTime = roomAvailFromTime;
		}
		public Time getRoomAvailTillTime() {
			return roomAvailTillTime;
		}
		public void setRoomAvailTillTime(Time roomAvailTillTime) {
			this.roomAvailTillTime = roomAvailTillTime;
		}
		public int getAlreadyAssigned() {
			return alreadyAssigned;
		}
		public void setAlreadyAssigned(int alreadyAssigned) {
			this.alreadyAssigned = alreadyAssigned;
		}
		@Override
		public String toString() {
			return "Room [roomId=" + roomId + ", roomNo=" + roomNo + ", Capacity=" + capacity + ", roomAvailFromDate="
					+ roomAvailFromDate + ", roomAvailTillDate=" + roomAvailTillDate + ", roomAvailFromTime="
					+ roomAvailFromTime + ", roomAvailTillTime=" + roomAvailTillTime + ", alreadyAssigned="
					+ alreadyAssigned + "]";
		}
		
		
		
}