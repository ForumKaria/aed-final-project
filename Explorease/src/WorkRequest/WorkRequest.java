/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WorkRequest;

import Business.Customer.Customer;
import UserAccount.UserAccount;

/**
 *
 * @author emi
 */
public abstract class WorkRequest {
    String message;
    UserAccount sender;
    UserAccount receiver;
    // Order id or Order object
    Customer customer;
    String status;
    private String workrequestID;
    private static int counter = 1;
    
    WorkRequest() {
        // auto generate ID
        this.workrequestID = "WR" + this.counter++;
        
        // initialize required objects
    }
    
    public abstract void determineWorkRequestStatus();
}
