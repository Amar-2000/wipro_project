package org.booking.bus_ticket_booking.service;

import java.util.List;

import org.booking.bus_ticket_booking.bus_entity.BusEntity;
import org.booking.bus_ticket_booking.model.BookingDetails;

public interface BusService {
	public List<BusEntity> searchBus(BookingDetails bookingDetails);
}
