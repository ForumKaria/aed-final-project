/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Organization;

import Business.Organization.Organization.OrganizationType;
import static Business.Organization.Organization.OrganizationType.AirlineOrg;
import static Business.Organization.Organization.OrganizationType.AttractionOrg;
import static Business.Organization.Organization.OrganizationType.FoodServiceOrg;
import static Business.Organization.Organization.OrganizationType.InsuranceOrg;
import static Business.Organization.Organization.OrganizationType.TravelAgencyOrg;
import static Business.Organization.Organization.OrganizationType.HotelOrg;
import UserAccount.UserAccount;
import java.util.ArrayList;

/**
 *
 * @author emi
 */
public class OrganizationDirectory {

    ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        this.organizationList = new ArrayList<Organization>();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }

    public Organization findOrganization(String orgId) {
        for (Organization organization : organizationList) {
            if (organization.getOrganizationId().equals(orgId)) {
                return organization;
            }
        }
        return null;
    }

    public Boolean checkUsernameUniqueAcrossOrgs(String username) {
        for (Organization organization : organizationList) {
            for (UserAccount u : organization.getUserAccountDirectory().getUseraccountList()) {
                if (u.getUsername().equals(username)) {
                    return false;
                }
            }
//            return true;
        }
        return true;
    }

    public Organization findOrganizationByType(String orgType) {
        for (Organization organization : organizationList) {
            if (organization.getClass().getSimpleName().equals(orgType)) {
                return organization;
            }
        }
        return null;
    }

    public Organization createOrganization(OrganizationType type) {
        Organization org;

        if (null != type) {
            switch (type) {
                case AirlineOrg:
                    org = new AirlineOrganization();
                    organizationList.add(org);
                    return org;
                case FoodServiceOrg:
                    org = new FoodServicesOrganization();
                    organizationList.add(org);
                    return org;
                case HotelOrg:
                    org = new HotelOrganization();
                    organizationList.add(org);
                    return org;
                case TravelAgencyOrg:
                    org = new TravelAgencyOrganization();
                    organizationList.add(org);
                    return org;
                case InsuranceOrg:
                    org = new InsuranceOrganization();
                    organizationList.add(org);
                    return org;
                case AttractionOrg:
                    org = new AttractionOrganization();
                    organizationList.add(org);
                    return org;
                default:
                    break;
            }
        }

        return null;
    }
}
