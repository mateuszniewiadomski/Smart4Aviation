# Description
The program runs on the default ``port: 8080``
### Input data for tests
Send JSON via ``POST`` into endpoint: ``localhost:8080/FlightEntity``, example:
```JSON
[
  {
    "flightId": 0,
    "flightNumber": 6157,
    "departureAirportIATACode": "LAX",
    "arrivalAirportIATACode": "KRK",
    "departureDate": "2015-07-27T06:45:50"
  }
]
```
Send JSON via ``POST`` into endpoint: ``localhost:8080/CargoEntity``, example:

```JSON
[
  {
    "flightId": 0,
    "baggage": [
      {
        "id": 0,
        "weight": 322,
        "weightUnit": "lb",
        "pieces": 902
      }
    ],
    "cargo": [
      {
        "id": 0,
        "weight": 534,
        "weightUnit": "kg",
        "pieces": 316
      }
    ]
  }
]
```

### Functionalities from the task
1. Send JSON via ``GET`` into endpoint:
``localhost:8080/flight``, example: 
   ```JSON
   {
    "flightNumber": 6157,
    "date": "2015-07-27T06:45:50"
   }
   ```
   In response we get:
    ```JSON
   {
      "cargoWeight": 1116,
      "baggageWeight": 1070,
      "totalWeight": 2186
    }
   ```
   - Weight is given in kilograms.
   
2. Send JSON via ``GET`` into endpoint:
   ``localhost:8080/airport``, example:
   ```JSON
   {
      "iataairportCode": "LAX",
      "date": "2015-07-27T06:45:50"
   }
   ```
   In response we get:
    ```JSON
   {
        "numberOfFlightsDeparting": 1,
        "numberOfFlightsArriving": 0,
        "totalPiecesOfBaggageArriving": 0,
        "totalPiecesOfBaggageDeparting": 6
    }
   ```