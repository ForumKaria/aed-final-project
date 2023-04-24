/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WorkRequest;

import Business.Customer.Customer;
import Business.Organization.Organization;
import Business.Platform;
import Business.Product.Product;
import Order.Order;
import UserAccount.UserAccount;

/**
 *
 * @author emi
 */

// Note - can delete other work requests type and make this class not abstract.
public class WorkRequest{
    String message; //do we need this? -> no - s
    UserAccount sender;
    Order order; //this is the order initiated by customer, different from when airline send food orders to food supplier
    Customer customer;
    String status;
    private String workrequestID;
    private static int counter = 1;
    Organization receiverOrg;
    Platform platform;
    String assignedTo;

    public Platform getPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public WorkRequest(Order o,Customer c, UserAccount sender,Platform platform) {
        // auto generate ID
        this.workrequestID = "WORK_REQUEST_" + this.counter++;
        this.order = o;
        this.customer = c;
        this.sender = sender;
        this.platform = platform;
//        this.receiverOrg = receiverOrg; //receiverOrg will be decided in child class
        this.status = "Order Requested";
        this.assignedTo = "None";
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserAccount getSender() {
        return sender;
    }

    public void setSender(UserAccount sender) {
        this.sender = sender;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getWorkrequestID() {
        return workrequestID;
    }

    public void setWorkrequestID(String workrequestID) {
        this.workrequestID = workrequestID;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        WorkRequest.counter = counter;
    }

    public Organization getReceiverOrg() {
        return receiverOrg;
    }

    public void setReceiverOrg(Organization receiverOrg) {
        this.receiverOrg = receiverOrg;
    }

    @Override
    public String toString(){
        return this.getWorkrequestID();
    }

//    public abstract void determineWorkRequestStatus();
}
