package airlines;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.sql.*;
import java.awt.Font;
import javax.swing.ImageIcon;
public class Fpotp extends JFrame {

	private JPanel contentPane;
	private JTextField otptxt;
	private JTextField ptxt;
	private JTextField cptxt;
	private JLabel error;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fpotp frame = new Fpotp(null,null,null);
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
	public Fpotp(String t,String otp,String uid) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 656);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		otptxt = new JTextField();
		otptxt.setBounds(370, 127, 116, 22);
		contentPane.add(otptxt);
		otptxt.setColumns(10);
		
		ptxt = new JTextField();
		ptxt.setColumns(10);
		ptxt.setBounds(370, 212, 116, 22);
		contentPane.add(ptxt);
		
		JLabel oac = new JLabel("OTP");
		oac.setFont(new Font("Tahoma", Font.BOLD, 12));
		oac.setBounds(146, 133, 56, 16);
		contentPane.add(oac);
		
		JLabel lblNewLabel_1 = new JLabel("PASSWORD");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(146, 215, 97, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("CONFIRM PASSWORD");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(146, 291, 151, 16);
		contentPane.add(lblNewLabel_2);
		
		cptxt = new JTextField();
		cptxt.setBounds(370, 288, 116, 22);
		contentPane.add(cptxt);
		cptxt.setColumns(10);
		
		error = new JLabel("");
		error.setForeground(Color.RED);
		error.setBounds(258, 342, 78, 16);
		contentPane.add(error);
		
		JButton btn = new JButton("CHECK");
		btn.setFont(new Font("Tahoma", Font.BOLD, 12));
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					error.setText("");
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/airlines","root","Surya72");
					if(!otp.equals(otptxt.getText()))
					{
						error.setText("OTP DIDN'T MATCH");
					}
					else if(!ptxt.getText().matches("^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[@#$%^&-+=()]).{3,}$"))
					{
						error.setText("password must contain atleast 1 alphabet, 1 number,1 special character");
					}
					else if(!cptxt.getText().equals(ptxt.getText().toString()))
					{
						error.setText("Confirm password did not match");
					}
					else
					{
						PreparedStatement ps;
						if(t.matches("user"))
						{
							ps=conn.prepareStatement("update user set password=? where user_id=?");
						}
						else
						{
							ps=conn.prepareStatement("update airlines set password=? where user=?");
						}
						ps.setString(1,ptxt.getText());
						ps.setString(2,uid);
						int x=ps.executeUpdate();
						if(x==1)
						{
							Start s=new Start();
							s.show();
							dispose();
						}
					}
				}
				catch(Exception e)
				{
					System.out.print(e);
				}
			}
		});
		btn.setBounds(239, 371, 116, 25);
		contentPane.add(btn);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Fpotp.class.getResource("/images/Background12.jpg")));
		lblNewLabel.setBounds(0, 0, 786, 619);
		contentPane.add(lblNewLabel);
	}

}
