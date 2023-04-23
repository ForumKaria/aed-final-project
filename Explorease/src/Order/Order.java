/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Order;

import Business.Customer.Customer;
import Business.Product.Product;
import WorkRequest.WorkQueue;
import WorkRequest.WorkRequest;
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
    int flightOrderPriceWithFood;

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
        status = "in process";
        this.orderApproved = false;
        this.orderWorkQueue = new WorkQueue();
    }

    public OrderItem newOrderItem(Product p) {
        OrderItem oi = new OrderItem(p);
        orderitems.add(oi);
        return oi;
    }
    //for orgs that have attached services (air & travel agency), this will return total price from main org and also from sub org
    //for orgs that do not have attched services(like hotel), this will return clean revenue for that org
    public int getOrderTotal() {
        int sum = 0;
        for (WorkRequest wr: this.orderWorkQueue.getWorkQueue()){
            Order or= wr.getOrder();
            for (OrderItem oi : or.getOrderitems()) {
                sum = sum + oi.getOrderItemTotal();
            }
        }
        return sum;
    }
    
    //like if customer books flight with food, this method will return the revenue for flight, not including food
    public int getMainOrderTotal(){
        int sum = 0;
        for (OrderItem oi : orderitems) {
            sum = sum + oi.getOrderItemTotal();
        }
        return sum;
    }

    public void setFlightOrderPriceWithFood(int p){
        this.flightOrderPriceWithFood = p;
    }

    public int getFlightOrderPriceWithFood() {
        return flightOrderPriceWithFood;
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

    @Override
    public String toString(){
        return this.orderId;
    }


}
