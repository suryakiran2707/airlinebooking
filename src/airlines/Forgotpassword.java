package airlines;

import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class Forgotpassword extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Forgotpassword frame = new Forgotpassword(null);
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
	public Forgotpassword(String t) {
		setTitle("AIRLINES\r\n");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Forgotpassword.class.getResource("/images/ficon1.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 656);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(99, 108, 56, 16);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(254, 105, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		JLabel error = new JLabel("");
		error.setBackground(Color.RED);
		error.setForeground(Color.RED);
		error.setBounds(180, 177, 56, 16);
		contentPane.add(error);
		
		JLabel otpsent = new JLabel("");
		otpsent.setBounds(180, 163, 56, 16);
		contentPane.add(otpsent);
		
		JButton btn = new JButton("Send otp");
		btn.setFont(new Font("Tahoma", Font.BOLD, 12));
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					error.setText("");
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/airlines","root","Surya72");
					PreparedStatement ps;
					if(t.matches("user"))
					{
						ps=conn.prepareStatement("select email from user where user_id=?");
						
					}
					else
					{
						ps=conn.prepareStatement("select email from airlines where user=?");
						
					}
					ps.setString(1,textField.getText().toString());
					ResultSet rs=ps.executeQuery();
					if(rs.next())
					{
						Properties properties= new Properties();
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
						Message message=preparemessage(session,account,rs.getString("email"),otp);
						Transport.send(message);
						System.out.println("sent ");
						Fpotp out=new Fpotp(t,otp,textField.getText().toString());
						out.show();
						dispose();
					}
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
			}

			private Message preparemessage(Session session, String account, String s, String otp) {
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
		
		btn.setBounds(165, 204, 97, 25);
		contentPane.add(btn);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(Forgotpassword.class.getResource("/images/Background12.jpg")));
		lblNewLabel_1.setBounds(0, 0, 786, 619);
		contentPane.add(lblNewLabel_1);
	}
	
}

