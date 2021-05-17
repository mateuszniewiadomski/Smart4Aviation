package mateusz.niewiadomski.aero.controllers;

import mateusz.niewiadomski.aero.models.request.AirportInfoRequest;
import mateusz.niewiadomski.aero.models.request.FlightInfoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import mateusz.niewiadomski.aero.models.CargoEntity;
import mateusz.niewiadomski.aero.models.FlightEntity;
import mateusz.niewiadomski.aero.models.response.AirportInfoResponse;
import mateusz.niewiadomski.aero.models.response.FlightInfoResponse;
import mateusz.niewiadomski.aero.service.AeroManager;

import java.util.List;

@RestController
public class Controller {

    private final AeroManager aeroManager;

    @Autowired
    public Controller(AeroManager aeroManager) { this.aeroManager = aeroManager; }

    @GetMapping("/flight")
    public FlightInfoResponse getFlight(@RequestBody FlightInfoRequest flightInfoRequest) {
        return aeroManager.getFlightInfo(flightInfoRequest);
    }

    @GetMapping("/airport")
    public AirportInfoResponse getAirport(@RequestBody AirportInfoRequest airportInfoRequest) {
        return aeroManager.getAirportInfo(airportInfoRequest);
    }




    // helpers to initialize test data
    // just POST JSON to the endpoint

    @PostMapping("/FlightEntity")
    public List<FlightEntity> addDataToFlightEntity(@RequestBody List<FlightEntity> flightEntityList) {
        return aeroManager.generateFlightEntity(flightEntityList);
    }

    @PostMapping("/CargoEntity")
    public List<CargoEntity> addDataToCargoEntity(@RequestBody List<CargoEntity> cargoEntityList) {
        return aeroManager.generateCargoEntity(cargoEntityList);
    }
}
