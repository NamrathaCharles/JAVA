package com.command;

public class Sections {
	private int rows;
    private int sections;
    private int capacity;
    private int availableSeats;
	protected int getRows() {
		return rows;
	}
	protected void setRows(int rows) {
		this.rows = rows;
	}
	protected int getSections() {
		return sections;
	}
	protected void setSections(int sections) {
		this.sections = sections;
	}
	protected int getCapacity() {
		return capacity;
	}
	protected void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	protected int getAvailableSeats() {
		return availableSeats;
	}
	protected void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}
}
