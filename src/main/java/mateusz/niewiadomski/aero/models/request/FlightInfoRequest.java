package mateusz.niewiadomski.aero.models.request;

import lombok.Data;

import java.util.Date;

@Data
public class FlightInfoRequest {

    private int flightNumber;
    private Date date;
}
