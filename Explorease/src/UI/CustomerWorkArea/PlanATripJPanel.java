/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI.CustomerWorkArea;

import Business.Customer.Customer;
import Business.Organization.Organization;
import Business.Platform;
import Business.Product.AttractionProduct;
import Business.Product.FlightTicketProduct;
import Business.Product.HotelRoomsProduct;
import Business.Product.Product;
import Business.Product.TravelAgencyProduct;
import Order.Order;
import UserAccount.UserAccount;
import Validation.VerifyNull;
import WorkRequest.TripPlanningWorkRequest;
import WorkRequest.AirTicketWorkRequest;
import WorkRequest.WorkRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author emi
 */
public class PlanATripJPanel extends javax.swing.JPanel {

    /**
     * Creates new form BookFlightJPanel
     */
    Platform platform;
    UserAccount ua;
    JPanel container;
    DefaultTableModel resultTable;
    Organization org;
    Customer cus;

    ArrayList<TripPlanningWorkRequest> plannedTrip;
    TripPlanningWorkRequest trp;
    TravelAgencyProduct productSelected;

    public PlanATripJPanel(JPanel container, Platform platform, UserAccount ua) {
        
        initComponents();
        this.platform = platform;
        this.container = container;
        this.ua = ua;
        this.org = this.platform.getTravelAgencyOrg();
        this.resultTable = (DefaultTableModel) plannedTrips.getModel();
        this.cus = this.platform.getCustomerDirectory().findCustomerById(ua.getAccountId());

        this.plannedTrip = this.cus.getPlannedTrips(); // array list of products to populate in table
        populatePlannedTrips();
        
    }

    private void populatePlannedTrips() {
        resultTable.setRowCount(0);
        if (plannedTrip.size() > 0) {
            for (TripPlanningWorkRequest tpWorkRequest : plannedTrip) {
                if(tpWorkRequest.getPlannedTrip().size()>0){
                    Object[] row = new Object[11];
                    row[0] = tpWorkRequest;
                    ArrayList<Product> proudcts = tpWorkRequest.getPlannedTrip();
                    for (Product p : proudcts) {
                        if(p!=null){
                            
//                            row[0] = tpWorkRequest;
                            //check product type
                            if ( p.getProductDetails() instanceof FlightTicketProduct){
                                FlightTicketProduct ff = (FlightTicketProduct) p.getProductDetails();
                                row[1] = ff.getProductId();
                                row[2] = ff.getAirline();
                                row[3] = ff.getDepartureCity();
                                row[4] = ff.getDestinationCity();
                                row[5] = new SimpleDateFormat("yyyy-MM-dd").format(ff.getDepartureDate());
                                row[6] = ff.getPrice(); //onw way price
//                                System.out.println("added a flight");
                            }
                            if (p.getProductDetails() instanceof HotelRoomsProduct){
                                HotelRoomsProduct hotelP = (HotelRoomsProduct) p.getProductDetails();
                                row[7] = hotelP.getProductId(); //hotel product id
                                row[8] = hotelP.getPrice(); //hotel price, default to 1 night
//                                System.out.println("added a hotel");
                            }
                            if (p.getProductDetails() instanceof AttractionProduct){
                                AttractionProduct attP = (AttractionProduct) p.getProductDetails();
                                row[9] = attP.getTicketType();
                                row[10] = attP.getPrice(); 
//                                System.out.println("added a att");
                            }
                            
                            
                        }
                        
                        
                    }
                    resultTable.addRow(row);
//                    System.out.println("added one row");
                
                }
                
                
            }
        }
    }
        /**
         * This method is called from within the constructor to initialize the
         * form. WARNING: Do NOT modify this code. The content of this method is
         * always regenerated by the Form Editor.
         */
        @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        desCity = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        planBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        plannedTrips = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        bookBtn = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        getAtt = new javax.swing.JCheckBox();
        confirmBtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        depCity = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        insurCombo = new javax.swing.JComboBox<>();
        depDate = new com.toedter.calendar.JDateChooser();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1100, 800));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Time to leave?");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 130, -1, -1));
        add(desCity, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 200, -1));

        jLabel3.setText("Trip Details");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 320, -1, -1));

        planBtn.setText("Plan My Trip");
        planBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                planBtnActionPerformed(evt);
            }
        });
        add(planBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 130, 110, -1));

        plannedTrips.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "WorkRequest ID", "Flight ID", "Airline", "Departure Date", "Destination", "Date", "Flight Price", "Hotel ID", "Hotel Price", "Attraction Ticket", "Attraction Price"
            }
        ));
        plannedTrips.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                plannedTripsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(plannedTrips);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 360, 940, 240));

        jLabel6.setText("Total Budget");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 320, -1, 20));

        jTextField4.setEditable(false);
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 320, 105, -1));

        bookBtn.setText("Book My Trip");
        bookBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookBtnActionPerformed(evt);
            }
        });
        add(bookBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 180, 110, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/planATrip_128px.png"))); // NOI18N
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 30, 138, 136));

        getAtt.setText("Get attraction ticket for my trip");
        getAtt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getAttActionPerformed(evt);
            }
        });
        add(getAtt, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 210, -1));

        confirmBtn.setText("Confirm Budget");
        confirmBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmBtnActionPerformed(evt);
            }
        });
        add(confirmBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 320, -1, -1));

        jLabel4.setText("Where will you departure from?");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 70, -1, -1));
        add(depCity, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 200, -1));

        jLabel10.setText("Destination in mind?");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, -1, -1));

        insurCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No insurance selected", "Get full insurance coverage for my trip", "Get partial insurance coverage for my trip" }));
        add(insurCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, 200, -1));
        add(depDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 200, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void planBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_planBtnActionPerformed
        // TODO add your handling code here:
        resultTable.setRowCount(0);
        
        this.productSelected = (TravelAgencyProduct) this.org.getProductCatalog().getProducts().get(0);
            
        String dep = depCity.getText();
        String des = desCity.getText();
        Date date = depDate.getDate();
        Boolean getInsurance = (insurCombo.getSelectedIndex()!=0)? true: false;
        Boolean getFullCoverage = (insurCombo.getSelectedIndex()==1)? true: false;
        Boolean getAttractionTicket = getAtt.isSelected();

        VerifyNull checkNull = new VerifyNull();
        boolean nonull = checkNull.checkNullObject(dep,des,date);

        if(nonull){
            Order o = this.cus.getCustomerOrderCatalog().createOrder(cus);
            o.newOrderItem(productSelected);
            TripPlanningWorkRequest travelAgencyWR = o.getOrderWorkQueue().newTripPlanningWorkRequest(o, this.cus, this.cus.getUserAccount(), this.platform);

            //prepare complimentary product info to plan the trip
            travelAgencyWR.setDepCity(dep);
            travelAgencyWR.setDesCity(des);
            travelAgencyWR.setDepDate(date);
            travelAgencyWR.setNeedInsurance(getInsurance);
            travelAgencyWR.setIsFullCoverage(getFullCoverage);
            travelAgencyWR.setNeedAttractionTicket(getAttractionTicket);
            travelAgencyWR.setNeedBooking(false);

            JOptionPane.showMessageDialog(null, "Request Sent");
        }
//        else{
//             JOptionPane.showMessageDialog(null, "Please fill in necessary information for your desired trip"); //pop up msg already written in check null method
//        }
    }//GEN-LAST:event_planBtnActionPerformed

    private void bookBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookBtnActionPerformed
        // TODO add your handling code here:

        resultTable.setRowCount(0);

        this.productSelected = (TravelAgencyProduct) this.org.getProductCatalog().getProducts().get(1);

        String dep = depCity.getText();
        String des = desCity.getText();
        Date date = depDate.getDate();
        Boolean getInsurance = (insurCombo.getSelectedIndex()!=0)? true: false;
        Boolean getFullCoverage = (insurCombo.getSelectedIndex()==1)? true: false;
        Boolean getAttractionTicket = getAtt.isSelected();

        VerifyNull checkNull = new VerifyNull();
        boolean nonull = checkNull.checkNullObject(dep,des,date);

        if(nonull){
            Order o = this.cus.getCustomerOrderCatalog().createOrder(cus);
            o.newOrderItem(productSelected);
            TripPlanningWorkRequest travelAgencyWR = o.getOrderWorkQueue().newTripPlanningWorkRequest(o, this.cus, this.cus.getUserAccount(), this.platform);

            //prepare complimentary product info to plan the trip
            travelAgencyWR.setDepCity(dep);
            travelAgencyWR.setDesCity(des);
            travelAgencyWR.setDepDate(date);
            travelAgencyWR.setNeedInsurance(getInsurance);
            travelAgencyWR.setIsFullCoverage(getFullCoverage);
            travelAgencyWR.setNeedAttractionTicket(getAttractionTicket);
            travelAgencyWR.setNeedBooking(true);

            JOptionPane.showMessageDialog(null, "Request Sent");
        }
//        else{
//             JOptionPane.showMessageDialog(null, "Please fill in necessary information for your desired trip");
//        }

    }//GEN-LAST:event_bookBtnActionPerformed

    private void getAttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getAttActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_getAttActionPerformed

    private void confirmBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmBtnActionPerformed
        // TODO add your handling code here:
        //select a row from result table, check if it's a booking request, then set the confirmToBook to true
        int selectedRow = plannedTrips.getSelectedRow();
        if(selectedRow>=0){

        WorkRequest wr = (WorkRequest) plannedTrips.getValueAt(selectedRow, 0);
        if(wr!=null){
        this.trp = (TripPlanningWorkRequest) wr;
        this.trp.setConfirmedToBook(true);
        JOptionPane.showMessageDialog(null, "Confirmed to make bookings");
        } else {
            JOptionPane.showMessageDialog(null, "Select a plan!");
        }
        }
    }//GEN-LAST:event_confirmBtnActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:

        
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void plannedTripsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_plannedTripsMouseClicked
        // TODO add your handling code here:
        int selectedRow;
        selectedRow = plannedTrips.getSelectedRow();
        
        
        
        
        int totalbudget = 0;
        Boolean value1 = plannedTrips.getValueAt(selectedRow, 6)==null;
        Boolean value2 = plannedTrips.getValueAt(selectedRow, 8)==null;
        Boolean value3 = plannedTrips.getValueAt(selectedRow, 10)==null;
        if (!value1){
            int flightPrice = (int) plannedTrips.getValueAt(selectedRow, 6);
            totalbudget=totalbudget+flightPrice;
        }
        if(!value2){
            int hotelPrice = (int) plannedTrips.getValueAt(selectedRow, 8);
            totalbudget=totalbudget+hotelPrice;
        }
        if(!value3){
            int attPrice = (int) plannedTrips.getValueAt(selectedRow, 10);
            totalbudget=totalbudget+attPrice;
        }
        
        jTextField4.setText(String.valueOf(totalbudget));
    }//GEN-LAST:event_plannedTripsMouseClicked



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bookBtn;
    private javax.swing.JButton confirmBtn;
    private javax.swing.JTextField depCity;
    private com.toedter.calendar.JDateChooser depDate;
    private javax.swing.JTextField desCity;
    private javax.swing.JCheckBox getAtt;
    private javax.swing.JComboBox<String> insurCombo;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JButton planBtn;
    private javax.swing.JTable plannedTrips;
    // End of variables declaration//GEN-END:variables

}
