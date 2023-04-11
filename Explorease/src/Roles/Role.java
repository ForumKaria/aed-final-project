/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Roles;

import javax.swing.JPanel;

/**
 *
 * @author emi
 */
public abstract class Role {
        public enum Type {
        SystemAdmin("System Admin"),
        EnterpriseAdmin("Enterprise Admin"),
        OrganizationManager("Organization Manager"),
        AirlineAgent("Airline Agent"),
        FoodServiceSupplier("Food Service Supplier"),
        HotelAgent("Hotel Agent"),
        TravelAgencyAgent("Travel Agency Agent"),
        InsuranceAgent("Insurance Agent"),
        AttractionManager("Attraction Manager");
        
        
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

    
    public abstract JPanel createWorkArea();
}
