package co.za.bbd.ars.controller;

import co.za.bbd.ars.dtos.FlightData;
import co.za.bbd.ars.dtos.FlightDataResponse;
import co.za.bbd.ars.dtos.FlightFilters;
import co.za.bbd.ars.model.Flight;
import co.za.bbd.ars.service.impl.FlightServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("api/v1/airline-system/flight")
public class FlightController {

    private final FlightServiceImpl flightService;

    @Autowired
    public FlightController(FlightServiceImpl flightService) {
        this.flightService = flightService;
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<FlightDataResponse> createNewFlightPlan(@RequestBody FlightData flightData)
    {
        System.out.println(flightData);
        FlightDataResponse newFlightPlan = flightService.createNewFlightPlan(flightData);
        return new ResponseEntity<>(newFlightPlan, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<FlightDataResponse>> getAllFlights(
            @RequestParam(value = "airlineId", required = false) Integer airlineId,
            @RequestParam(value = "departureAirportId", required = false) Integer departureAirportId,
            @RequestParam(value = "arrivalAirportId", required = false) Integer arrivalAirportId
    )
    {
        FlightFilters filters= new FlightFilters(airlineId, departureAirportId, arrivalAirportId);
        List<FlightDataResponse> flightDataResponses = flightService.getFlights(filters);
        return new ResponseEntity<>(flightDataResponses, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{flightId}/update", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity updateFlight(
            @PathVariable Integer flightId,
            @RequestBody Flight flight
    ) {
        try {
            Flight updatedFlight = flightService.updateFlight(flightId, flight);
            return new ResponseEntity<>(updatedFlight, HttpStatus.OK);

        } catch (IllegalArgumentException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
