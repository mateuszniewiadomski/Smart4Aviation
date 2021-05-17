package mateusz.niewiadomski.aero.models.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FlightInfoResponse {

    private int cargoWeight;
    private int baggageWeight;
    private int totalWeight;
}
