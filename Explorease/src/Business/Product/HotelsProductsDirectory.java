/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Product;

import java.util.ArrayList;

/**
 *
 * @author 15512
 */
public class HotelsProductsDirectory {
    
    private ArrayList<HotelRoomsProduct> hotelProducts;
    
    public HotelsProductsDirectory() {
        this.hotelProducts = new ArrayList<HotelRoomsProduct>();
    }

    public ArrayList<HotelRoomsProduct> getHotelProducts() {
        return hotelProducts;
    }

    public void addToHotelProducts(HotelRoomsProduct hotelProduct) {
        this.hotelProducts.add(hotelProduct);
    }

    
}
