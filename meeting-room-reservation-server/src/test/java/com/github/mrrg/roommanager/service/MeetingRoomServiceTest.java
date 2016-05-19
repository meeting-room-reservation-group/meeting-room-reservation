package com.github.mrrg.roommanager.service;

import java.util.Set;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.mrrg.roommanager.domain.Facility;
import com.github.mrrg.roommanager.repo.FacilityRepository;
import com.github.mrrg.roommanager.repo.MeetingRoomReservationRepository;
import com.github.mrrg.roommanager.repo.RoomRepository;

public class MeetingRoomServiceTest {
	private FacilityRepository facilityRepo = FacilityRepository.create();
	private RoomRepository roomRepo = RoomRepository.create(facilityRepo);
	private MeetingRoomReservationRepository mrrRepo = MeetingRoomReservationRepository.create();
	private MeetingRoomService meetingRoomService;

	@BeforeClass
	public void setUp() {
		meetingRoomService = new MeetingRoomService(facilityRepo, roomRepo, mrrRepo);
	}

	@Test
	public void getFacilities() throws Exception {
		Set<Facility> facilities = meetingRoomService.getFacilities();
	}
	
	@Test
	public void getMeetingRooms() throws Exception {
		
	}
	
	@Test
	public void findAvailableMeetingRooms() throws Exception {
		
	}
	@Test
	public void createReservation() throws Exception {
		
	}
}
