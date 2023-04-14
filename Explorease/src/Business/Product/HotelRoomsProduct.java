/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Product;

/**
 *
 * @author 15512
 */
public class HotelRoomsProduct extends Product {
    private String city;
    private String roomType;
    private int price;
    private int roomsAvailable;
    static int ctr = 1;
    
    public HotelRoomsProduct(String city, String roomType, int price, int roomsAvailable) {
        super("HOTEL_ROOM_ID_"+String.valueOf(ctr));
        ctr += 1;
        this.city = city;
        this.roomType = roomType;
        this.price = price;
        this.roomsAvailable = roomsAvailable;
    }

//    @Override
//    public void getProductDetails() {
//        System.out.println("City: " + city);
//        System.out.println("Room Type: " + roomType);
//        System.out.println("Price: " + price);
//    }
    
    @Override
    public HotelRoomsProduct getProductDetails() {
        return this;
    }
    
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRoomsAvailable() {
        return roomsAvailable;
    }

    public void setRoomsAvailable(int roomsAvailable) {
        this.roomsAvailable = roomsAvailable;
    }

    
}