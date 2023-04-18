/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Product;

import Business.Customer.Customer;
import java.util.ArrayList;

/**
 *
 * @author emi
 */
public
        class ProductCatalog {

    private
            ArrayList<Product> products;

    public
            ProductCatalog() {
        this.products = new ArrayList<Product>();
    }

    public
    ArrayList<Product> getProducts() {
        return products;
    }
            

    public
            Product addProduct(Product p) {
        this.products.add(p);
        return p;

    }

    public
            Product findProduct(String id) {
        for (Product product : this.products) {
            if (product.getProductId().equals(id)) {
                return product;
            }
        }
        return null;
    }
}
