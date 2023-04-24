/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Product;

public class FoodServiceProduct extends Product {
    
    String menu;
    static int ctr =1;
    // Constructor
    public FoodServiceProduct(String menu, int price) {
        
        super("FOOD_SERVICE_"+String.valueOf(ctr),price);
        ctr+=1;
        this.menu=menu;
    }
    
    // Override abstract method to get product details
    @Override
    public FoodServiceProduct getProductDetails() {
        return this;
    }

    public String getMenu() {
        return menu;
    }

    public
    void setMenu(String menu) {
        this.menu = menu;
    }
    
    
    
   
}
