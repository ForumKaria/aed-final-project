/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Customer;

import Business.Product.Product;
import Order.Order;
import Order.OrderCatalog;
import Person.Person;
import UserAccount.UserAccount;
import WorkRequest.TripPlanningWorkRequest;
import java.util.ArrayList;

/**
 *
 * @author emi
 */
public class Customer {

    private OrderCatalog customerOrderCatalog;
    private Person person;
    private UserAccount userAccount;
    private ArrayList<TripPlanningWorkRequest> plannedTrips;

    public TripPlanningWorkRequest findPlannedTrip(String id) {
         for (TripPlanningWorkRequest plannedTrip : this.plannedTrips) {
            if (plannedTrip.getWorkrequestID().equals(id)) {
                return plannedTrip;
            }
        }
        return null;
    }

    public ArrayList<TripPlanningWorkRequest> getPlannedTrips() {
        return plannedTrips;
    }

    public void addToPlannedTrips(TripPlanningWorkRequest plannedTrip) {
        this.plannedTrips.add(plannedTrip);
    }

    public Customer(Person person, UserAccount userAccount) {
        this.customerOrderCatalog = new OrderCatalog();
        this.person = person;
        this.userAccount = userAccount;
        this.plannedTrips = new ArrayList<TripPlanningWorkRequest>();
    }

    public
    OrderCatalog getCustomerOrderCatalog() {
        return customerOrderCatalog;
    }

    public
    void setCustomerOrderCatalog(OrderCatalog customerOrderCatalog) {
        this.customerOrderCatalog = customerOrderCatalog;
    }

    public
    Person getPerson() {
        return person;
    }

    public
    void setPerson(Person person) {
        this.person = person;
    }

    public
    UserAccount getUserAccount() {
        return userAccount;
    }

    public
    void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }
    
    public int getTotalExpenditure(){
        int rev = 0;
        for(Order o: this.getCustomerOrderCatalog().getOrders()){
            rev+= o.getOrderTotal();
        }
        return rev;
    }

}
