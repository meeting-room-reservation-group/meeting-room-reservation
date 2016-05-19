package com.github.mrrg.roommanager.domain;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class FacilityTest {

	@Test
	public void create() throws Exception {
		Facility monitor = Facility.create("monitor");
		assertEquals(monitor.getName(), "monitor");
		Facility largeMonitor = Facility.create("large monitor");
		assertEquals(largeMonitor.getName(), "large monitor");
	}

}
