/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Product;

/**
 *
 * @author forumkaria
 */
public
        class TravelAgencyProduct extends Product {
    
    String service;
    static int ctr =1;
    // Constructor
    public TravelAgencyProduct(String service, int price) {
        
        super("TRAVEL_AGENCY_SERVICE_"+String.valueOf(ctr),price);
        ctr+=1;
        this.service= service;
    }
    
    // Override abstract method to get product details
    @Override
    public TravelAgencyProduct getProductDetails() {
        return this;
    }
    
   
}
