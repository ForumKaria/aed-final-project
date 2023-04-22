/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WorkRequest;

import Business.Customer.Customer;
import Business.Platform;
import Business.Product.Product;
import Order.Order;
import UserAccount.UserAccount;
import java.util.ArrayList;

/**
 *
 * @author emi
 */
public class TripPlanningWorkRequest extends WorkRequest {

    Boolean needInsurance = false;
    Boolean isFullCoverage = false;
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

}
