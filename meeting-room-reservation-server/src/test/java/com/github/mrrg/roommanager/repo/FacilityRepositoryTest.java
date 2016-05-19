package com.github.mrrg.roommanager.repo;

import static org.testng.Assert.assertNotNull;

import org.testng.annotations.Test;

public class FacilityRepositoryTest {

	@Test
	public void create() throws Exception {
		FacilityRepository facilityRepo = FacilityRepository.create();

		assertNotNull(facilityRepo);
//		assertEquals(facilityRepo.get);
	}

}
