package co.za.bbd.ars.controller;

import co.za.bbd.ars.api.TicketAPI;
import co.za.bbd.ars.factory.TicketFactory;
import co.za.bbd.ars.model.Ticket;
import co.za.bbd.ars.service.impl.TicketServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/airline-system/ticket")
public class TicketController {
    private final TicketServiceImpl ticketService;
    private TicketAPI api;

    @Autowired
    public TicketController(TicketServiceImpl ticketService, TicketAPI api) {
        this.ticketService = ticketService;
        this.api = api;
    }


    @PostMapping("save")
    public ResponseEntity<Ticket> save(@Valid @RequestBody Ticket ticket) {
        Ticket saveTicket = TicketFactory.createTicket(ticket.getTicketId(), ticket.getFlight(), ticket.getStatus(), ticket.getTicketDescription(), ticket.getPrice(), ticket.getSeatNumber());
        return ResponseEntity.ok(ticketService.save(saveTicket));
    }

    @GetMapping("read/{id}")
    public ResponseEntity<Ticket> read(@PathVariable Integer id) {
        var ticket = this.ticketService.read(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ticket Could Not Be Found"));
        return ResponseEntity.ok(ticket);
    }

    @DeleteMapping("delete")
    public ResponseEntity<Void> delete(Ticket ticket) {
        this.ticketService.delete(ticket);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Integer id) {
        this.ticketService.deleteById(id);
        return ResponseEntity.ok(true);
    }

    @GetMapping("all")
    public ResponseEntity<List<Ticket>> findAll() {
        List<Ticket> ticketList = this.ticketService.findAll();
        return ResponseEntity.ok(ticketList);
    }

    @GetMapping("all/{id}")
    public ResponseEntity<List<Ticket>> findAllTicketsByFlightId(@PathVariable Integer id) {
        List<Ticket> ticketList = this.ticketService.findAllTicketsByFlightId(id);
        return ResponseEntity.ok(ticketList);
    }
}
