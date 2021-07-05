package airlines;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.util.Properties;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
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
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;
public class airlinessignin extends JFrame {

	private JPanel contentPane;
	private JTextField utxt;
	private JTextField ptxt;
	private JTextField cptxt;
	private JTextField etxt;
	private JTextField ctxt;
	private JLabel error;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					airlinessignin frame = new airlinessignin();
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
	public airlinessignin() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(airlinessignin.class.getResource("/images/ficon1.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 656);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel usertxt = new JLabel("User Name");
		usertxt.setFont(new Font("Tahoma", Font.BOLD, 12));
		usertxt.setBounds(78, 86, 93, 16);
		contentPane.add(usertxt);
		
		JLabel passtxt = new JLabel("Password");
		passtxt.setFont(new Font("Tahoma", Font.BOLD, 12));
		passtxt.setBounds(78, 158, 71, 16);
		contentPane.add(passtxt);
		
		JLabel lblConformPassword = new JLabel("Confirm Password");
		lblConformPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblConformPassword.setBounds(78, 234, 117, 16);
		contentPane.add(lblConformPassword);
		
		JLabel emailtxt = new JLabel("Gmail");
		emailtxt.setFont(new Font("Tahoma", Font.BOLD, 12));
		emailtxt.setBounds(78, 309, 56, 16);
		contentPane.add(emailtxt);
		
		JLabel cnametxt = new JLabel("Company Name");
		cnametxt.setFont(new Font("Tahoma", Font.BOLD, 12));
		cnametxt.setBounds(78, 383, 117, 16);
		contentPane.add(cnametxt);
		
		utxt = new JTextField();
		utxt.setBounds(299, 83, 116, 22);
		contentPane.add(utxt);
		utxt.setColumns(10);
		
		ptxt = new JTextField();
		ptxt.setColumns(10);
		ptxt.setBounds(299, 155, 116, 22);
		contentPane.add(ptxt);
		
		cptxt = new JTextField();
		cptxt.setColumns(10);
		cptxt.setBounds(299, 231, 116, 22);
		contentPane.add(cptxt);
		
		etxt = new JTextField();
		etxt.setColumns(10);
		etxt.setBounds(299, 306, 116, 22);
		contentPane.add(etxt);
		
		ctxt = new JTextField();
		ctxt.setColumns(10);
		ctxt.setBounds(299, 380, 116, 22);
		contentPane.add(ctxt);
		
		error = new JLabel("");
		error.setBounds(152, 436, 544, 16);
		contentPane.add(error);
		
		JButton btnNewButton = new JButton("");
		Image img=new ImageIcon(this.getClass().getResource("/back-icon (1).png")).getImage();
		btnNewButton.setIcon(new ImageIcon(img));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login u=new Login();
				u.show();
				dispose();
			}
		});
		btnNewButton.setBounds(0, 0, 49, 40);
		contentPane.add(btnNewButton);
		
		JButton btn = new JButton("Sign in");
		btn.setBackground(Color.ORANGE);
		btn.setFont(new Font("Tahoma", Font.BOLD, 12));
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					error.setText("");
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/airlines?" + "autoReconnect=true&useSSL=false","root","Surya72");
					if(utxt.getText().equals(""))
					{
						error.setText("please enter user name");
					}
					else if(!ptxt.getText().matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()]).{8,20}$"))
					{
						error.setText("password must contain atleast 1 alphabet, 1 number,1 special character");
					}
					else if(!ptxt.getText().equals(cptxt.getText()))
					{
						error.setText("passwords did not match");
					}
					else if(!etxt.getText().matches("^.*@gmail.com$"))
					{
						error.setText("Gmail not valid");
					}
					else if(ctxt.getText().equals(""))
					{
						error.setText("Company name cannot be empty");
					}
					else
					{
						PreparedStatement ps1=conn.prepareStatement("select * from airlines where email=?");
						ps1.setString(1, etxt.getText().toString());
						ResultSet rs=ps1.executeQuery();
						PreparedStatement ps2=conn.prepareStatement("select * from airlines where user=?");
						ps2.setString(1, utxt.getText().toString());
						ResultSet rs1=ps2.executeQuery();
						int t=0;
						if(rs1.next())
						{
							error.setText("USERNAME TAKEN");
							t=1;
						}
						if(!rs.next() && t==0)
						{
						PreparedStatement ps=conn.prepareStatement("insert into airlines values(?,?,?,?)");
						ps.setString(1,utxt.getText().toString());
						ps.setString(2, ptxt.getText().toString());
						ps.setString(3,ctxt.getText().toString());
						ps.setString(4,etxt.getText().toString());
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
						emailverification ev=new emailverification(otp,utxt.getText(),ptxt.getText(),ctxt.getText(),etxt.getText());
						ev.show();
						dispose();
						}
						else if(t==0)
						{
							error.setText("Gmail already exist");
						}
					}
				}
				catch(Exception exception)
				{
					error.setText(exception.toString());
				}
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
					error.setText(e.toString());
				}
				return message;
				
			}
		});
		btn.setBounds(190, 465, 97, 25);
		contentPane.add(btn);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(airlinessignin.class.getResource("/images/Background12.jpg")));
		lblNewLabel.setBounds(0, 0, 786, 619);
		contentPane.add(lblNewLabel);
	}
}

