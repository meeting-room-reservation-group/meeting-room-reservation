package com.github.mrrg.roommanager.repo;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.github.mrrg.roommanager.domain.Room;

public class RoomRepository {
	private Map<String, Room> roomByName = new HashMap<String, Room>();


	public void add(Room room) {
		if (room == null) {
			throw new IllegalArgumentException("Argument 'room' should not be null.");
		}

		roomByName.put(room.getName(), room);
	}


	public static RoomRepository create(final FacilityRepository facilityRepo) {
		// TODO Auto-generated method stub
		return null;
	}


	public Room getByName(final String name) {
		if (! roomByName.containsKey(name)) {
			throw new IllegalArgumentException("");
		}

		return roomByName.get(name);
	}

	public Collection<Room> getAll() {
		return Collections.unmodifiableCollection(roomByName.values());
	}

}
