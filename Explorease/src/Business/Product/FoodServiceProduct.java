/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Product;

public class FoodServiceProduct extends Product {
    private Boolean vegan;
    private int price;
    
    // Constructor
    public FoodServiceProduct(String productId, Boolean vegan, int price) {
        super(productId);
        this.vegan = vegan;
        this.price = price;
    }
    
    // Override abstract method to get product details
    @Override
    public void getProductDetails() {
        System.out.println("Product ID: " + getProductId());
        System.out.println("Cuisine: " + vegan);
        System.out.println("Price: " + price);
    }
    
   
}

