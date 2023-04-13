/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Product;
import java.util.Date;

/**
 *
 * @author 15512
 */
public class AttractionTicketProduct extends Product{

    private String attraction;
    private int ticketPrice;
    private Date date;
    static int ctr = 1;
    // Constructor with parameters
    public AttractionTicketProduct(String attraction, int ticketPrice, Date date) {
        super("ATTRACTION_ID_"+String.valueOf(ctr));
        ctr+=1;
        this.attraction = attraction;
        this.ticketPrice = ticketPrice;
        this.date = date;
    }
    
    @Override
    public void getProductDetails() {
        System.out.println("Attraction : " + attraction);
        System.out.println("Ticket Price: " + ticketPrice);
    }
 
}
