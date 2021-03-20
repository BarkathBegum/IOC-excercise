package ioc.example.services;

import ioc.example.dto.Flight;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface FlightService {
    List<Flight> searchAllFlight();
    List<Flight> searchFlight(String source, String destination, LocalDate journeyDate);
    void addFlight(Flight flight);
}
