package com.github.mrrg.roommanager.domain;

import static org.testng.Assert.assertEquals;

import java.util.Set;
import java.util.TreeSet;

import org.testng.annotations.Test;

public class RoomTest {

	@Test
	public void createRoom() throws Exception {
		Set<Facility> facilities = new TreeSet<Facility>();
		Facility whiteBoard = Facility.create("white board");
		facilities.add(whiteBoard);

		Room room = new Room.Builder().setRoomId("1").setLocation("1st floor")
				.setCapacity(6)
				.addFacility(whiteBoard)
				.create();

		assertEquals(room.getName(), "1");
		assertEquals(room.getLocation(), "1st floor");
		assertEquals(room.getFacilities(), facilities);
	}

	@Test
	public void createRoomMultipleFacilities() throws Exception {
		Set<Facility> facilities = new TreeSet<Facility>();
		Facility whiteBoard = Facility.create("white board");
		Facility monitor = Facility.create("monitor");
		facilities.add(whiteBoard);
		facilities.add(monitor);

		Room room = new Room.Builder().setRoomId("1").setLocation("1st floor").setCapacity(8).setMaxCapacity(9)
				.addFacility(whiteBoard)
				.addFacility(monitor)
				.create();

		assertEquals(room.getName(), "1");
		assertEquals(room.getLocation(), "1st floor");
		assertEquals(room.getFacilities(), facilities);
	}

}
