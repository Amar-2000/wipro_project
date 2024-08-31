package org.booking.bus_ticket_booking.service;

import java.util.ArrayList;
import java.util.List;
import org.booking.bus_ticket_booking.bus_entity.BusEntity;
import org.booking.bus_ticket_booking.bus_repo.BusRepository;
import org.booking.bus_ticket_booking.model.BookingDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusServiceImpl implements BusService {

	@Autowired
	private BusRepository busRepository;
	
	@Override
	public List<BusEntity> searchBus(BookingDetails bookingDetails) {
		List<BusEntity> busesData = busRepository.findAll();
		List<BusEntity> buses = new ArrayList<>();
		for(BusEntity busData: busesData) {
			if(busData.getSource().equals(bookingDetails.getSource()) && busData.getDestination().equals(bookingDetails.getDestination()) && busData.getDate().equals(bookingDetails.getDate())) {
				buses.add(busData);
			}
		}
		return buses;
	}

}
