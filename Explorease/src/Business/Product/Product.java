/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Product;

/**
 *
 * @author emi
 */
public abstract class Product {
    private String productId;
    
    // Constructor
    public Product(String productId) {
        this.productId = productId;
    }
    
    // Abstract method to get product details
    public abstract void getProductDetails();
    
    // Getters and Setters
    public String getProductId() {
        return productId;
    }
    
    public void setProductId(String productId) {
        this.productId = productId;
    }
}
