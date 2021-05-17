package mateusz.niewiadomski.aero.service;

import mateusz.niewiadomski.aero.models.CargoEntity;
import mateusz.niewiadomski.aero.models.FlightEntity;
import mateusz.niewiadomski.aero.models.request.AirportInfoRequest;
import mateusz.niewiadomski.aero.models.request.FlightInfoRequest;
import mateusz.niewiadomski.aero.models.response.AirportInfoResponse;
import mateusz.niewiadomski.aero.models.response.FlightInfoResponse;

import java.util.List;

public interface AeroManager {

    AirportInfoResponse getAirportInfo(AirportInfoRequest airportInfoRequest);
    FlightInfoResponse getFlightInfo(FlightInfoRequest flightInfoRequest);

    List<CargoEntity> generateCargoEntity(List<CargoEntity> cargoEntityList);
    List<FlightEntity> generateFlightEntity(List<FlightEntity> flightEntityList);
}
