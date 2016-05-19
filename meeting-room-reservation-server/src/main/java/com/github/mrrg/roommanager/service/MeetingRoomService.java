package com.github.mrrg.roommanager.service;

import java.util.Set;

import com.github.mrrg.roommanager.domain.Facility;
import com.github.mrrg.roommanager.repo.FacilityRepository;
import com.github.mrrg.roommanager.repo.MeetingRoomReservationRepository;
import com.github.mrrg.roommanager.repo.RoomRepository;

public class MeetingRoomService {
	private FacilityRepository facilityRepo;
	private RoomRepository roomRepo;
	private MeetingRoomReservationRepository mrrRepo;


	public MeetingRoomService(final FacilityRepository facilityRepo, final RoomRepository roomRepo,
			final MeetingRoomReservationRepository mrrRepo) {
		if (facilityRepo == null) {
			throw new IllegalArgumentException("Argument 'facilityRepo' should not be null.");
		}
		if (roomRepo == null) {
			throw new IllegalArgumentException("Argument 'roomRepo' should not be null.");
		}
		if (mrrRepo == null) {
			throw new IllegalArgumentException("Argument 'mrrRepo' should not be null.");
		}
		
		this.facilityRepo = facilityRepo;
		this.roomRepo = roomRepo;
		this.mrrRepo = mrrRepo;
	}

	public Set<Facility> getFacilities() {
		return facilityRepo.getFacilities();
	}

}
