package ioc.example.repository;

import ioc.example.dto.Flight;
import java.time.LocalDate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository {
    void addFlight(Flight flight);
    List<Flight> getFlight(String source, String destination, LocalDate journeyDate);
    List<Flight> getAllFlight();

}
