/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Product;

import java.util.ArrayList;

/**
 *
 * @author 15512
 */
public class FlightProductsDirectory {
    
    private ArrayList<FlightTicketProduct> flightProducts;
    
    public FlightProductsDirectory() {
        this.flightProducts = new ArrayList<FlightTicketProduct>();
    }

    public ArrayList<FlightTicketProduct> getFlightProducts() {
        return flightProducts;
    }

    public void addToFlightProducts(FlightTicketProduct flightProduct) {
        this.flightProducts.add(flightProduct);
    }
}
