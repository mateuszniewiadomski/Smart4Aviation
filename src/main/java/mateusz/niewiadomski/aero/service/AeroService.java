package mateusz.niewiadomski.aero.service;

import mateusz.niewiadomski.aero.models.Baggage;
import mateusz.niewiadomski.aero.models.Cargo;
import mateusz.niewiadomski.aero.models.request.AirportInfoRequest;
import mateusz.niewiadomski.aero.models.request.FlightInfoRequest;
import mateusz.niewiadomski.aero.models.response.AirportInfoResponse;
import mateusz.niewiadomski.aero.models.response.FlightInfoResponse;
import org.springframework.stereotype.Service;
import mateusz.niewiadomski.aero.models.CargoEntity;
import mateusz.niewiadomski.aero.models.FlightEntity;

import java.util.ArrayList;
import java.util.List;

@Service
public class AeroService implements AeroManager {

    // data will be stored in array lists
    private final List<CargoEntity> cargoEntityList;
    private final List<FlightEntity> flightEntityList;

    public AeroService() {
        this.cargoEntityList = new ArrayList<>();
        this.flightEntityList = new ArrayList<>();
    }

    @Override
    public AirportInfoResponse getAirportInfo(AirportInfoRequest airportInfoRequest) {
        AirportInfoResponse airportInfoResponse = new AirportInfoResponse(0,0,0,0);
        for (FlightEntity flightEntity : flightEntityList) {
            if (flightEntity.getDepartureDate().equals(airportInfoRequest.getDate())) {
                if (flightEntity.getDepartureAirportIATACode().toString().equals(airportInfoRequest.getIATAAirportCode())) {
                    airportInfoResponse.setNumberOfFlightsDeparting(airportInfoResponse.getNumberOfFlightsDeparting() + 1);
                    for (CargoEntity cargoEntity : cargoEntityList) {
                        if (cargoEntity.getFlightId() == flightEntity.getFlightId()) {
                            airportInfoResponse.setTotalPiecesOfBaggageDeparting(airportInfoResponse.getTotalPiecesOfBaggageDeparting() + cargoEntity.getBaggage().size() + cargoEntity.getCargo().size());
                        }
                    }
                }
                if (flightEntity.getArrivalAirportIATACode().toString().equals(airportInfoRequest.getIATAAirportCode())) {
                    airportInfoResponse.setNumberOfFlightsArriving(airportInfoResponse.getNumberOfFlightsArriving() + 1);
                    for (CargoEntity cargoEntity : cargoEntityList) {
                        if (cargoEntity.getFlightId() == flightEntity.getFlightId()) {
                            airportInfoResponse.setTotalPiecesOfBaggageArriving(airportInfoResponse.getTotalPiecesOfBaggageArriving() + cargoEntity.getBaggage().size() + cargoEntity.getCargo().size());
                        }
                    }
                }

            }
        }
        return airportInfoResponse;
    }

    @Override
    public FlightInfoResponse getFlightInfo(FlightInfoRequest flightInfoRequest) {

        FlightInfoResponse flightInfoResponse = new FlightInfoResponse(0,0,0);
        for (FlightEntity flightEntity : flightEntityList) {
            if (flightEntity.getFlightNumber() == flightInfoRequest.getFlightNumber() && flightEntity.getDepartureDate().equals(flightInfoRequest.getDate())) {
                for (CargoEntity cargoEntity : cargoEntityList) {
                    if (cargoEntity.getFlightId() == flightEntity.getFlightId()) {
                        for (Cargo cargo : cargoEntity.getCargo()) {
                            if (cargo.getWeightUnit().toString().equals("lb")) flightInfoResponse.setCargoWeight(flightInfoResponse.getCargoWeight() + (int)(cargo.getWeight() * 0.45359237));
                            else flightInfoResponse.setCargoWeight(flightInfoResponse.getCargoWeight() + cargo.getWeight());
                        }
                        for (Baggage baggage : cargoEntity.getBaggage()) {
                            if (baggage.getWeightUnit().toString().equals("lb")) flightInfoResponse.setBaggageWeight(flightInfoResponse.getBaggageWeight() + (int)(baggage.getWeight() * 0.45359237));
                            else flightInfoResponse.setBaggageWeight(flightInfoResponse.getBaggageWeight() + baggage.getWeight());
                        }
                        flightInfoResponse.setTotalWeight(flightInfoResponse.getCargoWeight() + flightInfoResponse.getBaggageWeight());
                        return flightInfoResponse;
                    }
                }
                return null;
            }
        }
        return null;
    }

    @Override
    public List<CargoEntity> generateCargoEntity(List<CargoEntity> cargoEntityList) {
        this.cargoEntityList.clear();
        this.cargoEntityList.addAll(cargoEntityList);
        return this.cargoEntityList;
    }

    @Override
    public List<FlightEntity> generateFlightEntity(List<FlightEntity> flightEntityList) {
        this.flightEntityList.clear();
        this.flightEntityList.addAll(flightEntityList);
        return this.flightEntityList;
    }
}
