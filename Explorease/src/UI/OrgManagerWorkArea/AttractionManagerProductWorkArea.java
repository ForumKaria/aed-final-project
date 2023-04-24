package UI.OrgManagerWorkArea;
import Business.Organization.Organization;
import Business.Platform;
import Business.Product.AttractionProduct;
import Business.Product.FlightTicketProduct;
import Business.Product.HotelRoomsProduct;
import Business.Product.Product;
import UserAccount.UserAccount;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author 15512
 */
public class AttractionManagerProductWorkArea extends javax.swing.JPanel {

    /**
     * Creates new form AirlineManagerWorkArea
     */
    
    Platform platform;
    UserAccount ua;
    JPanel container;
    Organization org;
    DefaultTableModel prodTable;

    public AttractionManagerProductWorkArea(Platform platform,JPanel container, UserAccount ua) {
        initComponents();
        this.platform = platform; 
        this.container = container;
        this.ua = ua;
        this.org = platform.findOrgByUserAccount(ua.getUsername(), ua.getPassword());
        this.prodTable = (DefaultTableModel) products.getModel();
        populateTickets();
    }

     public void populateTickets() {
        prodTable.setRowCount(0);

        ArrayList<Product> products = this.org.getProductCatalog().getProducts();

        if (products.size() > 0) {
            for (Product p : products) {
                AttractionProduct f = (AttractionProduct) p.getProductDetails();
                Object[] row = new Object[4];
                row[0] = f;
                row[1] = f.getCity();
                row[2] = f.getTicketType();
                row[3] = f.getPrice();
                prodTable.addRow(row);
            }
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        products = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        desCity = new javax.swing.JTextField();
        select = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        price = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        ticket = new javax.swing.JTextField();
        bgPanel = new javax.swing.JPanel();
        bgImageLabel = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        setPreferredSize(new java.awt.Dimension(1300, 553));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        products.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Product ID", "City", "Ticket Type", "Price"
            }
        ));
        jScrollPane2.setViewportView(products);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, 620, 280));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("TOURIST ATTRACTION TICKET MANAGEMENT\n");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 90, 340, -1));

        jButton4.setText("Remove Ticket");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 390, 150, -1));

        desCity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                desCityActionPerformed(evt);
            }
        });
        add(desCity, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 200, 150, -1));

        select.setText("Select Ticket");
        select.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectActionPerformed(evt);
            }
        });
        add(select, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 130, 150, 30));

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel4.setText("City");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(895, 180, 50, -1));

        jLabel7.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel7.setText("Price");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 290, 40, 20));

        jLabel9.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel9.setText("Ticket Type");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(893, 236, 100, 20));

        price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceActionPerformed(evt);
            }
        });
        add(price, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 310, 150, -1));

        jButton6.setText("Update Ticket");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 350, 150, -1));

        ticket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ticketActionPerformed(evt);
            }
        });
        add(ticket, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 260, 150, -1));

        bgPanel.setPreferredSize(new java.awt.Dimension(1300, 870));
        bgPanel.setLayout(new java.awt.BorderLayout());

        bgImageLabel.setBackground(new java.awt.Color(204, 204, 255));
        bgImageLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/david-trana-mmdchg5UPtQ-unsplash.jpg"))); // NOI18N
        bgImageLabel.setMaximumSize(new java.awt.Dimension(1300, 870));
        bgImageLabel.setMinimumSize(new java.awt.Dimension(1300, 870));
        bgImageLabel.setPreferredSize(new java.awt.Dimension(1300, 870));
        bgPanel.add(bgImageLabel, java.awt.BorderLayout.CENTER);

        add(bgPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1170, 740));
    }// </editor-fold>//GEN-END:initComponents

    private void desCityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_desCityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_desCityActionPerformed

    private void priceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceActionPerformed

    private void selectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectActionPerformed
        // TODO add your handling code here:
        int selectedRow = products.getSelectedRow();
        AttractionProduct f = (AttractionProduct) prodTable.getValueAt(selectedRow, 0);
        desCity.setText(f.getCity());
        ticket.setText(f.getTicketType());     
        price.setText(String.valueOf(f.getPrice()));
    }//GEN-LAST:event_selectActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        int selectedRow = products.getSelectedRow();
        AttractionProduct f = (AttractionProduct) prodTable.getValueAt(selectedRow, 0);
        
        f.setCity(desCity.getText());
        f.setTicketType(ticket.getText());
        f.setPrice(Integer.valueOf(price.getText()));
        populateTickets();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        int selectedRow = products.getSelectedRow();
        AttractionProduct f = (AttractionProduct) prodTable.getValueAt(selectedRow, 0);
        this.org.getProductCatalog().getProducts().remove(f);
        populateTickets();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void ticketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ticketActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ticketActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bgImageLabel;
    private javax.swing.JPanel bgPanel;
    private javax.swing.JTextField desCity;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField price;
    private javax.swing.JTable products;
    private javax.swing.JButton select;
    private javax.swing.JTextField ticket;
    // End of variables declaration//GEN-END:variables

}
