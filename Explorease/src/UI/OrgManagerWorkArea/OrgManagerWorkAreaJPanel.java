/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI.OrgManagerWorkArea;

import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import UI.SystemAdminWorkArea.*;
import Business.Platform;
import UserAccount.UserAccount;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author emi
 */
public class OrgManagerWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form SystemAdminWorkArea
     */
    Platform platform;
    UserAccount ua;
    JPanel container;
    Enterprise enterprise;
    Organization org;

    public OrgManagerWorkAreaJPanel(JPanel container, Enterprise enterprise, UserAccount ua ,Platform platform) {
        initComponents();
        this.setVisible(true);
        this.platform = platform;
        this.ua = ua;
        this.org = this.platform.findOrgByUserAccount(ua.getUsername(), ua.getPassword());
        this.container = container;
        
        manageEmployeeBtn.setVisible(false);
        manageOrders();

    }


    public void manageEmployee(){
        //to do: delete manage employee panel, org emloyees will be visible to its enterprise admin
        JPanel manageEmployeeJPanel = new ManageOrgEmployeeWorkArea(platform,container,  ua);
        workArea.add(manageEmployeeJPanel);
        CardLayout layout = (CardLayout) workArea.getLayout();
        layout.next(workArea);
    }

    public void manageProduct(){
        if (this.org==this.platform.getAirlineOrg()){
            JPanel manageProductJPanel = new AirlineManagerProductWorkArea( platform,  container,  ua);
            workArea.add(manageProductJPanel);
            CardLayout layout = (CardLayout) workArea.getLayout();
            layout.next(workArea);
        }
        else if (this.org==this.platform.getHotelOrg()){
            JPanel manageProductJPanel = new HotelManagerProductWorkArea( platform,  container,  ua);
            workArea.add(manageProductJPanel);
            CardLayout layout = (CardLayout) workArea.getLayout();
            layout.next(workArea);
        }
        //to do: create product panels for food,travel agency,insurance orgs
        else if (this.org==this.platform.getFoodServiceOrg()){
            JPanel manageProductJPanel = new FoodManagerProductWorkArea( platform,  container,  ua);
            workArea.add(manageProductJPanel);
            CardLayout layout = (CardLayout) workArea.getLayout();
            layout.next(workArea);
        }
        else if (this.org==this.platform.getTravelAgencyOrg()){
            JPanel manageProductJPanel = new TravelAgencyProductWorkArea(platform,  container,  ua);
            workArea.add(manageProductJPanel);
            CardLayout layout = (CardLayout) workArea.getLayout();
            layout.next(workArea);
        }
        else if (this.org==this.platform.getInsuranceOrg()){
            JPanel manageProductJPanel = new InsuranceProductManagerWorkArea(platform,  container,  ua);
            workArea.add(manageProductJPanel);
            CardLayout layout = (CardLayout) workArea.getLayout();
            layout.next(workArea);
        }
        else if (this.org==this.platform.getAttractionOrg()){
            JPanel manageProductJPanel = new AttractionManagerProductWorkArea( platform,  container,  ua);
            workArea.add(manageProductJPanel);
            CardLayout layout = (CardLayout) workArea.getLayout();
            layout.next(workArea);
        }
    }

    public void manageOrders(){
        if (this.org==this.platform.getAirlineOrg()){
            JPanel manageOrderJPanel = new AirlineOrgManagerAllOrdersWorkArea( platform,  container,  ua);
            workArea.add(manageOrderJPanel);
            CardLayout layout = (CardLayout) workArea.getLayout();
            layout.next(workArea);
        }
        else if (this.org==this.platform.getHotelOrg()){
            JPanel manageOrderJPanel = new HotelOrgManagerAllOrdersWorkArea( platform,  container,  ua);
            workArea.add(manageOrderJPanel);
            CardLayout layout = (CardLayout) workArea.getLayout();
            layout.next(workArea);
        }

        else if (this.org==this.platform.getFoodServiceOrg()){
            JPanel manageProductJPanel = new FoodOrgManagerAllOrdersWorkArea( platform,  container,  ua);
            workArea.add(manageProductJPanel);
            CardLayout layout = (CardLayout) workArea.getLayout();
            layout.next(workArea);
        }
        else if (this.org==this.platform.getTravelAgencyOrg()){

            JPanel manageProductJPanel = new TravelAgencyOrgManagerAllOrdersWorkArea( platform,  container,  ua);

            workArea.add(manageProductJPanel);
            CardLayout layout = (CardLayout) workArea.getLayout();
            layout.next(workArea);
        }
        else if (this.org==this.platform.getInsuranceOrg()){

            JPanel manageProductJPanel = new InsuranceOrgManagerAllOrdersWorkArea( platform,  container,  ua);

            workArea.add(manageProductJPanel);
            CardLayout layout = (CardLayout) workArea.getLayout();
            layout.next(workArea);
        }
        else if (this.org==this.platform.getAttractionOrg()){
            JPanel manageProductJPanel = new AttractionOrgManagerAllOrdersWorkArea( platform,  container,  ua);
            workArea.add(manageProductJPanel);
            CardLayout layout = (CardLayout) workArea.getLayout();
            layout.next(workArea);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        airlineOrgManagerPanel = new javax.swing.JPanel();
        toolBar = new javax.swing.JPanel();
        manageEmployeeBtn = new javax.swing.JButton();
        productBtn = new javax.swing.JButton();
        orderBtn = new javax.swing.JButton();
        workArea = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1300, 800));
        setRequestFocusEnabled(false);
        setLayout(new java.awt.BorderLayout());

        airlineOrgManagerPanel.setPreferredSize(new java.awt.Dimension(1300, 800));

        toolBar.setBackground(new java.awt.Color(61, 69, 100));
        toolBar.setPreferredSize(new java.awt.Dimension(200, 168));

        manageEmployeeBtn.setBackground(new java.awt.Color(8, 57, 97));
        manageEmployeeBtn.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        manageEmployeeBtn.setForeground(new java.awt.Color(255, 255, 255));
        manageEmployeeBtn.setText("Manage Employees");
        manageEmployeeBtn.setContentAreaFilled(false);
        manageEmployeeBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        manageEmployeeBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        manageEmployeeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageEmployeeBtnActionPerformed(evt);
            }
        });

        productBtn.setBackground(new java.awt.Color(8, 57, 97));
        productBtn.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        productBtn.setForeground(new java.awt.Color(255, 255, 255));
        productBtn.setText("Manage Products");
        productBtn.setContentAreaFilled(false);
        productBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        productBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        productBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productBtnActionPerformed(evt);
            }
        });

        orderBtn.setBackground(new java.awt.Color(8, 57, 97));
        orderBtn.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        orderBtn.setForeground(new java.awt.Color(255, 255, 255));
        orderBtn.setText("Work Queue");
        orderBtn.setContentAreaFilled(false);
        orderBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        orderBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        orderBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout toolBarLayout = new javax.swing.GroupLayout(toolBar);
        toolBar.setLayout(toolBarLayout);
        toolBarLayout.setHorizontalGroup(
            toolBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, toolBarLayout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addGroup(toolBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(manageEmployeeBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(productBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(orderBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(14, 14, 14))
        );
        toolBarLayout.setVerticalGroup(
            toolBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(toolBarLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(manageEmployeeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(productBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(orderBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        workArea.setDoubleBuffered(false);
        workArea.setPreferredSize(new java.awt.Dimension(1100, 800));
        workArea.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout airlineOrgManagerPanelLayout = new javax.swing.GroupLayout(airlineOrgManagerPanel);
        airlineOrgManagerPanel.setLayout(airlineOrgManagerPanelLayout);
        airlineOrgManagerPanelLayout.setHorizontalGroup(
            airlineOrgManagerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(airlineOrgManagerPanelLayout.createSequentialGroup()
                .addComponent(toolBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(workArea, javax.swing.GroupLayout.PREFERRED_SIZE, 1110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        airlineOrgManagerPanelLayout.setVerticalGroup(
            airlineOrgManagerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(toolBar, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
            .addComponent(workArea, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        add(airlineOrgManagerPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void manageEmployeeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageEmployeeBtnActionPerformed
        // TODO add your handling code here:
        manageEmployee();
    }//GEN-LAST:event_manageEmployeeBtnActionPerformed

    private void productBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productBtnActionPerformed
        // TODO add your handling code here:
        manageProduct();
    }//GEN-LAST:event_productBtnActionPerformed

    private void orderBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderBtnActionPerformed
        // TODO add your handling code here:
        manageOrders();
    }//GEN-LAST:event_orderBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel airlineOrgManagerPanel;
    private javax.swing.JButton manageEmployeeBtn;
    private javax.swing.JButton orderBtn;
    private javax.swing.JButton productBtn;
    private javax.swing.JPanel toolBar;
    private javax.swing.JPanel workArea;
    // End of variables declaration//GEN-END:variables
}
