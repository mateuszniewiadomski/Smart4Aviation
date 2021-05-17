package mateusz.niewiadomski.aero.models;

import lombok.Data;

import java.util.Date;

@Data
public class FlightEntity {

    private int flightId;
    private int flightNumber;
    private IATACodeDeparture departureAirportIATACode;
    private IATACodeArrival arrivalAirportIATACode;
    private Date departureDate;
}
