package ioc.example;

import ioc.example.dto.Flight;
import ioc.example.services.FlightService;
import ioc.example.services.FlightServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.support.AbstractApplicationContext;

import java.time.LocalDate;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App 
{

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
                FlightServiceImpl flightService = null;
                AbstractApplicationContext context = (AbstractApplicationContext) SpringApplication.run(App.class,
                        args);

        flightService = (FlightServiceImpl) context.getBean("flightService");
        System.out.println(flightService.printMessage("Hello Barkath"));
        Flight flightOne = new Flight("Air India","Chenai","Mumbai",5000.0,LocalDate.of(2021,3,19),42);
        Flight flightTwo = new Flight("Air India","Bangalore","Dubai",20000.0,LocalDate.of(2021,1,19),42);
        flightService.addFlight(flightOne);
        flightService.addFlight(flightTwo);
        System.out.println(flightService.searchFlight(flightOne.getSource(),flightOne.getDestination(),flightOne.getJourneyDate()));
        System.out.println(flightService.searchFlight(flightTwo.getSource(),flightTwo.getDestination(),flightTwo.getJourneyDate()));
    }
}
