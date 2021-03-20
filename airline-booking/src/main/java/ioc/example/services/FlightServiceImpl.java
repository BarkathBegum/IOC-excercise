package ioc.example.services;

import ioc.example.dto.Flight;
import ioc.example.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service("flightService")
public class FlightServiceImpl implements FlightService {

    @Autowired
    private FlightRepository flightRepository;

    @Override
    public List<Flight> searchFlight(String source, String destination, LocalDate journeyDate) {
        List<Flight> flightList = new ArrayList<Flight>();
        List<Flight> filteredFlightList = new ArrayList<Flight>();
        flightList = flightRepository.getFlight(source, destination,journeyDate);
        filteredFlightList = flightList.stream().map(flight -> {
            if (flight.getJourneyDate().getMonth()== Month.DECEMBER || flight.getJourneyDate().getMonth()== Month.JANUARY) {
                flight.setFare(flight.getFare() + (flight.getFare() * 20 / 100));
            }
            return flight;
        }).collect(Collectors.toList());
        return filteredFlightList;
    }

    @Override
    public List<Flight> searchAllFlight() {
        List<Flight> flightList = new ArrayList<Flight>();
        flightList = flightRepository.getAllFlight();
        return flightList;
    }

    @Override
    public void addFlight(Flight flight) {
        flightRepository.addFlight(flight);
    }
    public String printMessage(String message) {
        return message;
    }
}
