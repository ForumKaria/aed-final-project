/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Product;

public class FoodServiceProduct extends Product {
    private Boolean vegan;
    
    // Constructor
    public FoodServiceProduct(String productId, Boolean vegan, int price) {
        super(productId,price);
        this.vegan = vegan;
    }
    
    // Override abstract method to get product details
    @Override
    public FoodServiceProduct getProductDetails() {
        return this;
    }
    
   
}
