package ioc.example.dto;

//import javax.persistence.Entity;

import java.time.LocalDate;

public class Flight
{
   /* public Flight() {
        flightId++;
        //this.flightId = flightId;
    }*/

    public Flight(String airlines, String source, String destination, Double fare, LocalDate journeyDate, Integer seatCount) {
        this.flightId = flightIdCounter+1;
        this.airlines = airlines;
        this.source = source;
        this.destination = destination;
        this.fare = fare;
        this.journeyDate = journeyDate;
        this.seatCount = seatCount;
        flightIdCounter = this.flightId;
    }

    private static int flightIdCounter = 1000;
    private int flightId;

    public int getFlightId() {
        return flightId;
    }

    public String getAirlines() {
        return airlines;
    }

    public void setAirlines(String airlines) {
        this.airlines = airlines;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Double getFare() {
        return fare;
    }

    public void setFare(Double fare) {
        this.fare = fare;
    }

    public LocalDate getJourneyDate() {
        return journeyDate;
    }

    public void setJourneyDate(LocalDate journeyDate) {
        this.journeyDate = journeyDate;
    }

    public Integer getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(Integer seatCount) {
        this.seatCount = seatCount;
    }

    private String airlines;
    private String source;
    private String destination;
    private Double fare;
    private LocalDate journeyDate;
    private Integer seatCount;

    //Getter & Setter Methods


    @Override
    public String toString() {
        return "Flight{" +
                "flightId='" + flightId + '\'' +
                "airlines='" + airlines + '\'' +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", fare=" + fare +
                ", journeyDate=" + journeyDate +
                ", seatCount=" + seatCount +
                '}';
    }

}
