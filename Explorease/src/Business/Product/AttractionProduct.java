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
    String city;
    static int ctr =1;
    // Constructor
    public AttractionProduct(String city, String ticketType, int price) {
        
        super("ATTRACTION_TICKET_"+String.valueOf(ctr),price);
        ctr+=1;
        this.ticketType= ticketType;
        this.city = city;
    }
    
    // Override abstract method to get product details
    @Override
    public AttractionProduct getProductDetails() {
        return this;
    }

    public String getTicketType() {
        return ticketType;
    }

    public String getCity() {
        return city;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public void setCity(String city) {
        this.city = city;
    }
    
    
    
}
