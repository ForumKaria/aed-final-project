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
public class FoodServiceWorkRequest extends WorkRequest{
    Order customerFlightOrder;
    AirTicketWorkRequest customerFlightRequest;
    public FoodServiceWorkRequest(Order o, Customer c, UserAccount sender, Platform platform) {
        super(o, c, sender, platform);
        this.receiverOrg = platform.getFoodServiceOrg();
        this.receiverOrg.getWorkQueue().addWorkRequest(this);
    }

    public Order getCustomerFlightOrder() {
        return customerFlightOrder;
    }

    public void setCustomerFlightOrder(Order customerFlightOrder) {
        this.customerFlightOrder = customerFlightOrder;
    }

    public AirTicketWorkRequest getCustomerFlightRequest() {
        return customerFlightRequest;
    }

    public void setCustomerFlightRequest(AirTicketWorkRequest customerFlightRequest) {
        this.customerFlightRequest = customerFlightRequest;
    }
    
    

    
    
    
    
}
