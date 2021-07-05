package airlines;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Toolkit;
public class Userotpver extends JFrame {

	private JPanel contentPane;
	private JTextField otptxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Userotpver(String otp,String name,String userid,String password,String gender,String phone,String email,String age) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Userotpver.class.getResource("/images/ficon1.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 615);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		otptxt = new JTextField();
		otptxt.setBackground(Color.WHITE);
		otptxt.setBounds(256, 199, 116, 22);
		contentPane.add(otptxt);
		otptxt.setColumns(10);
		
		JLabel error = new JLabel("");
		error.setForeground(Color.RED);
		error.setBounds(284, 245, 56, 16);
		contentPane.add(error);
		
		JLabel lblNewLabel_1 = new JLabel("ENTER OTP HERE");
		lblNewLabel_1.setBackground(Color.ORANGE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(256, 154, 123, 16);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("CHECK");
		btnNewButton.setBackground(Color.ORANGE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					error.setText("");
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/airlines","root","Surya72");
					if(otptxt.getText().equals(otp))
					{
						PreparedStatement ps1=conn.prepareStatement("insert into user values(?,?,?,?,?,?,?)");
						ps1.setString(1, userid);
						ps1.setString(2, name);
						ps1.setInt(3, Integer.parseInt(age));
						ps1.setString(4, gender);
						ps1.setString(5, password);
						ps1.setString(6, phone);
						ps1.setString(7, email);
						int x=ps1.executeUpdate();
						if(x==1)
						{
							System.out.println("done ");
							Loginu l=new Loginu();
							l.show();
							dispose();
						}
						else
						{
							error.setText("Sign up failed");
						}
						}
					else
					{
						error.setText("OTP NOT MATCHED");
					}
				}
				catch(Exception exp)
				{
					System.out.println(exp);
				}
			}
		});
		btnNewButton.setBounds(270, 313, 97, 25);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Userotpver.class.getResource("/images/Background12.jpg")));
		lblNewLabel.setBounds(0, 0, 801, 578);
		contentPane.add(lblNewLabel);
	}

}
/*Loginu l=new Loginu();
							l.show();
							dispose();*/

