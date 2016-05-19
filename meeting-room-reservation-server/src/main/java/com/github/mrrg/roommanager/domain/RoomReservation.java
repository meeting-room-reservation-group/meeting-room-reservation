package com.github.mrrg.roommanager.domain;


public class RoomReservation {
	private Room room;


	public RoomReservation(final Builder bldr) {
		if (bldr.getRoom() == null) {
			throw new IllegalArgumentException("Argument 'room' should not be null.");
		}

		this.room = bldr.getRoom();
	}


	public Room getRoom() {
		return room;
	}


	public static class Builder {
		private Room room;

		public RoomReservation create() {
			return new RoomReservation(this);
		}

		public Builder setRoom(final Room room) {
			this.room = room;
			return this;
		}

		public Room getRoom() {
			return room;
		}

	}

}
