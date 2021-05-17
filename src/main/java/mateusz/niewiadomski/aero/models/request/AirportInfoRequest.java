package mateusz.niewiadomski.aero.models.request;

import lombok.Data;

import java.util.Date;

@Data
public class AirportInfoRequest {

    private String IATAAirportCode;
    private Date date;
}
