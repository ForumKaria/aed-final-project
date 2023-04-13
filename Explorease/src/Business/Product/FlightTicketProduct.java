/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Product;

import java.util.Date;

/**
 *
 * @author 15512
 */

// FlightTicketProduct class (subclass of Product)
public class FlightTicketProduct extends Product {
    private String departureCity;
    private String destinationCity;
    private String airline;
    private Date departureDate;
    private String departureTime;
    private String flightDuration;
    private Boolean nonStop;
    private int price;
    private int numberOfSeatsAvailable;
    static int ctr =1;
    public FlightTicketProduct(String departureCity, String destinationCity, String airline, Date departureDate, String departureTime, String flightDuration, Boolean nonStop, int price, int numberOfSeatsAvailable) {
        super("FLIGHT_TICKET_"+String.valueOf(ctr));
        ctr+=1;
        this.departureCity = departureCity;
        this.destinationCity = destinationCity;
        this.airline = airline;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.flightDuration = flightDuration;
        this.nonStop = nonStop;
        this.price = price;
        this.numberOfSeatsAvailable = numberOfSeatsAvailable;
    }

    @Override
    public void getProductDetails() {
        System.out.println("Departure City: " + departureCity);
        System.out.println("Airline: " + airline);
        System.out.println("Price: " + price);
    }
    
    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getFlightDuration() {
        return flightDuration;
    }

    public void setFlightDuration(String flightDuration) {
        this.flightDuration = flightDuration;
    }

    public Boolean getNonStop() {
        return nonStop;
    }

    public void setNonStop(Boolean nonStop) {
        this.nonStop = nonStop;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNumberOfSeatsAvailable() {
        return numberOfSeatsAvailable;
    }

    public void setNumberOfSeatsAvailable(int numberOfSeatsAvailable) {
        this.numberOfSeatsAvailable = numberOfSeatsAvailable;
    }

    
    
   
}
