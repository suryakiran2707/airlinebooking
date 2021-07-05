package airlines;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.Panel;
import java.awt.Font;


public class Usersignin extends JFrame {
	

	private JPanel contentPane;
	private JTextField ntxt;
	private JTextField utxt;
	private JTextField ptxt;
	private JTextField cptxt;
	private JTextField atxt;
	private JTextField etxt;
	private JTextField phtxt;
	private JLabel error;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Usersignin frame = new Usersignin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public Usersignin() {
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 652);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		ntxt = new JTextField();
		ntxt.setBounds(310, 50, 134, 22);
		contentPane.add(ntxt);
		ntxt.setColumns(10);
		
		utxt = new JTextField();
		utxt.setColumns(10);
		utxt.setBounds(310, 110, 134, 22);
		contentPane.add(utxt);
		
		ptxt = new JTextField();
		ptxt.setColumns(10);
		ptxt.setBounds(310, 168, 134, 22);
		contentPane.add(ptxt);
		
		cptxt = new JTextField();
		cptxt.setColumns(10);
		cptxt.setBounds(310, 225, 134, 22);
		contentPane.add(cptxt);
		
		atxt = new JTextField();
		atxt.setColumns(10);
		atxt.setBounds(310, 282, 134, 22);
		contentPane.add(atxt);
		
		etxt = new JTextField();
		etxt.setColumns(10);
		etxt.setBounds(310, 395, 134, 22);
		contentPane.add(etxt);
		
		phtxt = new JTextField();
		phtxt.setColumns(10);
		phtxt.setBounds(310, 456, 134, 22);
		contentPane.add(phtxt);
		
		JLabel lblNewLabel = new JLabel("NAME");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(78, 53, 56, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblUserId = new JLabel("USER ID");
		lblUserId.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUserId.setBounds(78, 113, 56, 16);
		contentPane.add(lblUserId);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPassword.setBounds(78, 171, 97, 16);
		contentPane.add(lblPassword);
		
		JLabel lblConfirmPassword = new JLabel("CONFIRM PASSWORD");
		lblConfirmPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblConfirmPassword.setBounds(78, 228, 157, 16);
		contentPane.add(lblConfirmPassword);
		
		JLabel lblAge = new JLabel("AGE");
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAge.setBounds(78, 285, 56, 16);
		contentPane.add(lblAge);
		
		JLabel lblGender = new JLabel("GENDER");
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblGender.setBounds(78, 342, 56, 16);
		contentPane.add(lblGender);
		
		JLabel lblEmail = new JLabel("EMAIL");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEmail.setBounds(78, 398, 56, 16);
		contentPane.add(lblEmail);
		
		JLabel lblPhoneNumber = new JLabel("PHONE NUMBER");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPhoneNumber.setBounds(78, 459, 140, 16);
		contentPane.add(lblPhoneNumber);
		
		error = new JLabel("");
		error.setForeground(Color.RED);
		error.setBounds(162, 548, 282, 16);
		contentPane.add(error);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(Color.LIGHT_GRAY);
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 12));
		comboBox.addItem("SELECT GENDER");
		comboBox.addItem("MALE");
		comboBox.addItem("FEMALE");
		comboBox.addItem("OTHERS");
		comboBox.setBounds(310, 328, 134, 25);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("");
		Image img=new ImageIcon(this.getClass().getResource("/back-icon (1).png")).getImage();
		btnNewButton.setIcon(new ImageIcon(img));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Loginu n=new Loginu();
			    n.show();
			    dispose();
			}
		});
		btnNewButton.setBounds(0, 0, 49, 40);
		contentPane.add(btnNewButton);
		
		JButton btn = new JButton("CONFIRM");
		btn.setBackground(Color.ORANGE);
		btn.setFont(new Font("Tahoma", Font.BOLD, 12));
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection conn=null;
				PreparedStatement ps1;
				if(btn.getText().equals("CONFIRM"))
				{
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					error.setText("");
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/airlines?" + "autoReconnect=true&useSSL=false","root","Surya72");
					if(ntxt.getText().equals(""))
					{
						error.setText("please enter name");
					}
					else if(utxt.getText().equals(""))
					{
						error.setText("please enter user_id");
					}
					else if(!ptxt.getText().matches("^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[@#$%^&-+=()]).{3,}$"))
					{
						error.setText("password must contain atleast 1 alphabet, 1 number,1 special character");
					}
					else if(!cptxt.getText().equals(ptxt.getText().toString()))
					{
						error.setText("Confirm password did not match");
					}
					else if(atxt.getText().equals(""))
						error.setText("please enter age");
					else if(!etxt.getText().matches("^.+@gmail.com$"))
					{
						error.setText("email not valid");
					}
					else if(comboBox.getSelectedIndex()==0)
					{
						error.setText("please select gender");
					}
					else if(!phtxt.getText().matches("^[0-9]{10}$"))
					{
						error.setText("phone number must be 10 digits");
					}
					else
					{
						PreparedStatement ps=conn.prepareStatement("select user_id from user where email=?");
						ps.setString(1, etxt.getText());
						ResultSet rs=ps.executeQuery();
						PreparedStatement ps141=conn.prepareStatement("select user_id from user where user_id=?");
						ps141.setString(1, utxt.getText());
						ResultSet rs1=ps141.executeQuery();
						if(rs.next())
						{
							error.setText("Email alredy exists");
						}
						else if(rs1.next())
						{
							error.setText("USERNAME TAKEN");
						}
						else
						{
							Properties properties= new Properties();
							properties.put("mail.smtp.starttls.enable", "false");
							properties.put("mail.debug", "true");
							properties.put("mail.smtp.auth","true");
							properties.put("mail.smtp.starttls.enable","true");
							properties.put("mail.smtp.host","smtp.gmail.com");
							properties.put("mail.smtp.port","587");
							String account="learncoding56191@gmail.com";
							String password="Surya@72";
							Session session=Session.getInstance(properties, new Authenticator()
									{
								       protected PasswordAuthentication getPasswordAuthentication()
								       {
										return new PasswordAuthentication(account,password);
								       }
									});
							Random random = new Random();
							String otp= String.format("%04d", random.nextInt(10000));
							Message message=preparemessage(session,account,etxt.getText(),otp);
							Transport.send(message);
							System.out.println("sent ");
							Userotpver o=new Userotpver(otp,ntxt.getText(),utxt.getText(),ptxt.getText(),comboBox.getSelectedItem().toString(),ptxt.getText(),etxt.getText(),atxt.getText());
							o.show();
							dispose();
						}
					}
					
				}
				catch(Exception e)
				{
					
				}
				}
				/*else
				{
					System.out.println(otp+" "+otptxt.getText());
					if(otptxt.getText().equals(otp))
					{
						try
						{
						ps1=conn.prepareStatement("insert into user values(?,?,?,?,?,?,?)");
						ps1.setString(1, utxt.getText());
						ps1.setString(2, ntxt.getText());
						ps1.setString(3, atxt.getText());
						ps1.setString(4, comboBox.getSelectedItem().toString());
						ps1.setString(5, ptxt.getText());
						ps1.setString(6, phtxt.getText());
						ps1.setString(7, etxt.getText());
						int x=ps1.executeUpdate();
						if(x==1)
						{
							System.out.println("done ");
						}
						else
						{
							error.setText("Sign up failed");
						}
						}
						catch(Exception e)
						{
							
						}
					}
					else
					{
						error.setText("OTP NOT MATCHED");
					}
				}*/
				
			}
			private Message preparemessage(Session session,String account,String s,String otp) {
				Message message = null;
				try
				{
				message=new MimeMessage(session);
				message.setFrom(new InternetAddress(account));
				message.setRecipient(Message.RecipientType.TO, new InternetAddress(s));
				message.setSubject("OTP VERIFICATION");
				message.setText("OTP IS : " + otp);				
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				}
				return message;
			}
		});
		btn.setBounds(232, 567, 97, 25);
		contentPane.add(btn);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(Usersignin.class.getResource("/images/Background12.jpg")));
		lblNewLabel_1.setBounds(0, 0, 786, 615);
		contentPane.add(lblNewLabel_1);
		
	}
}
