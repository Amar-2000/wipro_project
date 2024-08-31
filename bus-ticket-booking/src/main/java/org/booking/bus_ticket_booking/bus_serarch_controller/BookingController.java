package org.booking.bus_ticket_booking.bus_serarch_controller;

import java.util.ArrayList;
import java.util.List;

import org.booking.bus_ticket_booking.bus_entity.BusEntity;
import org.booking.bus_ticket_booking.model.BookingDetails;
import org.booking.bus_ticket_booking.service.BusService;
import org.booking.bus_ticket_booking.service.BusServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingController {
	
	@Autowired
	BusService busService;
	
	@PostMapping("search-buses")
	List<BusEntity> getBuses(@RequestBody BookingDetails bookingDetails) {
		return busService.searchBus(bookingDetails);
	}
	
}
