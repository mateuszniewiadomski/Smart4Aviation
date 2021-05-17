package mateusz.niewiadomski.aero.models;

import lombok.Data;

import java.util.List;

@Data
public class CargoEntity {

    private int flightId;
    private List<Baggage> baggage;
    private List<Cargo> cargo;
}
