package co.za.bbd.ars.service.impl;

import co.za.bbd.ars.model.TicketStatuses;
import co.za.bbd.ars.repository.TicketStatusesRepository;
import co.za.bbd.ars.service.TicketStatusesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketStatusesImpl implements TicketStatusesService {

    private final TicketStatusesRepository ticketStatusesRepository;

    @Autowired
    public TicketStatusesImpl(TicketStatusesRepository ticketStatusesRepository) {
        this.ticketStatusesRepository = ticketStatusesRepository;
    }

    @Override
    public TicketStatuses save(TicketStatuses ticketStatuses) {
        return ticketStatusesRepository.saveAndFlush(ticketStatuses);
    }

    @Override
    public Optional<TicketStatuses> read(Integer integer) {
        return Optional.empty();
    }

    @Override
    public void delete(TicketStatuses ticketStatuses) {

    }

    public List<TicketStatuses> getALlTicketStatuses() {
        return ticketStatusesRepository.findAll();
    }

    public TicketStatuses findStatusByStatusName(String status) {
        return ticketStatusesRepository.findByStatus(status);
    }
}
