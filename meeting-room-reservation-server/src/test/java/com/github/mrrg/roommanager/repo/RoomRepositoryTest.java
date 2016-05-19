package com.github.mrrg.roommanager.repo;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import org.testng.annotations.Test;

public class RoomRepositoryTest {

	@Test
	public void create() throws Exception {
		FacilityRepository facilityRepo = FacilityRepository.create();
		RoomRepository roomRepo = RoomRepository.create(facilityRepo);
		
		assertNotNull(roomRepo);
		assertEquals(roomRepo.getByName("01").getLocation(), "1st floor"); 
	}
}
