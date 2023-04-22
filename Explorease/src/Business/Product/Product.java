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
    private int price;
    // Constructor
    public Product(String productId,int price) {
        this.productId = productId;
        this.price = price;
    }
    
    // Abstract method to get product details
    public abstract Product getProductDetails();

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    // Getters and Setters
    public String getProductId() {
        return productId;
    }
    
    public void setProductId(String productId) {
        this.productId = productId;
    }
    
    @Override
    public String toString(){
        return this.productId;
    }
}