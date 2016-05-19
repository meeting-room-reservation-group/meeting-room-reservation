package com.github.mrrg.roommanager.domain;

public class Facility implements Comparable<Facility> {
	private final String name;

	public Facility(final String name) {
		this.name = name;
	}

	public static Facility create(final String name) {
		return new Facility(name);
	}

	public String getName() {
		return name;
	}

	public int compareTo(final Facility other) {
		return this.getName().compareTo(other.getName());
	}

}
