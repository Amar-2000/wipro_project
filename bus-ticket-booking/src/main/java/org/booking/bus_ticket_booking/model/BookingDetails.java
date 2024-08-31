package org.booking.bus_ticket_booking.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class BookingDetails {
	private String source;
	private String destination;
	private LocalDate date;
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	
}
