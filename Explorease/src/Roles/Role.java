/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Roles;

import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Platform;
import UserAccount.UserAccount;
import javax.swing.JPanel;

/**
 *
 * @author emi
 */
public abstract class Role {
        public enum Type {
        SystemAdminRole("System Admin"),
        EnterpriseAdminRole("Enterprise Admin"),
        OrganizationManagerRole("Organization Manager"),
        AirlineAgentRole("Airline Agent"),
        FoodServiceSupplierRole("Food Service Supplier"),
        HotelAgentRole("Hotel Agent"),
        TravelAgencyAgentRole("Travel Agency Agent"),
        InsuranceAgentRole("Insurance Agent"),
        AttractionManagerRole("Attraction Manager");
        
        
        private String value;

        private Type(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    
    public abstract JPanel createWorkArea( JPanel container,  UserAccount ua, Platform platform,Enterprise enterprise, Organization organization);
    
    @Override
    public String toString() {
        return this.getClass().getName();
    }
}
