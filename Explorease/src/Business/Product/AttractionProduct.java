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
        class AttractionProduct extends Product {
    
    String ticketType;
    static int ctr =1;
    // Constructor
    public AttractionProduct(String ticketType, int price) {
        
        super("ATTRACTION_TICKET_"+String.valueOf(ctr),price);
        ctr+=1;
        this.ticketType= ticketType;
    }
    
    // Override abstract method to get product details
    @Override
    public AttractionProduct getProductDetails() {
        return this;
    }
}
