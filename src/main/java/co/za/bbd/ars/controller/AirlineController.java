package co.za.bbd.ars.controller;

import co.za.bbd.ars.model.Airline;
import co.za.bbd.ars.service.impl.AirlineServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/airline-system/airline")
public class AirlineController {
    private final AirlineServiceImpl airlineService;

    @Autowired
    public AirlineController(AirlineServiceImpl airlineService) {
        this.airlineService = airlineService;
    }

    @RequestMapping(value = "/{airline}/update", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity updateAirline(
            @PathVariable Integer airlineId,
            @RequestBody Airline airline
    ) {
        try {
            Airline updatedAirline = airlineService.updateAirline(airlineId, airline);
            return new ResponseEntity<>(updatedAirline, HttpStatus.OK);
        } catch (IllegalArgumentException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
