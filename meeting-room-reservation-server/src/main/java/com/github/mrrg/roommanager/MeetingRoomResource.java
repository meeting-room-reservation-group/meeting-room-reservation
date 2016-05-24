package com.github.mrrg.roommanager;

import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.github.mrrg.roommanager.domain.Room;
import com.github.mrrg.roommanager.repo.RoomRepository;

@Path("meeting-room")
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class MeetingRoomResource {
	private RoomRepository roomRepo = null;//CsvRoomRepository.

	@GET
	@Path("list")
	public Collection<Room> getList() {
		return roomRepo.getAll();
	}

}
