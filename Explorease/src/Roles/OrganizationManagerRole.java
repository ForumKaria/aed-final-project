/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Roles;

import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Platform;
import UI.AirlineOrgManagerWorkArea.AirlineOrgMangerWorkAreaJPanel;
import UserAccount.UserAccount;
import javax.swing.JPanel;

/**
 *
 * @author emi
 */
public class OrganizationManagerRole extends Role{

    @Override
    public JPanel createWorkArea( JPanel container,  UserAccount ua, Platform platform,Enterprise enterprise, Organization organization) {
        return new AirlineOrgMangerWorkAreaJPanel(container,platform,ua,enterprise);
        //add if stats for other org manager
    }
}
