/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business;
import Business.Customer.CustomerDirectory;
import Business.Enterprise.Enterprise;
import static Business.Enterprise.Enterprise.EnterpriseType.Attraction;
import static Business.Enterprise.Enterprise.EnterpriseType.Hotel;
import static Business.Enterprise.Enterprise.EnterpriseType.Transportation;
import static Business.Enterprise.Enterprise.EnterpriseType.TravelAgency;
import Business.Enterprise.EnterpriseDirectory;
import Business.Enterprise.TransportationEnterprise;
import Business.Organization.Organization;
import static Business.Organization.Organization.OrganizationType.AirlineOrg;
import static Business.Organization.Organization.OrganizationType.AttractionOrg;
import static Business.Organization.Organization.OrganizationType.FoodServiceOrg;
import static Business.Organization.Organization.OrganizationType.HotelOrg;
import static Business.Organization.Organization.OrganizationType.InsuranceOrg;
import static Business.Organization.Organization.OrganizationType.TravelAgencyOrg;
import Business.Product.FlightTicketProduct;
import Business.Product.FoodServiceProduct;
import Business.Product.HotelRoomsProduct;
import Business.Product.Product;
import Order.OrderReport;
import Person.PersonDirectory;
import Roles.EnterpriseAdminRole;
import Roles.SystemAdminRole;
import UserAccount.UserAccount;
import UserAccount.UserAccountDirectory;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author emi
 */
public class Platform {
    UserAccountDirectory uad;
    CustomerDirectory customerDirectory;
    PersonDirectory personDirectory;
    EnterpriseDirectory enterpriseDirectory;
    OrderReport masterOrderReport;
    ArrayList<Product> hotelProducts;
    ArrayList<Product> flightProducts;
    ArrayList<Product> flightFoodProducts;
    public static Platform getInstance() {
        return new Platform();
    }
    
    public Platform(){
        this.uad = new UserAccountDirectory();
        this.customerDirectory = new CustomerDirectory();
        this.personDirectory = new PersonDirectory();
        this.enterpriseDirectory = new EnterpriseDirectory();
        this.masterOrderReport = new OrderReport();
       
        configureBusiness();
        populateData();
    }
    
    public void configureBusiness(){
        //create system admin user
        UserAccount systemAdmin = this.uad.createUserAccount("sys", "sys", new SystemAdminRole());
        
        //create 4 enterprises
        Enterprise transportation = this.getEnterpriseDirectory().createEnterprise(Transportation);
        Enterprise hotel = this.getEnterpriseDirectory().createEnterprise(Hotel);
        Enterprise travelAgency = this.getEnterpriseDirectory().createEnterprise(TravelAgency);
        Enterprise attraction = this.getEnterpriseDirectory().createEnterprise(Attraction);
        
        //create enterprise admin user
        UserAccount transAdmin = transportation.getUserAccountDirectory().createUserAccount("transadmin", "transadmin", new EnterpriseAdminRole());
        UserAccount hotelAdmin = hotel.getUserAccountDirectory().createUserAccount("hoteladmin", "hoteladmin", new EnterpriseAdminRole());
        UserAccount travelAgencyAdmin = travelAgency.getUserAccountDirectory().createUserAccount("travelAgencyadmin", "travelAgencyadmin", new EnterpriseAdminRole());
        UserAccount attractionAdmin = attraction.getUserAccountDirectory().createUserAccount("attractionadmin", "attractionadmin", new EnterpriseAdminRole());
        
        //create the 6 orgs
        Organization airlineOrg = transportation.getOrganizationDirectory().createOrganization(AirlineOrg);
        Organization foodServiceOrg = transportation.getOrganizationDirectory().createOrganization(FoodServiceOrg);
        Organization hotelOrg = transportation.getOrganizationDirectory().createOrganization(HotelOrg);
        Organization travelAgencyOrg = transportation.getOrganizationDirectory().createOrganization(TravelAgencyOrg);
        Organization insuranceOrg = transportation.getOrganizationDirectory().createOrganization(InsuranceOrg);
        Organization attractionOrg = transportation.getOrganizationDirectory().createOrganization(AttractionOrg);
        
    }

     public void populateData() {
        // Flight Ticket Products
      try{
                  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // Define the date format

        flightProducts.add(new FlightTicketProduct("New York", "Los Angeles", "American Airlines", sdf.parse("2023-05-01"), "8:00 AM", "06:00 hrs", true, 250, 100));
        flightProducts.add(new FlightTicketProduct("Chicago", "Miami", "Delta Airlines", sdf.parse("2023-05-02"), "10:30 AM", "03:30 hrs", false, 150, 50));
        flightProducts.add(new FlightTicketProduct("Houston", "Denver", "United Airlines", sdf.parse("2023-05-03"), "1:00 PM", "03:00 hrs", true, 200, 75));
        flightProducts.add(new FlightTicketProduct("San Francisco", "Seattle", "Alaska Airlines", sdf.parse("2023-05-04"), "11:00 AM", "02:00 hrs", true, 100, 30));
        flightProducts.add(new FlightTicketProduct("Boston", "Washington DC", "JetBlue Airways", sdf.parse("2023-05-05"), "9:00 AM", "01:30 hrs", true, 80, 20));
        flightProducts.add(new FlightTicketProduct("Los Angeles", "New York", "Delta Airlines", sdf.parse("2023-05-06"), "9:30 AM", "05:30 hrs", true, 300, 50));
        flightProducts.add(new FlightTicketProduct("Miami", "Chicago", "American Airlines", sdf.parse("2023-05-07"), "11:45 AM", "03:30 hrs", true, 175, 40));
        flightProducts.add(new FlightTicketProduct("Denver", "Houston", "Southwest Airlines", sdf.parse("2023-05-08"), "12:30 PM", "03:00 hrs", false, 175, 60));
        flightProducts.add(new FlightTicketProduct("Seattle", "San Francisco", "Alaska Airlines", sdf.parse("2023-05-09"), "1:30 PM", "02:00 hrs", true, 120, 15));
        flightProducts.add(new FlightTicketProduct("Washington DC", "Boston", "United Airlines", sdf.parse("2023-05-10"), "10:15 AM", "01:30 hrs", true, 90, 25));
        flightProducts.add(new FlightTicketProduct("New York", "San Francisco", "American Airlines", sdf.parse("2023-05-11"), "7:00 AM", "07:00 hrs", true, 400, 50));
        flightProducts.add(new FlightTicketProduct("Los Angeles", "Miami", "Delta Airlines", sdf.parse("2023-05-12"), "8:45 AM", "05:30 hrs", false, 275, 45));
        flightProducts.add(new FlightTicketProduct("Houston", "Seattle", "United Airlines", sdf.parse("2023-05-13"), "11:00 AM", "05:00 hrs", true, 225, 70));
        flightProducts.add(new FlightTicketProduct("Chicago", "Denver", "Southwest Airlines", sdf.parse("2023-05-14"), "2:00 PM", "02:30 hrs", true, 120, 30));
        flightProducts.add(new FlightTicketProduct("San Francisco", "Boston", "JetBlue Airways", sdf.parse("2023-05-15"), "12:00 PM", "06:00 hrs", true, 350, 20));
        flightProducts.add(new FlightTicketProduct("Washington DC", "Los Angeles", "United Airlines", sdf.parse("2023-05-16"), "9:30 AM", "06:00 hrs", true, 350, 60));
        flightProducts.add(new FlightTicketProduct("Boston", "Miami", "American Airlines", sdf.parse("2023-05-17"), "11:15 AM", "03:00 hrs", true, 150, 25));
        flightProducts.add(new FlightTicketProduct("Denver", "Chicago", "United Airlines", sdf.parse("2023-05-18"), "1:45 PM", "02:30 hrs", true, 125, 40));
        flightProducts.add(new FlightTicketProduct("Seattle", "Houston", "Delta Airlines", sdf.parse("2023-05-19"), "10:30 AM", "04:00 hrs", true, 225, 80));

        // In Flight food Product 
        flightFoodProducts.add(new FoodServiceProduct("FOOD_SERVICE_1",  true, 50));
        flightFoodProducts.add(new FoodServiceProduct("FOOD_SERVICE_2",  false, 80));
                
        // Hotel Room Products
        hotelProducts.add(new HotelRoomsProduct("Atlanta", "Standard Double", 150, 10));
        hotelProducts.add(new HotelRoomsProduct("Austin", "Standard Double", 175, 20));
        hotelProducts.add(new HotelRoomsProduct("Boston", "Deluxe Single", 175, 30));
        hotelProducts.add(new HotelRoomsProduct("Chicago", "Standard Single", 100, 5));
        hotelProducts.add(new HotelRoomsProduct("Denver", "Deluxe Suite", 375, 15));
        hotelProducts.add(new HotelRoomsProduct("Houston", "Executive Suite", 500, 14));
        hotelProducts.add(new HotelRoomsProduct("Las Vegas", "King Suite", 350, 14));
        hotelProducts.add(new HotelRoomsProduct("Los Angeles", "Deluxe Suite", 400, 13));
        hotelProducts.add(new HotelRoomsProduct("Miami", "King Suite", 300, 13));
        hotelProducts.add(new HotelRoomsProduct("Nashville", "Standard Single", 80, 12));
        hotelProducts.add(new HotelRoomsProduct("New Orleans", "Deluxe Suite", 400, 12));
        hotelProducts.add(new HotelRoomsProduct("New York", "Standard Double", 150, 11));
        hotelProducts.add(new HotelRoomsProduct("Orlando", "Standard Single", 100, 11));
        hotelProducts.add(new HotelRoomsProduct("Philadelphia", "King Suite", 425, 10));
        hotelProducts.add(new HotelRoomsProduct("Phoenix", "Standard Twin", 120, 10));
        hotelProducts.add(new HotelRoomsProduct("Portland", "Executive Suite", 550, 9));
        hotelProducts.add(new HotelRoomsProduct("San Antonio", "Deluxe Single", 300, 9));
        hotelProducts.add(new HotelRoomsProduct("San Diego", "Deluxe Twin", 225, 8));
        hotelProducts.add(new HotelRoomsProduct("San Francisco", "Standard Twin", 125, 8));
        hotelProducts.add(new HotelRoomsProduct("Seattle", "Standard Double", 200, 7));
        hotelProducts.add(new HotelRoomsProduct("Washington DC", "Deluxe Twin", 250, 7));

        System.out.println("Flights & Hotels Created");
      }catch(ParseException  e){
           e.printStackTrace();
      }
    }

    public ArrayList<Product> getHotelProducts() {
        return hotelProducts;
    }

    public void setHotelProducts(ArrayList<Product> hotelProducts) {
        this.hotelProducts = hotelProducts;
    }

    public ArrayList<Product> getFlightProducts() {
        return flightProducts;
    }

    public void setFlightProducts(ArrayList<Product> flightProducts) {
        this.flightProducts = flightProducts;
    }

    public ArrayList<Product> getFlightFoodProducts() {
        return flightFoodProducts;
    }

    public void setFlightFoodProducts(ArrayList<Product> flightFoodProducts) {
        this.flightFoodProducts = flightFoodProducts;
    }
    
    public UserAccountDirectory getUad() {
        return uad;
    }

    public CustomerDirectory getCustomerDirectory() {
        return customerDirectory;
    }

    public PersonDirectory getPersonDirectory() {
        return personDirectory;
    }

    public EnterpriseDirectory getEnterpriseDirectory() {
        return enterpriseDirectory;
    }

    public OrderReport getMasterOrderReport() {
        return masterOrderReport;
    }
    
    
}
