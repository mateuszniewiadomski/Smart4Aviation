package mateusz.niewiadomski.aero.models.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AirportInfoResponse {

    private int numberOfFlightsDeparting;
    private int numberOfFlightsArriving;
    private int totalPiecesOfBaggageArriving;
    private int totalPiecesOfBaggageDeparting;
}
