/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI.EnterpriseAdminWorkArea;

import UI.SystemAdminWorkArea.*;
import Business.Customer.Customer;
import Business.Enterprise.Enterprise;
import Business.Organization.AirlineOrganization;
import Business.Organization.AttractionOrganization;
import Business.Organization.HotelOrganization;
import Business.Organization.Organization;
import Business.Organization.TravelAgencyOrganization;
import Business.Platform;
import Order.Order;
import UserAccount.UserAccount;
import WorkRequest.AirTicketWorkRequest;
import WorkRequest.AttractionBookingWorkRequest;
import WorkRequest.HotelBookingWorkRequest;
import WorkRequest.InsuranceWorkRequest;
import WorkRequest.WorkRequest;
import java.awt.BorderLayout;
import java.io.File;
import java.io.IOException;
import java.lang.System.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

/**
 *
 * @author emi
 */
public class ViewEntDataJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageEnterpriseJPanel
     */
    Platform platform;
    UserAccount ua;
    JPanel container;
    JFreeChart barChart;
    Enterprise enterprise;
    
    public ViewEntDataJPanel(JPanel container, Platform platform, UserAccount ua, Enterprise ent) {
        initComponents();
        this.setVisible(true);
        
        this.platform = platform; 
        this.container = container;
        this.ua = ua;
        this.enterprise = ent;
        populateOrganizationContri();
        
        revByEntBtn.setVisible(false);
    }
    
    public void populateOrganizationContri() {
        
        ArrayList<Order> workReqList = new ArrayList<>();
        Map<String, Integer> workReqMap = new HashMap<>();
        
                for(Organization organization:enterprise.getOrganizationDirectory().getOrganizationList()) {
                    
                    for (WorkRequest wr : organization.getWorkQueue().getWorkQueue()){
                
                        if (organization instanceof HotelOrganization) {
                            workReqList.add(wr.getOrder());
                        }
                        if (organization instanceof TravelAgencyOrganization) {
                            workReqList.add(wr.getOrder());
                        }
                        if (organization instanceof AirlineOrganization) {
                            workReqList.add(wr.getOrder());
                        }
                        if (organization instanceof AttractionOrganization) {
                            workReqList.add(wr.getOrder());
                        }
                        
                    }  
                    workReqMap.put(organization.getClass().getSimpleName(), workReqList.size());  
                }
        
        
      
        barChart = ChartFactory.createPieChart(
         "Orders split By Organization",                     
         createDataset(workReqMap),          
         true, true, false);
         
        ChartPanel chartPanel = new ChartPanel( barChart );  
        jPanel1.removeAll();
        jPanel1.add(chartPanel, BorderLayout.CENTER);
        jPanel1.validate();
        
    }
    
    private PieDataset createDataset(Map<String, Integer> workReqMap) {
       
        final DefaultPieDataset dataset = new DefaultPieDataset();  

        for(String r : workReqMap.keySet()) {
            dataset.setValue(r, workReqMap.get(r));
        }               

        return dataset; 
   }
    
    private CategoryDataset createBarDataset(ArrayList<String> en, ArrayList<Integer> er) {
       
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset( );  
        int i = 0;
        for(String e : en) {
            dataset.addValue(er.get(i),e,e);
            i++;
        }               
        
        return dataset; 
    }
    
    public void populateRevenueByOrg() {
        
        ArrayList<Integer> enterpriseRev = new ArrayList<Integer>();
                  ArrayList<String> enterpriseName = new ArrayList<String>();
            
           
//             
                for(Organization organization:enterprise.getOrganizationDirectory().getOrganizationList()) {

                        enterpriseName.add(organization.getClass().getSimpleName());
                        enterpriseRev.add(organization.getTotalRevenue());
                }      
        
      
        barChart = ChartFactory.createBarChart(
         "Revenue By Organization",           
         "Organizations",            
         "USD",            
         createBarDataset(enterpriseName, enterpriseRev),          
         PlotOrientation.VERTICAL,           
         true, true, false);
        
         
        ChartPanel chartPanel = new ChartPanel( barChart );  
        jPanel1.removeAll();
        jPanel1.add(chartPanel, BorderLayout.CENTER);
        jPanel1.validate();
        System.out.print(chartPanel);

    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        download = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        orgcontriBtn = new javax.swing.JButton();
        revByEntBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Combo Chart.png"))); // NOI18N

        download.setBackground(new java.awt.Color(255, 255, 255));
        download.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        download.setForeground(new java.awt.Color(25, 56, 82));
        download.setText("Download Graph");
        download.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downloadActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.setLayout(new java.awt.BorderLayout());

        orgcontriBtn.setBackground(new java.awt.Color(255, 255, 255));
        orgcontriBtn.setText("Organization Contribution");
        orgcontriBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orgcontriBtnActionPerformed(evt);
            }
        });

        revByEntBtn.setBackground(new java.awt.Color(255, 255, 255));
        revByEntBtn.setText("Revenue By Organization");
        revByEntBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                revByEntBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(revByEntBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(orgcontriBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(download, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(54, 54, 54)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 619, Short.MAX_VALUE)
                .addGap(51, 51, 51))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addComponent(download)
                .addGap(42, 42, 42)
                .addComponent(orgcontriBtn)
                .addGap(31, 31, 31)
                .addComponent(revByEntBtn)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(129, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void downloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downloadActionPerformed
        try {
            int width = 640;    /* Width of the image */
            int height = 480;   /* Height of the image */
            File BarChart = new File( "BarChart.jpeg" );
            ChartUtilities.saveChartAsJPEG( BarChart , barChart , width , height );
            JOptionPane.showMessageDialog(null, "A JPEG image file named BarChart.jpeg is downloaded in your current directory.");
        } catch (IOException ex) {
//            Logger.getLogger(NoOfScenesGraph.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_downloadActionPerformed

    private void orgcontriBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orgcontriBtnActionPerformed
        // TODO add your handling code here:
      
        populateOrganizationContri();
        
    }//GEN-LAST:event_orgcontriBtnActionPerformed

    private void revByEntBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_revByEntBtnActionPerformed
        // TODO add your handling code here:
        populateRevenueByOrg();
    }//GEN-LAST:event_revByEntBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton download;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton orgcontriBtn;
    private javax.swing.JButton revByEntBtn;
    // End of variables declaration//GEN-END:variables
}
