package ioc.example.repository;

import ioc.example.dto.Flight;
import java.time.LocalDate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class FlightRepositoryImpl implements FlightRepository{
    public static List<Flight> flightList= new ArrayList<>();

    @Override
    public void addFlight(Flight flight) {
        flightList.add(flight);
    }

    @Override
    public List<Flight> getFlight(String source, String destination, LocalDate journeyDate)
    {
       return flightList.stream().filter(flight -> flight.getSource().equalsIgnoreCase(source) && flight.getDestination().equalsIgnoreCase(destination) && flight.getJourneyDate().equals(journeyDate)).collect(Collectors.toList());
    }
    @Override
    public List<Flight> getAllFlight()
    {
        return flightList;
    }
}
