package com.github.mrrg.roommanager.domain;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.github.mrrg.roommanager.repo.FacilityRepository;
import com.github.mrrg.roommanager.repo.RoomRepository;

public class RoomReservationTest {
	private FacilityRepository facilityRepo = FacilityRepository.create();
	private RoomRepository roomRepo = RoomRepository.create(facilityRepo);


	@Test
	public void create() throws Exception {
		Room room = roomRepo.getByName("01");

		RoomReservation roomReservaltion = new RoomReservation.Builder()
				.setRoom(room)
//				.setDate()
//				.setDuration()
//				.addPerson()
				.create();
		
		assertEquals(roomReservaltion.getRoom(), room);
	}
	
}
