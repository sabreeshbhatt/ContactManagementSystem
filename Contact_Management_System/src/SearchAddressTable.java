
import javax.swing.JOptionPane;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SearchAddressTable.java
 *
 * Created on Jun 7, 2012, 6:13:53 PM
 */

import java.sql.*;
        
public class SearchAddressTable extends javax.swing.JFrame {

    /** Creates new form SearchAddressTable */
    public SearchAddressTable() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Bernard MT Condensed", 0, 24));
        jLabel3.setText("Addresses Matched");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "EntryID", "Name", "Address", "City", "State", "Country", "Pincode"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18));
        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(247, 247, 247))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(259, 259, 259))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 681, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
SearchAddressForm loginform=new SearchAddressForm();
         loginform.setVisible(true);
      	  setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
  javax.swing.table.DefaultTableModel t=new javax.swing.table.DefaultTableModel();
      jTable1.setModel (t);
      t.addColumn ((Object)"EntryID");
      t.addColumn ((Object)"Name");
      t.addColumn ((Object)"Address");
       t.addColumn ((Object)"City"); 
       t.addColumn((Object)"State");
       t.addColumn((Object)"Country"); 
       t.addColumn((Object)"Pincode");       
        try
{
    Class.forName("com.mysql.jdbc.Driver");
    Connection con= (Connection) 
            DriverManager.getConnection("jdbc:mysql://localhost:3306/sabreesh","root","");
    Statement stmt=con.createStatement();
    // String id =jTextField1.getText();
       
   
    String str="Select * from address ";
  ResultSet s=stmt.executeQuery(str);
  while (s.next())
  {
      String id1=s.getString("id");
		String uname=s.getString("name");
		String uaddress=s.getString("adress");
                String ucity=s.getString("city");
                String ustate=s.getString("state");
                String ucountry=s.getString("country");
                String upincode=s.getString("pincode");
                t.addRow(new Object[] {id1,uname,uaddress,ucity,ustate,ucountry,upincode});
                
  }
  // JOptionPane.showMessageDialog(this,"Record inserted"+r);
   
    
}
catch(Exception e)
{
JOptionPane.showMessageDialog(this,e.getMessage());
e.printStackTrace();
}
      
     
        
    }//GEN-LAST:event_formWindowActivated

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SearchAddressTable().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

}
