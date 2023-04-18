package Business.Enterprise;

import Business.Organization.OrganizationDirectory;
import UserAccount.UserAccountDirectory;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author emi
 */
public abstract class Enterprise {
    static int counter = 1;
    String enterpriseId;
    OrganizationDirectory organizationDirectory;
    UserAccountDirectory userAccountDirectory;
    
    public Enterprise(){

        this.enterpriseId = "enterprise" + this.counter++;
        this.organizationDirectory = new OrganizationDirectory();
        this.userAccountDirectory = new UserAccountDirectory();
    }
    
    public enum EnterpriseType {
        Transportation("Transportation Enterprise"),
        Hotel("Hotel Enterprise"),
        TravelAgency("TravelAgency Enterprise"),
        Attraction("Attraction Enterprise");
        
        private String type;

        private EnterpriseType(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }


        @Override
        public String toString() {
            return type;
        }
    }

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public OrganizationDirectory getOrganizationDirectory() {
        return organizationDirectory;
    }

    public void setOrganizationDirectory(OrganizationDirectory organizationDirectory) {
        this.organizationDirectory = organizationDirectory;
    }

    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public void setUserAccountDirectory(UserAccountDirectory userAccountDirectory) {
        this.userAccountDirectory = userAccountDirectory;
    }

}
