/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Enterprise;

import Business.Enterprise.Enterprise.EnterpriseType;
import Business.Organization.Organization;
import UserAccount.UserAccount;
import java.util.ArrayList;

/**
 *
 * @author emi
 */
public class EnterpriseDirectory {
    private ArrayList<Enterprise> enterpriseList;
    
    public EnterpriseDirectory(){
        this.enterpriseList = new ArrayList<Enterprise>();
    }

    public ArrayList<Enterprise> getEnterpriseList() {
        return enterpriseList;
    }
    
    public Enterprise findEnterprise(String entId){
        for (Enterprise enterprise : enterpriseList) {
            if(enterprise.getEnterpriseId().equals(entId)){
                return enterprise;
            }
        }
        return null;
    }
    
    public Enterprise findEnterpriseByType(String type){
        for (Enterprise enterprise : enterpriseList) {
            if(enterprise.getClass().getSimpleName().equals(type)){
                return enterprise;
            }
        }
        return null;
    }
    
    public Enterprise createEnterprise(EnterpriseType type){
        Enterprise enterprise;
        
        if(null != type) switch (type) {
            case Transportation:
                enterprise = new TransportationEnterprise();
                enterpriseList.add(enterprise);
                return enterprise;
            case Hotel:
                enterprise = new HotelEnterprise();
                enterpriseList.add(enterprise);
                return enterprise;
            case TravelAgency:
                enterprise = new TravelAgencyEnterprise();
                enterpriseList.add(enterprise);
                return enterprise;
            case Attraction:
                enterprise = new AttractionEnterprise();
                enterpriseList.add(enterprise);
                return enterprise;
            default:
                break;
        }
        
        return null;
        
//                if(type == EnterpriseType.Transportation) {
//            enterprise = new TransportationEnterprise();
//            enterpriseList.add(enterprise);
//            return enterprise;     
//        }else if(type == EnterpriseType.Hotel){
//            enterprise = new HotelEnterprise();
//            enterpriseList.add(enterprise);
//            return enterprise;     
//        }else if(type == EnterpriseType.TravelAgency){
//            enterprise = new TravelAgencyEnterprise();
//            enterpriseList.add(enterprise);
//            return enterprise;     
//        }else if(type == EnterpriseType.Attraction){
//            enterprise = new AttractionEnterprise();
//            enterpriseList.add(enterprise);
//            return enterprise;
//        }
//        
//        return null;
    }
    
    public Boolean checkUsernameUniqueAcrossEnts(String username) {
        for (Enterprise en : this.enterpriseList) {
            for (UserAccount u : en.getUserAccountDirectory().getUseraccountList()) {
                if (u.getUsername().equals(username)) {
                    return false;
                }
            }
//            return true;
        }
//        return null;
        return true;
    }
    
}
