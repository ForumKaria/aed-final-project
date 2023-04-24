/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business;

import Business.Customer.Customer;
import Business.Product.FlightProductsDirectory;
import Business.Product.HotelsProductsDirectory;
import Business.Customer.CustomerDirectory;
import Business.Enterprise.Enterprise;
import static Business.Enterprise.Enterprise.EnterpriseType.Attraction;
import static Business.Enterprise.Enterprise.EnterpriseType.Hotel;
import static Business.Enterprise.Enterprise.EnterpriseType.Transportation;
import static Business.Enterprise.Enterprise.EnterpriseType.TravelAgency;
import Business.Enterprise.EnterpriseDirectory;
import Business.Enterprise.TransportationEnterprise;
import Business.Organization.AirlineOrganization;
import Business.Organization.Organization;
import static Business.Organization.Organization.OrganizationType.AirlineOrg;
import static Business.Organization.Organization.OrganizationType.AttractionOrg;
import static Business.Organization.Organization.OrganizationType.FoodServiceOrg;
import static Business.Organization.Organization.OrganizationType.HotelOrg;
import static Business.Organization.Organization.OrganizationType.InsuranceOrg;
import static Business.Organization.Organization.OrganizationType.TravelAgencyOrg;
import Business.Organization.OrganizationDirectory;
import Business.Organization.TravelAgencyOrganization;
import Business.Product.AttractionProduct;
import Business.Product.FlightTicketProduct;
import Business.Product.FoodServiceProduct;
import Business.Product.HotelRoomsProduct;
import Business.Product.InsuranceProduct;
import Business.Product.Product;
import Business.Product.ProductCatalog;
import Business.Product.TravelAgencyProduct;
import Order.Order;
import Order.OrderReport;
import Person.Person;
import Person.PersonDirectory;
import Roles.CustomerRole;
import Roles.EnterpriseAdminRole;
import Roles.AirlineAgentRole;
import Roles.AttractionOfficerRole;
import Roles.FoodServiceSupplierRole;
import Roles.InsuranceAdvisorRole;
import Roles.SystemAdminRole;
import Roles.TravelAgentRole;
import UserAccount.UserAccount;
import UserAccount.UserAccountDirectory;
import WorkRequest.AirTicketWorkRequest;
import WorkRequest.FoodServiceWorkRequest;
import WorkRequest.InsuranceWorkRequest;
import WorkRequest.TripPlanningWorkRequest;
import WorkRequest.WorkRequest;
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
//    HotelsProductsDirectory hotelProducts;
//    FlightProductsDirectory flightProducts;
//    ArrayList<FoodServiceProduct> flightFoodProducts;
    Organization airlineOrg;
    Organization hotelOrg;
    Organization foodServiceOrg;
    Organization travelAgencyOrg;
    Organization insuranceOrg;
    Organization attractionOrg;

    public static Platform getInstance() throws ParseException{
        return new Platform();
    }

    public Platform() throws ParseException{
        this.uad = new UserAccountDirectory();
        this.customerDirectory = new CustomerDirectory();
        this.personDirectory = new PersonDirectory();
        this.enterpriseDirectory = new EnterpriseDirectory();
        this.masterOrderReport = new OrderReport();

        configureBusiness();
        populateProductData();

        //create fake orders for the pre-created customers
        for(Customer c: this.customerDirectory.getCustomerlist()){
            generateFakeOrders(c);  
        }
        
    }

    public void configureBusiness() {
        // Configure Business
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
        UserAccount travelAgencyAdmin = travelAgency.getUserAccountDirectory().createUserAccount("traveladmin", "traveladmin", new EnterpriseAdminRole());
        UserAccount attractionAdmin = attraction.getUserAccountDirectory().createUserAccount("attadmin", "attadmin", new EnterpriseAdminRole());

        //create the 6 orgs

        airlineOrg = transportation.getOrganizationDirectory().createOrganization(AirlineOrg);
        foodServiceOrg = transportation.getOrganizationDirectory().createOrganization(FoodServiceOrg);
        hotelOrg = hotel.getOrganizationDirectory().createOrganization(HotelOrg);
        travelAgencyOrg = travelAgency.getOrganizationDirectory().createOrganization(TravelAgencyOrg);
        insuranceOrg = travelAgency.getOrganizationDirectory().createOrganization(InsuranceOrg);
        attractionOrg = attraction.getOrganizationDirectory().createOrganization(AttractionOrg);

        //create org persons for testing, enterprise admin can also create new org admin users from UI
        UserAccount airOrgAdmin = airlineOrg.getUserAccountDirectory().createUserAccount("air", "air", new AirlineAgentRole());
        UserAccount airOrgAdmin2 = airlineOrg.getUserAccountDirectory().createUserAccount("airorg", "airorg", new AirlineAgentRole());
        UserAccount hotelOrgAdmin = hotelOrg.getUserAccountDirectory().createUserAccount("hotel", "hotel", new AirlineAgentRole());
        UserAccount foodOrgAdmin = foodServiceOrg.getUserAccountDirectory().createUserAccount("food", "food", new FoodServiceSupplierRole());
        UserAccount travelOrgAdmin = travelAgencyOrg.getUserAccountDirectory().createUserAccount("t", "t", new TravelAgentRole());
        UserAccount insuranceOrgAdmin = insuranceOrg.getUserAccountDirectory().createUserAccount("ins", "ins", new InsuranceAdvisorRole());
        UserAccount attOrgAdmin = attractionOrg.getUserAccountDirectory().createUserAccount("att", "att", new AttractionOfficerRole());

        //create a customer for testing
        UserAccount cus = this.getUad().createUserAccount("c", "c", new CustomerRole());
        Person p = this.getPersonDirectory().createPerson(cus.getAccountId(), "customer1");
        Customer c = this.getCustomerDirectory().createCustomer(p,cus);
        //create more customers
        for(int i = 0; i<10; i++){
            UserAccount cc = this.getUad().createUserAccount("c"+String.valueOf(i), "c"+String.valueOf(i), new CustomerRole());
            Person pp = this.getPersonDirectory().createPerson(cc.getAccountId(), "customer"+String.valueOf(i));
            Customer customer = this.getCustomerDirectory().createCustomer(pp,cc);
        }
        

       }

    public void populateProductData() {
        try {
            // PopulateData
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // Define the date format

            //flights data
            ProductCatalog flightProducts = airlineOrg.getProductCatalog();
            flightProducts.addProduct(new FlightTicketProduct("New York", "Los Angeles", "American Airlines", sdf.parse("2023-05-01"), "8:00 AM", "06:00 hrs", true, 250, 100));
            flightProducts.addProduct(new FlightTicketProduct("Chicago", "Miami", "Delta Airlines", sdf.parse("2023-05-02"), "10:30 AM", "03:30 hrs", false, 150, 50));
            flightProducts.addProduct(new FlightTicketProduct("Chicago", "Miami", "Delta Airlines", sdf.parse("2023-04-08"), "10:30 AM", "03:30 hrs", false, 135, 50));
            flightProducts.addProduct(new FlightTicketProduct("Houston", "Denver", "United Airlines", sdf.parse("2023-05-03"), "1:00 PM", "03:00 hrs", true, 200, 75));
            flightProducts.addProduct(new FlightTicketProduct("San Francisco", "Seattle", "Alaska Airlines", sdf.parse("2023-05-04"), "11:00 AM", "02:00 hrs", true, 100, 30));
            flightProducts.addProduct(new FlightTicketProduct("Boston", "Washington DC", "JetBlue Airways", sdf.parse("2023-05-05"), "9:00 AM", "01:30 hrs", true, 80, 20));
            flightProducts.addProduct(new FlightTicketProduct("Los Angeles", "New York", "Delta Airlines", sdf.parse("2023-05-06"), "9:30 AM", "05:30 hrs", true, 300, 50));
            flightProducts.addProduct(new FlightTicketProduct("Miami", "Chicago", "American Airlines", sdf.parse("2023-05-07"), "11:45 AM", "03:30 hrs", true, 175, 40));
            flightProducts.addProduct(new FlightTicketProduct("Denver", "Houston", "Southwest Airlines", sdf.parse("2023-05-08"), "12:30 PM", "03:00 hrs", false, 175, 60));
            flightProducts.addProduct(new FlightTicketProduct("Seattle", "San Francisco", "Alaska Airlines", sdf.parse("2023-05-09"), "1:30 PM", "02:00 hrs", true, 120, 15));
            flightProducts.addProduct(new FlightTicketProduct("Washington DC", "Boston", "United Airlines", sdf.parse("2023-05-10"), "10:15 AM", "01:30 hrs", true, 90, 25));
            flightProducts.addProduct(new FlightTicketProduct("New York", "San Francisco", "American Airlines", sdf.parse("2023-05-11"), "7:00 AM", "07:00 hrs", true, 400, 50));
            flightProducts.addProduct(new FlightTicketProduct("Los Angeles", "Miami", "Delta Airlines", sdf.parse("2023-05-12"), "8:45 AM", "05:30 hrs", false, 275, 45));
            flightProducts.addProduct(new FlightTicketProduct("Houston", "Seattle", "United Airlines", sdf.parse("2023-05-13"), "11:00 AM", "05:00 hrs", true, 225, 70));
            flightProducts.addProduct(new FlightTicketProduct("Chicago", "Denver", "Southwest Airlines", sdf.parse("2023-05-14"), "2:00 PM", "02:30 hrs", true, 120, 30));
            flightProducts.addProduct(new FlightTicketProduct("San Francisco", "Boston", "JetBlue Airways", sdf.parse("2023-05-15"), "12:00 PM", "06:00 hrs", true, 350, 20));
            flightProducts.addProduct(new FlightTicketProduct("Washington DC", "Los Angeles", "United Airlines", sdf.parse("2023-05-16"), "9:30 AM", "06:00 hrs", true, 350, 60));
            flightProducts.addProduct(new FlightTicketProduct("Boston", "Miami", "American Airlines", sdf.parse("2023-05-17"), "11:15 AM", "03:00 hrs", true, 150, 25));
            flightProducts.addProduct(new FlightTicketProduct("Denver", "Chicago", "United Airlines", sdf.parse("2023-05-18"), "1:45 PM", "02:30 hrs", true, 125, 40));
            flightProducts.addProduct(new FlightTicketProduct("Seattle", "Houston", "Delta Airlines", sdf.parse("2023-05-19"), "10:30 AM", "04:00 hrs", true, 225, 80));
            flightProducts.addProduct(new FlightTicketProduct("New York", "Los Angeles", "American Airlines", sdf.parse("2023-05-01"), "9:00 AM", "06:00 hrs", true, 255, 100));
            flightProducts.addProduct(new FlightTicketProduct("Chicago", "Miami", "Delta Airlines", sdf.parse("2023-05-02"), "11:30 AM", "03:30 hrs", false, 160, 50));
            flightProducts.addProduct(new FlightTicketProduct("Houston", "Denver", "United Airlines", sdf.parse("2023-05-03"), "3:00 PM", "03:00 hrs", true, 210, 75));
            flightProducts.addProduct(new FlightTicketProduct("San Francisco", "Seattle", "Alaska Airlines", sdf.parse("2023-05-04"), "10:00 AM", "02:00 hrs", true, 110, 30));
            flightProducts.addProduct(new FlightTicketProduct("Boston", "Washington DC", "JetBlue Airways", sdf.parse("2023-05-05"), "10:00 AM", "01:30 hrs", true, 90, 20));
            flightProducts.addProduct(new FlightTicketProduct("Los Angeles", "New York", "Delta Airlines", sdf.parse("2023-05-06"), "11:30 AM", "05:30 hrs", true, 400, 50));
            flightProducts.addProduct(new FlightTicketProduct("Miami", "Chicago", "American Airlines", sdf.parse("2023-05-07"), "8:45 AM", "03:30 hrs", true, 178, 40));
            flightProducts.addProduct(new FlightTicketProduct("Denver", "Houston", "Southwest Airlines", sdf.parse("2023-05-08"), "12:00 PM", "03:00 hrs", false, 185, 60));
            flightProducts.addProduct(new FlightTicketProduct("Seattle", "San Francisco", "Alaska Airlines", sdf.parse("2023-05-09"), "6:30 PM", "02:00 hrs", true, 180, 15));
            flightProducts.addProduct(new FlightTicketProduct("Washington DC", "Boston", "United Airlines", sdf.parse("2023-05-10"), "11:15 AM", "01:30 hrs", true, 190, 25));
            flightProducts.addProduct(new FlightTicketProduct("New York", "San Francisco", "American Airlines", sdf.parse("2023-05-11"), "7:40 AM", "07:00 hrs", true, 420, 50));
            flightProducts.addProduct(new FlightTicketProduct("Los Angeles", "Miami", "Delta Airlines", sdf.parse("2023-05-12"), "6:45 AM", "05:30 hrs", false, 277, 45));
            flightProducts.addProduct(new FlightTicketProduct("Houston", "Seattle", "United Airlines", sdf.parse("2023-05-13"), "12:00 AM", "05:00 hrs", true, 235, 70));
            flightProducts.addProduct(new FlightTicketProduct("Chicago", "Denver", "Southwest Airlines", sdf.parse("2023-05-14"), "12:00 PM", "02:30 hrs", true, 150, 30));
            flightProducts.addProduct(new FlightTicketProduct("San Francisco", "Boston", "JetBlue Airways", sdf.parse("2023-05-15"), "11:00 PM", "06:00 hrs", true, 300, 20));
            flightProducts.addProduct(new FlightTicketProduct("Washington DC", "Los Angeles", "United Airlines", sdf.parse("2023-05-16"), "6:30 AM", "06:00 hrs", true, 300, 60));
            flightProducts.addProduct(new FlightTicketProduct("Boston", "Miami", "American Airlines", sdf.parse("2023-05-17"), "11:25 AM", "03:00 hrs", true, 155, 25));
            flightProducts.addProduct(new FlightTicketProduct("Denver", "Chicago", "United Airlines", sdf.parse("2023-05-18"), "5:45 PM", "02:30 hrs", true, 225, 40));
            flightProducts.addProduct(new FlightTicketProduct("Seattle", "Houston", "Delta Airlines", sdf.parse("2023-05-19"), "11:30 AM", "04:00 hrs", true, 250, 80));

            // In Flight food Product
            ProductCatalog flightFoodProducts = foodServiceOrg.getProductCatalog();
            flightFoodProducts.addProduct(new FoodServiceProduct("Vegan", 30));
            flightFoodProducts.addProduct(new FoodServiceProduct("Non-veg", 40));

            // Hotel Room Products

            ProductCatalog hotelProducts = hotelOrg.getProductCatalog();
            hotelProducts.addProduct(new HotelRoomsProduct("Atlanta", "Standard Double", 150, 10));
            hotelProducts.addProduct(new HotelRoomsProduct("Austin", "Standard Double", 175, 20));
            hotelProducts.addProduct(new HotelRoomsProduct("Boston", "Deluxe Single", 175, 30));
            hotelProducts.addProduct(new HotelRoomsProduct("Chicago", "Standard Single", 100, 5));
            hotelProducts.addProduct(new HotelRoomsProduct("Denver", "Deluxe Suite", 375, 15));
            hotelProducts.addProduct(new HotelRoomsProduct("Houston", "Executive Suite", 500, 14));
            hotelProducts.addProduct(new HotelRoomsProduct("Las Vegas", "King Suite", 350, 14));
            hotelProducts.addProduct(new HotelRoomsProduct("Los Angeles", "Deluxe Suite", 400, 13));
            hotelProducts.addProduct(new HotelRoomsProduct("Miami", "King Suite", 300, 13));
            hotelProducts.addProduct(new HotelRoomsProduct("Nashville", "Standard Single", 80, 12));
            hotelProducts.addProduct(new HotelRoomsProduct("New Orleans", "Deluxe Suite", 400, 12));
            hotelProducts.addProduct(new HotelRoomsProduct("New York", "Standard Double", 150, 11));
            hotelProducts.addProduct(new HotelRoomsProduct("Orlando", "Standard Single", 100, 11));
            hotelProducts.addProduct(new HotelRoomsProduct("Philadelphia", "King Suite", 425, 10));
            hotelProducts.addProduct(new HotelRoomsProduct("Phoenix", "Standard Twin", 120, 10));
            hotelProducts.addProduct(new HotelRoomsProduct("Portland", "Executive Suite", 550, 9));
            hotelProducts.addProduct(new HotelRoomsProduct("San Antonio", "Deluxe Single", 300, 9));
            hotelProducts.addProduct(new HotelRoomsProduct("San Diego", "Deluxe Twin", 225, 8));
            hotelProducts.addProduct(new HotelRoomsProduct("San Francisco", "Standard Twin", 125, 8));
            hotelProducts.addProduct(new HotelRoomsProduct("Seattle", "Standard Double", 200, 7));
            hotelProducts.addProduct(new HotelRoomsProduct("Washington DC", "Deluxe Twin", 240, 7));
            hotelProducts.addProduct(new HotelRoomsProduct("Atlanta", "Standard Double", 250, 9));
            hotelProducts.addProduct(new HotelRoomsProduct("Austin", "Standard Double", 275, 24));
            hotelProducts.addProduct(new HotelRoomsProduct("Boston", "Deluxe Single", 115, 30));
            hotelProducts.addProduct(new HotelRoomsProduct("Chicago", "Standard Single", 140, 4));
            hotelProducts.addProduct(new HotelRoomsProduct("Denver", "Deluxe Suite", 315, 15));
            hotelProducts.addProduct(new HotelRoomsProduct("Houston", "Executive Suite", 510, 14));
            hotelProducts.addProduct(new HotelRoomsProduct("Las Vegas", "King Suite", 330, 14));
            hotelProducts.addProduct(new HotelRoomsProduct("Los Angeles", "Deluxe Suite", 460, 13));
            hotelProducts.addProduct(new HotelRoomsProduct("Miami", "King Suite", 360, 13));
            hotelProducts.addProduct(new HotelRoomsProduct("Nashville", "Standard Single", 70, 22));
            hotelProducts.addProduct(new HotelRoomsProduct("New Orleans", "Deluxe Suite", 300, 12));
            hotelProducts.addProduct(new HotelRoomsProduct("New York", "Standard Double", 200, 13));
            hotelProducts.addProduct(new HotelRoomsProduct("Orlando", "Standard Single", 150, 11));
            hotelProducts.addProduct(new HotelRoomsProduct("Philadelphia", "King Suite", 424, 16));
            hotelProducts.addProduct(new HotelRoomsProduct("Phoenix", "Standard Twin", 121, 10));
            hotelProducts.addProduct(new HotelRoomsProduct("Portland", "Executive Suite", 540, 9));
            hotelProducts.addProduct(new HotelRoomsProduct("San Antonio", "Deluxe Single", 310, 9));
            hotelProducts.addProduct(new HotelRoomsProduct("San Diego", "Deluxe Twin", 220, 8));
            hotelProducts.addProduct(new HotelRoomsProduct("San Francisco", "Standard Twin", 165, 8));
            hotelProducts.addProduct(new HotelRoomsProduct("Seattle", "Standard Double", 220, 7));
            hotelProducts.addProduct(new HotelRoomsProduct("Washington DC", "Deluxe Twin", 260, 4));

            //travel agency products

            ProductCatalog travelAgencyProducts = travelAgencyOrg.getProductCatalog();
            travelAgencyProducts.addProduct(new TravelAgencyProduct("Trip Consulting", 50));
            travelAgencyProducts.addProduct(new TravelAgencyProduct("Trip Booking", 100));

            //insurance products

            ProductCatalog insuranceProducts = insuranceOrg.getProductCatalog();
            insuranceProducts.addProduct(new InsuranceProduct("Full Coverage", 300));
            insuranceProducts.addProduct(new InsuranceProduct("Partial Coverage", 200));

            //Attraction products
            ProductCatalog attractionProducts = attractionOrg.getProductCatalog();
            attractionProducts.addProduct(new AttractionProduct("Boston","Theme Park Ticket", 120));
            attractionProducts.addProduct(new AttractionProduct("Boston","Museum Ticket", 100));
            attractionProducts.addProduct(new AttractionProduct("Boston","Adventure Ticket", 200));
            attractionProducts.addProduct(new AttractionProduct("New York","Theme Park Ticket", 120));
            attractionProducts.addProduct(new AttractionProduct("New York","Museum Ticket", 100));
            attractionProducts.addProduct(new AttractionProduct("New York","Adventure Ticket", 200));
            attractionProducts.addProduct(new AttractionProduct("Los Angeles","Theme Park Ticket", 120));
            attractionProducts.addProduct(new AttractionProduct("Los Angeles","Museum Ticket", 100));
            attractionProducts.addProduct(new AttractionProduct("Los Angeles","Adventure Ticket", 200));
            attractionProducts.addProduct(new AttractionProduct("Orlando","Theme Park Ticket", 120));
            attractionProducts.addProduct(new AttractionProduct("Orlando","Museum Ticket", 100));
            attractionProducts.addProduct(new AttractionProduct("Orlando","Adventure Ticket", 200));
            attractionProducts.addProduct(new AttractionProduct("Chicago","Theme Park Ticket", 120));
            attractionProducts.addProduct(new AttractionProduct("Chicago","Museum Ticket", 100));
            attractionProducts.addProduct(new AttractionProduct("Chicago","Adventure Ticket", 200));
            attractionProducts.addProduct(new AttractionProduct("Seattle","Theme Park Ticket", 120));
            attractionProducts.addProduct(new AttractionProduct("Seattle","Museum Ticket", 100));
            attractionProducts.addProduct(new AttractionProduct("Seattle","Adventure Ticket", 200));
            attractionProducts.addProduct(new AttractionProduct("Miami","Theme Park Ticket", 120));
            attractionProducts.addProduct(new AttractionProduct("Miami","Museum Ticket", 100));
            attractionProducts.addProduct(new AttractionProduct("Miami","Adventure Ticket", 200));


        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void generateFakeOrders(Customer c) throws ParseException{
        //create two orders for each of the four orgs

        ArrayList<Organization> orgs = new ArrayList<Organization>();
        orgs.add(airlineOrg);
        orgs.add(hotelOrg);
        orgs.add(travelAgencyOrg);
        orgs.add(attractionOrg);

        for (Organization o:orgs){
            int productIndex = 0;
            for (int i =0 ;i <2; i++){
                Order order =c.getCustomerOrderCatalog().createOrder(c);

                Product selectP = o.getProductCatalog().getProducts().get(productIndex);
                productIndex+=1;
                order.newOrderItem(selectP);

                if(o instanceof AirlineOrganization){
                    AirTicketWorkRequest airWR =  (AirTicketWorkRequest) order.getOrderWorkQueue().newAirTicketWorkRequest(order, c, c.getUserAccount(), this);
                    airWR.setNeedFood(true);
                    airWR.setIsVegan(false);

                    Order foodOrderSentToFS = o.getOrderCatalog().createOrder(order.getCustomer());

                    FoodServiceProduct foodSelected = (airWR.getIsVegan())? new FoodServiceProduct("Vegan",30):new FoodServiceProduct("Non-veg",40);
                    foodOrderSentToFS.newOrderItem(foodSelected);
                    FoodServiceWorkRequest foodwr = order.getOrderWorkQueue().newFoodServiceWorkRequest(foodOrderSentToFS,order.getCustomer(),this.getAirlineOrg().getUserAccountDirectory().findByUserName("airorgadmin"),this);

                    //link this request with customer's main flight order and request
                    foodwr.setCustomerFlightOrder(order);
                    foodwr.setCustomerFlightRequest(airWR);

                    airWR.setStatus("Making food reservation from food supplier");

                    order.setFlightOrderPriceWithFood(order.getOrderTotal());

                }else if(o instanceof TravelAgencyOrganization){
                    TripPlanningWorkRequest tripWR =  (TripPlanningWorkRequest) order.getOrderWorkQueue().newTripPlanningWorkRequest(order, c, c.getUserAccount(), this);
                    tripWR.setNeedBooking(true);
                    tripWR.setNeedAttractionTicket(false);
                    tripWR.setNeedInsurance(true);
                    tripWR.setIsFullCoverage(true);
                    tripWR.setDepCity("Chicago");
                    tripWR.setDesCity("Miami");
//                    try{
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        tripWR.setDepDate(sdf.parse("2023-05-02"));
//                    } catch (ParseException e) {
//                        e.printStackTrace();
//                    }


                    //create insurance request
                    Order insuranceOrderSentToIns = o.getOrderCatalog().createOrder(order.getCustomer());

                    InsuranceProduct insSelected = (tripWR.getIsFullCoverage())? new InsuranceProduct("Full Coverage", 300):new InsuranceProduct("Partial Coverage", 200);
                    insuranceOrderSentToIns.newOrderItem(insSelected);
                    InsuranceWorkRequest inswr = order.getOrderWorkQueue().newInsuranceWorkRequest(insuranceOrderSentToIns,order.getCustomer(),this.getTravelAgencyOrg().getUserAccountDirectory().findByUserName("travelorgadmin"),this);

                    //link this request with customer's main trip planning order and request
                    inswr.setCustomerTravelAgencyOrder(order);
                    inswr.setCustomerTripPlanningRequest(tripWR);

                    tripWR.setStatus("Making insurance request from insurance advisor");

                    order.setFlightOrderPriceWithFood(order.getOrderTotal());
                }
                else {
                    WorkRequest workReq = order.getOrderWorkQueue().newWorkRequest(order, c, c.getUserAccount(), this);
                    o.getWorkQueue().addWorkRequest(workReq);
                }
                //add the order to org's order list
                o.getOrderCatalog().getOrders().add(order);
            }
        }

    }

    public Organization findOrgByUserAccount(String username, String password){
        for (Enterprise en: this.getEnterpriseDirectory().getEnterpriseList()){
            for (Organization org: en.getOrganizationDirectory().getOrganizationList()){
                Boolean hasUserAtOrgLevel = org.getUserAccountDirectory().accountExists(username, password);
                    if(hasUserAtOrgLevel){
                        //org level user login
                        return org;
                    }
            }
        }
        return null;
    }

    public Enterprise findEnterpriseByUseraccount(String username, String password){
        for (Enterprise en: this.getEnterpriseDirectory().getEnterpriseList()){

                Boolean hasUserAtEntLevel = en.getUserAccountDirectory().accountExists(username, password);
                    if(hasUserAtEntLevel){
                        return en;
            }
        }
        return null;
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

    public Organization getAirlineOrg() {
        return airlineOrg;
    }

    public Organization getHotelOrg() {
        return hotelOrg;
    }

    public Organization getFoodServiceOrg() {
        return foodServiceOrg;
    }

    public Organization getTravelAgencyOrg() {
        return travelAgencyOrg;
    }

    public Organization getInsuranceOrg() {
        return insuranceOrg;
    }

    public Organization getAttractionOrg() {
        return attractionOrg;
    }


}
