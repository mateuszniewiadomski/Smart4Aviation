package mateusz.niewiadomski.aero.models;

import lombok.Data;

@Data
public class Baggage {

    private int id;
    private int weight;
    private WeightUnit weightUnit;
    private int pieces;
}
