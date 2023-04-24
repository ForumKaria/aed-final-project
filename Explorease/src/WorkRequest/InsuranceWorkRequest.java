/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WorkRequest;

import Business.Customer.Customer;
import Business.Platform;
import Order.Order;
import UserAccount.UserAccount;

/**
 *
 * @author emi
 */
public class InsuranceWorkRequest extends WorkRequest{
    Order customerTravelAgencyOrder;
    TripPlanningWorkRequest customerTripPlanningRequest;

    public InsuranceWorkRequest(Order o, Customer c, UserAccount sender, Platform platform) {
        super(o, c, sender, platform);
        this.receiverOrg = platform.getInsuranceOrg();
        this.receiverOrg.getWorkQueue().addWorkRequest(this);
    }

    public Order getCustomerTravelAgencyOrder() {
        return customerTravelAgencyOrder;
    }

    public void setCustomerTravelAgencyOrder(Order customerTravelAgencyOrder) {
        this.customerTravelAgencyOrder = customerTravelAgencyOrder;
    }

    public TripPlanningWorkRequest getCustomerTripPlanningRequest() {
        return customerTripPlanningRequest;
    }

    public void setCustomerTripPlanningRequest(TripPlanningWorkRequest customerTripPlanningRequest) {
        this.customerTripPlanningRequest = customerTripPlanningRequest;
    }





}
