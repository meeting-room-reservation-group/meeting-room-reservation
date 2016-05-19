package com.github.mrrg.roommanager.domain;

import java.util.Set;
import java.util.TreeSet;

public class Room {
	private final String name;
	private final String location;
	private final Integer capacity;
	private final Integer maxCapacity;
	private final Set<Facility> facilities = new TreeSet<Facility>();

	
	public Room(final Builder bldr) {
		if (bldr.getName() == null) {
			throw new IllegalArgumentException("Argument 'name' should not be null.");
		}
		if (bldr.getLocation() == null) {
			throw new IllegalArgumentException("Argument 'location' should not be null.");
		}
		if (bldr.getCapacity() == null) {
			throw new IllegalArgumentException("Argument 'capacity' should not be null.");
		}
		if (bldr.getCapacity() <= 0) {
			throw new IllegalArgumentException("Argument 'capacity' with value '"
					+ bldr.getCapacity() + "' should be larger then 0.");
		}
		if (bldr.getMaxCapacity() != null && bldr.getMaxCapacity() < bldr.getCapacity()) {
			throw new IllegalArgumentException("Argument 'maxCapacity' with value '"
					+ bldr.getMaxCapacity() + "' should be larger as capacity '" + bldr.getCapacity() + "'.");
		}

		this.name = bldr.getName();
		this.location = bldr.getLocation();
		this.capacity = bldr.getCapacity();
		this.maxCapacity = bldr.getMaxCapacity();
		this.facilities.addAll(bldr.getFacilities());
	}

	
	public String getName() {
		return name;
	}

	public String getLocation() {
		return location;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public Integer getMaxCapacity() {
		return maxCapacity;
	}

	public Set<Facility> getFacilities() {
		return facilities;
	}


	public static class Builder {
		private String name;
		private String location;
		private Integer capacity;
		private Integer maxCapacity;
		private Set<Facility> facilities = new TreeSet<Facility>();

		public Room create() {
			return new Room(this);
		}

		public Builder setRoomId(final String name) {
			this.name = name;
			return this;
		}

		public Builder setLocation(final String location) {
			this.location = location;
			return this;
		}

		public Builder setCapacity(Integer capacity) {
			this.capacity = capacity;
			return this;
		}

		public Builder setMaxCapacity(Integer maxCapacity) {
			this.maxCapacity = maxCapacity;
			return this;
		}

		public Builder addFacility(final Facility facility) {
			this.facilities.add(facility);
			return this;
		}


		public String getName() {
			return name;
		}

		public String getLocation() {
			return location;
		}

		public Integer getCapacity() {
			return capacity;
		}

		public Integer getMaxCapacity() {
			return maxCapacity;
		}

		public Set<Facility> getFacilities() {
			return facilities;
		}
	}

}
