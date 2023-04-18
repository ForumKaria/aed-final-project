/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Roles;

import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Platform;
import UI.EnterpriseAdminWorkArea.EnterpriseAdminWorkAreaJPanel;
import UI.ManagerWorkArea.AirlineManagerEmployeeWorkArea;
import UI.SystemAdminWorkArea.SystemAdminWorkAreaJPanel;
import UserAccount.UserAccount;
import javax.swing.JPanel;

/**
 *
 * @author emi
 */
public class EnterpriseAdminRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel container, UserAccount ua, Platform platform, Enterprise enterprise, Organization organization) {
        if(ua.getUsername().equals("airadmin")){
           return new AirlineManagerEmployeeWorkArea(container, enterprise, ua);
        }
//        else if(ua.getUsername().equals("attractionadmin")){
//          return new EnterpriseAdminWorkAreaJPanel(container, ua, platform, enterprise);
//        }
        else{
               return new EnterpriseAdminWorkAreaJPanel(container, ua, platform, enterprise);
            }
        }
    }
