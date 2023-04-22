/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WorkRequest;

import Business.Customer.Customer;
import Business.Platform;
import Business.Product.Product;
import java.util.Date;
import Order.Order;
import UserAccount.UserAccount;
import java.util.ArrayList;

/**
 *
 * @author emi
 */
public class TripPlanningWorkRequest extends WorkRequest{
    String depCity;
    String desCity;
    Date depDate;
    Boolean needInsurance = false;
    Boolean isFullCoverage = false;
    Boolean needAttractionTicket = false;
    Boolean needBooking = false;
    Boolean confirmedToBook = false;

    ArrayList<Product> plannedTrip = new ArrayList<Product>();

    public ArrayList<Product> getPlannedTrip() {
        return plannedTrip;
    }

    public void addToTripDetails(Product p) {
        this.plannedTrip.add(p);
    }

    public TripPlanningWorkRequest(Order o, Customer c, UserAccount sender, Platform platform) {
        super(o, c, sender, platform);
        this.receiverOrg = platform.getTravelAgencyOrg();
        this.receiverOrg.getWorkQueue().addWorkRequest(this);
    }

    public Boolean getNeedInsurance() {
        return needInsurance;
    }

    public void setNeedInsurance(Boolean needInsurance) {
        this.needInsurance = needInsurance;
    }

    public Boolean getIsFullCoverage() {
        return isFullCoverage;
    }

    public void setIsFullCoverage(Boolean isFullCoverage) {
        this.isFullCoverage = isFullCoverage;
    }

    public Boolean getNeedAttractionTicket() {
        return needAttractionTicket;
    }

    public void setNeedAttractionTicket(Boolean needAttractionTicket) {
        this.needAttractionTicket = needAttractionTicket;
    }

    public String getDepCity() {
        return depCity;
    }

    public void setDepCity(String depCity) {
        this.depCity = depCity;
    }

    public String getDesCity() {
        return desCity;
    }

    public void setDesCity(String desCity) {
        this.desCity = desCity;
    }

    public Date getDepDate() {
        return depDate;
    }

    public void setDepDate(Date depDate) {
        this.depDate = depDate;
    }

    public Boolean getNeedBooking() {
        return needBooking;
    }

    public void setNeedBooking(Boolean needBooking) {
        this.needBooking = needBooking;
    }

    public Boolean getConfirmedToBook() {
        return confirmedToBook;
    }

    public void setConfirmedToBook(Boolean confirmedToBook) {
        this.confirmedToBook = confirmedToBook;
    }









}
