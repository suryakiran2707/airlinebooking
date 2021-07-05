package airlines;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.beans.PropertyVetoException;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.UIManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author balup
 */
public class Details extends javax.swing.JInternalFrame {

    /**
     * Creates new form Details
     */
	String t;
	Statement stmt = null;
    public Details() throws PropertyVetoException {
    	setEnabled(false);
    	getContentPane().setEnabled(false);
    	getContentPane().setBackground(Color.WHITE);
    	setBackground(SystemColor.activeCaption);
    	setIcon(true);
    	setFrameIcon(new ImageIcon(Details.class.getResource("/images/ficon1.png")));
    	getContentPane().setFont(new Font("Tahoma", Font.ITALIC, 12));
        String fno =  jLabel10.getText().trim();
        int sno=0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/airlines","root","Surya72");
             pn = conn.prepareStatement("select total_seats,no_of_seats_available from flight where fno=?");            
             pn.setString(1,fno);
              ResultSet rs = pn.executeQuery();
              int ts,ns;
              while(rs.next())
              {
               ts = rs.getInt("total_seats");             
               ns = rs.getInt("no_of_seats_available");
               sno = (ts-ns) + 1;
              }
               jLabel12.setText(String.valueOf(sno));
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Details.class.getName()).log(Level.SEVERE, null, ex);
        }
        initComponents();
    }
    //int sno=0;
    int term=0;
    public Details(String UId,String Fno,int seats,int pno,String str) {
    	t=new String(str);
        initComponents();
        NewLabel_1.setVisible(false);
        NewLabel_2.setVisible(false);
        NewLabel_3.setVisible(false);
        NewLabel_4.setVisible(false);
        jLabel9.setText(UId);
        jLabel10.setText(Fno);
        jLabel14.setText(String.valueOf(seats));
        jLabel11.setText(String.valueOf(pno));
        //jLabel11.setText(String.valueOf(generateRandomIntIntRange(100,999)));
        //jLabel12.setText(String.valueOf(generateRandomIntIntRange(10,99)));
    }
     Connection conn;
    PreparedStatement ps,pr,pn;
    String getGender()
    {
        if(jRadioButton1.isSelected())
        {
            return "Male";
        }
        else if(jRadioButton2.isSelected())
        {
            return "Female";
        }
        else
        {
            return null;
        }
    }
    public static int generateRandomIntIntRange(int min, int max) {
    Random r = new Random();
    return r.nextInt((max - min) + 1) + min;
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton1.setForeground(SystemColor.controlText);
        jButton1.setBackground(new Color(119, 136, 153));
        jButton1.setSelectedIcon(null);
        jButton2 = new javax.swing.JButton();
        jButton2.setBackground(new Color(119, 136, 153));
        jButton2.setForeground(SystemColor.controlText);
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton1.setBackground(SystemColor.activeCaption);
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton2.setBackground(SystemColor.activeCaption);
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("User ID");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Fno");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Passenger No");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Name*");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Age*\r\n");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Gender*");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Phone No*");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Seat No");

        jLabel9.setFont(new java.awt.Font("Trebuchet MS", 2, 12)); // NOI18N
        jLabel9.setText("jLabel9");

        jLabel10.setFont(new java.awt.Font("Trebuchet MS", 2, 12)); // NOI18N
        jLabel10.setText("jLabel10");

        jTextField2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField2MouseClicked(evt);
            }
        });
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Trebuchet MS", 2, 12)); // NOI18N
        jLabel11.setText("jLabel11");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("Confirm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jRadioButton1.setFont(new java.awt.Font("Trebuchet MS", 2, 12)); // NOI18N
        jRadioButton1.setText("Male");

        jRadioButton2.setFont(new java.awt.Font("Trebuchet MS", 2, 12)); // NOI18N
        jRadioButton2.setText("Female");

        jLabel12.setFont(new java.awt.Font("Trebuchet MS", 2, 12)); // NOI18N
        jLabel12.setText("jLabel12");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("No of passengers");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setForeground(SystemColor.textHighlight);
        jLabel14.setText("jLabel14");
        
        JLabel lblNewLabel = new JLabel("* Required fields\r\n");
        lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 12));
        
        NewLabel_1 = new JLabel("Please enter a valid name");
        NewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 11));
        NewLabel_1.setForeground(new Color(255, 0, 0));
        
        NewLabel_4 = new JLabel("Please enter a valid number");
        NewLabel_4.setFont(new Font("Tahoma", Font.ITALIC, 11));
        NewLabel_4.setForeground(Color.RED);
        
        NewLabel_3 = new JLabel("Please select gender");
        NewLabel_3.setFont(new Font("Tahoma", Font.ITALIC, 11));
        NewLabel_3.setForeground(Color.RED);
        
        NewLabel_2 = new JLabel("Please enter a valid age");
        NewLabel_2.setFont(new Font("Tahoma", Font.ITALIC, 11));
        NewLabel_2.setForeground(Color.RED);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap(476, Short.MAX_VALUE)
        			.addComponent(jButton1)
        			.addGap(43)
        			.addComponent(jButton2)
        			.addGap(354))
        		.addGroup(Alignment.LEADING, layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addGap(23)
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(jLabel1)
        						.addComponent(jLabel2)
        						.addComponent(jLabel4)
        						.addComponent(jLabel3)))
        				.addGroup(layout.createSequentialGroup()
        					.addGap(32)
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(jLabel7)
        						.addComponent(jLabel8)
        						.addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
        						.addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))))
        			.addGap(84)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(jLabel11)
        					.addContainerGap())
        				.addGroup(layout.createParallelGroup(Alignment.LEADING)
        					.addGroup(layout.createSequentialGroup()
        						.addComponent(NewLabel_1, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
        						.addContainerGap())
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addGroup(layout.createSequentialGroup()
        							.addComponent(NewLabel_4, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
        							.addContainerGap())
        						.addGroup(layout.createSequentialGroup()
        							.addComponent(jLabel12)
        							.addGap(781))
        						.addGroup(layout.createSequentialGroup()
        							.addComponent(jLabel10)
        							.addContainerGap(781, Short.MAX_VALUE))
        						.addGroup(layout.createSequentialGroup()
        							.addComponent(jRadioButton1)
        							.addPreferredGap(ComponentPlacement.UNRELATED)
        							.addComponent(jRadioButton2, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
        							.addGap(696))
        						.addGroup(layout.createSequentialGroup()
        							.addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        							.addContainerGap())
        						.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
        							.addComponent(jLabel9)
        							.addPreferredGap(ComponentPlacement.RELATED, 441, Short.MAX_VALUE)
        							.addGroup(layout.createParallelGroup(Alignment.LEADING)
        								.addGroup(layout.createSequentialGroup()
        									.addComponent(jLabel13, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
        									.addGap(26)
        									.addComponent(jLabel14))
        								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE))
        							.addGap(151))
        						.addGroup(layout.createSequentialGroup()
        							.addComponent(NewLabel_2, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
        							.addContainerGap())
        						.addGroup(layout.createSequentialGroup()
        							.addGroup(layout.createParallelGroup(Alignment.TRAILING, true)
        								.addComponent(jTextField4, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
        								.addComponent(NewLabel_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
        							.addContainerGap())
        						.addGroup(layout.createSequentialGroup()
        							.addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
        							.addContainerGap())))))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(30)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel13)
        				.addComponent(jLabel14))
        			.addGap(18)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel1)
        				.addComponent(jLabel9)
        				.addComponent(lblNewLabel))
        			.addGap(35)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel2)
        				.addComponent(jLabel10))
        			.addGap(38)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel3)
        				.addComponent(jLabel11))
        			.addGap(30)
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(jLabel4)
        				.addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(NewLabel_1)
        			.addGap(43)
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel5))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(NewLabel_2)
        			.addGap(34)
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(jLabel6)
        				.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        					.addComponent(jRadioButton1)
        					.addComponent(jRadioButton2)))
        			.addGap(9)
        			.addComponent(NewLabel_3)
        			.addGap(35)
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(layout.createSequentialGroup()
        					.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        						.addComponent(jTextField4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(jLabel7))
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(NewLabel_4)
        					.addGap(52)
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jLabel8)
        						.addComponent(jLabel12)))
        				.addGroup(layout.createSequentialGroup()
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jButton1)
        						.addComponent(jButton2))
        					.addGap(23))))
        );
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if((Pattern.matches("[a-zA-Z]+",jTextField2.getText().trim())) && jTextField2.getText().trim()!="") {
        String Name =jTextField2.getText().trim(); NewLabel_1.setVisible(false);
        
        String uid = jLabel9.getText().trim();
        String fno =  jLabel10.getText().trim();
        if((Pattern.matches("[0-9]{0,3}",jTextField3. getText(). trim()) && jTextField3. getText(). trim()!="")) {int age = Integer. parseInt(jTextField3. getText(). trim());NewLabel_2.setVisible(false);
        if(getGender() != "") {String Gender = getGender();NewLabel_3.setVisible(false);
        if((Pattern.matches("[0-9]{10}",jTextField4. getText(). trim()) && jTextField3. getText(). trim()!="")) {  String Phone =jTextField4.getText().trim();NewLabel_4.setVisible(false);
        int pno = Integer.parseInt(jLabel11.getText().trim());
        int sno = Integer.parseInt(jLabel12.getText().trim()); 
        int no = Integer.parseInt(jLabel14.getText().trim());
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
             conn = DriverManager.getConnection("jdbc:mysql://localhost/airlines","root","Surya72");
              /*pn = conn.prepareStatement("select total_seats,no_of_seats_available from flight where fno=?");            
             pn.setString(1,fno);
              ResultSet rs = pn.executeQuery();
              sno = (rs.getInt("total_seats")-rs.getInt("no_of_seats_available")) + 1;
             jLabel12.setText(String.valueOf(sno));*/
             pr = conn.prepareStatement("update flight set no_of_seats_available=no_of_seats_available-1 where fno = ?");
             pr.setString(1,fno);
             int n2 = pr.executeUpdate();
             ps = conn.prepareStatement("insert into user_flight(uid,fno,p_no,p_name,p_age,p_gender,p_phone,seat_no,booking_no) values (?,?,?,?,?,?,?,?,?)");
             ps.setString(1, uid);
            ps.setString(2, fno);
            ps.setInt(3,pno);
            ps.setString(4, Name);
            ps.setInt(5, age);
            ps.setString(6,Gender);
            ps.setString(7,Phone );
            ps.setInt(8,sno);
            ps.setInt(9,3);
            int n1=ps.executeUpdate();
            if(n1>0 && no != 0)
            {
                JOptionPane.showMessageDialog(null,"Inserted Successfully!");
            }
            no--;
            if(no>0)
            {
                 Details d = new Details(uid,fno,no,pno+1,t);
                 JDesktopPane dp = getDesktopPane();
                    dp.add(d);
                    d.setVisible(true);
                    setVisible(false);
            }
            if(no==0){
            	PreparedStatement ps1=conn.prepareStatement("select p_no from user_flight where uid=?");
            	ps1.setString(1, t);
            	ResultSet rs=ps1.executeQuery();
            	/*PreparedStatement ps=conn.prepareStatement("update user_flight set booking_no=(select max(booking_no) from user_flight)+1 where uid=?");
            	ps.setString(1, t);
            	int x=ps.executeUpdate();*/
                JOptionPane.showMessageDialog(null,"All entries are successful");
                setVisible(false);
            }
      }
            
         catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Details.class.getName()).log(Level.SEVERE, null, ex);
        }
        }else  NewLabel_4.setVisible(true);
        }else  NewLabel_3.setVisible(true);
        }else  NewLabel_2.setVisible(true);
        }else  NewLabel_1.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    	
    	/*
    	 * 
    	 * 
    	 * 
    	 * 
    	 * 
    	 * 
    	 * add passengers di marchalii
    	 * 
    	 * 
    	 * 
    	 * 
    	 */
        addPassenger ap = new addPassenger(t);
        JDesktopPane dp = getDesktopPane();
                dp.add(ap);
                ap.setVisible(true);
                setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
        /*String fno =  jLabel10.getText().trim();
        int sno=0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/airline","root","Balu@2001");
             pn = conn.prepareStatement("select total_seats,no_of_seats_available from flight where fno=?");            
             pn.setString(1,fno);
              ResultSet rs = pn.executeQuery();
              sno = (rs.getInt("total_seats")-rs.getInt("no_of_seats_available")) + 1;
               jLabel12.setText(String.valueOf(sno));
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Details.class.getName()).log(Level.SEVERE, null, ex);
        }*/
            
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField2MouseClicked
        // TODO add your handling code here:
        String fno =  jLabel10.getText().trim();
        int sno=0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/airlines","root","Surya72");
             pn = conn.prepareStatement("select total_seats,no_of_seats_available from flight where fno=?");            
             pn.setString(1,fno);
              ResultSet rs = pn.executeQuery();
              int ts,ns;
              while(rs.next())
              {
               ts = rs.getInt("total_seats");             
               ns = rs.getInt("no_of_seats_available");
               sno = (ts-ns) + 1;
              }
               jLabel12.setText(String.valueOf(sno));
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Details.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jTextField2MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private JLabel NewLabel_1;
    private JLabel NewLabel_4;
    private JLabel NewLabel_3;
    private JLabel NewLabel_2;
}