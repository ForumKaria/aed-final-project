/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Organization;

import Business.Employee.EmployeeDirectory;
import Business.Product.ProductCatalog;
import Order.Order;
import Order.OrderCatalog;
import UserAccount.UserAccountDirectory;
import WorkRequest.WorkQueue;

/**
 *
 * @author emi
 */
public class Organization {
    static int counter = 1;
    String organizationId;
    UserAccountDirectory userAccountDirectory;
    WorkQueue workQueue;
    EmployeeDirectory employeeDirectory;
    ProductCatalog productCatalog;
    OrderCatalog orderCatalog;
    
    //Order Report
    //Product Report
    
    public Organization(){

        this.organizationId = "org" + this.counter++;
        this.userAccountDirectory = new UserAccountDirectory();
        this.workQueue = new WorkQueue();
        this.employeeDirectory = new EmployeeDirectory();
        this.productCatalog = new ProductCatalog();
        this.orderCatalog = new OrderCatalog();
        
    }
    
    public enum OrganizationType {

        AirlineOrg("Airline Organization"),
        FoodServiceOrg("Food Service Organization"),
        HotelOrg("Hotel Organization"),
        TravelAgencyOrg("TravelAgency Organization"),
        InsuranceOrg("Insurance Organization"),
        AttractionOrg("Attraction Organization");
        
        private String type;

        private OrganizationType(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }


        @Override
        public String toString() {
            return type;
        }
    }

    public static int getCounter() {
        return counter;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public EmployeeDirectory getEmployeeDirectory() {
        return employeeDirectory;
    }

    public ProductCatalog getProductCatalog() {
        return productCatalog;
    }

    public OrderCatalog getOrderCatalog() {
        return orderCatalog;
    }
    
    public int getTotalRevenue(){
        int rev = 0;
        for(Order o: this.getOrderCatalog().getOrders()){
//            rev+= o.getOrderTotal();
            rev+= o.getMainOrderTotal();
        }
        return rev;
    }

    

}
