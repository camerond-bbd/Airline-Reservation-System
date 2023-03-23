package co.za.bbd.ars.repository;

import co.za.bbd.ars.model.TicketStatuses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketStatusesRepository extends JpaRepository<TicketStatuses, Integer> {
    TicketStatuses findByStatus(String status);
}
