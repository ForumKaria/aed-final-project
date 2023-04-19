/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Order;

import Business.Product.Product;

/**
 *
 * @author emi
 */
public class OrderItem {

    Product selectedproduct;

    public OrderItem(Product p) {
        selectedproduct = p;
        //p.addOrderItem(this); //make sure product links back to the item
        
    }

    public int getOrderItemTotal() {
        return selectedproduct.getPrice();
    }

    public Product getSelectedproduct() {
        return selectedproduct;
    }

    public void setSelectedproduct(Product selectedproduct) {
        this.selectedproduct = selectedproduct;
    }
    
    
}
