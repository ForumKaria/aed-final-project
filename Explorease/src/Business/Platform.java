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
import Order.OrderReport;
import Person.PersonDirectory;
import Roles.EnterpriseAdminRole;
import Roles.SystemAdminRole;
import UserAccount.UserAccount;
import UserAccount.UserAccountDirectory;

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
