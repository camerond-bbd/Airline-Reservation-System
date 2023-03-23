package co.za.bbd.ars.controller;

import co.za.bbd.ars.model.TicketStatuses;
import co.za.bbd.ars.service.impl.TicketStatusesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/airline-system/ticketStatus")
public class TicketStatusesController {

    private final TicketStatusesImpl ticketStatusesImpl;

    @Autowired
    public TicketStatusesController(TicketStatusesImpl ticketStatusesImpl) {
        this.ticketStatusesImpl = ticketStatusesImpl;
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<TicketStatuses> createNewTicketStatus(
            @RequestBody TicketStatuses ticketStatus
    ){
        TicketStatuses newStatus = ticketStatusesImpl.save(ticketStatus);

        return new ResponseEntity<>(newStatus, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<TicketStatuses>> getAllTicketStatuses(){
        List<TicketStatuses> statuses = ticketStatusesImpl.getALlTicketStatuses();

        return new ResponseEntity<>(statuses, HttpStatus.OK);
    }

    @RequestMapping(value = "/{status}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<TicketStatuses> findStatusByStatusName(
            @PathVariable String status
    ) {
        TicketStatuses foundStatus = ticketStatusesImpl.findStatusByStatusName(status);
        return new ResponseEntity<>(foundStatus, HttpStatus.OK);
    }

}
