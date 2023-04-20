/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Order;

import Business.Customer.Customer;
import java.util.ArrayList;

/**
 *
 * @author emi
 */
public
        class OrderCatalog {

    private
            ArrayList<Order> orders;

    public
            OrderCatalog() {
        this.orders = new ArrayList<Order>();
    }

    public
            Order createOrder(Customer customer) {
        Order order = new Order(customer);
        this.orders.add(order);

        return order;

    }

    public
            Order findOrder(String id) {
        for (Order order : this.orders) {
            if (order.getOrderId().equals(id)) {
                return order;
            }
        }
        return null;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }
    
            
    

}
