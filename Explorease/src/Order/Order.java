/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Order;

import Business.Customer.Customer;
import Business.Product.Product;
import WorkRequest.WorkQueue;
import java.util.ArrayList;

/**
 *
 * @author emi
 */
public class Order {
    String orderId;
    static int counter = 1;
    ArrayList<OrderItem> orderitems;
    Customer customer;
    String status;
    Boolean orderApproved;
    WorkQueue orderWorkQueue;

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Order.counter = counter;
    }

    public Boolean getOrderApproved() {
        return orderApproved;
    }

    public void setOrderApproved(Boolean orderApproved) {
        this.orderApproved = orderApproved;
    }
    
    public Order(Customer c) {
        this.orderId = "ORDER" + this.counter++;
        
        orderitems = new ArrayList<OrderItem>();
        customer = c;
        
        //customer.addCustomerOrder(this); //we link the order to the customer
        status = "in process";
        this.orderApproved = false;
        this.orderWorkQueue = new WorkQueue();
    }
    
    public OrderItem newOrderItem(Product p) {
        OrderItem oi = new OrderItem(p);
        orderitems.add(oi);
        return oi;
    }
    //order total is the sumer of the order item totals
    public int getOrderTotal() {
        int sum = 0;
        for (OrderItem oi : orderitems) {
            sum = sum + oi.getOrderItemTotal();
        }
        return sum;
    } 

    public
    String getOrderId() {
        return orderId;
    }

    public
    void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public
    ArrayList<OrderItem> getOrderitems() {
        return orderitems;
    }

    public
    void setOrderitems(ArrayList<OrderItem> orderitems) {
        this.orderitems = orderitems;
    }

    public
    Customer getCustomer() {
        return customer;
    }

    public
    void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public
    String getStatus() {
        return status;
    }

    public
    void setStatus(String status) {
        this.status = status;
    }

    public WorkQueue getOrderWorkQueue() {
        return orderWorkQueue;
    }
    
    
}
