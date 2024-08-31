package org.booking.bus_ticket_booking.bus_repo;

import org.booking.bus_ticket_booking.bus_entity.BusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
public interface BusRepository extends JpaRepository<BusEntity, Long> {

}
