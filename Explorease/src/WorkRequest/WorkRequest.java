/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WorkRequest;

import Business.Customer.Customer;
import Business.Organization.Organization;
import Order.Order;
import UserAccount.UserAccount;

/**
 *
 * @author emi
 */
public abstract class WorkRequest {
    String message;
    UserAccount sender;
    UserAccount receiver;
    Order order;
    Customer customer;
    String status;
    private String workrequestID;
    private static int counter = 1;
    Organization receiverOrg;

    
    WorkRequest(Order o) {
        // auto generate ID
        this.workrequestID = "WORk_REQUEST_" + this.counter++;
        this.order = o;
        // initialize required objects
    }
    
    public abstract void determineWorkRequestStatus();
}
