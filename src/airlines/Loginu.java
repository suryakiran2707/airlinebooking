package airlines;

import java.awt.BorderLayout;
import java.sql.*;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;

public class Loginu extends JFrame {

	private JPanel contentPane;
	private JTextField utxt;
	private JTextField ptxt;
	private JLabel error;
	private JButton signinbtn;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Loginu frame = new Loginu();
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
	public Loginu() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Loginu.class.getResource("/images/ficon1.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 677, 656);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		utxt = new JTextField();
		utxt.setBounds(307, 63, 116, 22);
		contentPane.add(utxt);
		utxt.setColumns(10);
		error = new JLabel("");
		error.setForeground(Color.RED);
		error.setBounds(189, 259, 196, 16);
		contentPane.add(error);
		
		ptxt = new JTextField();
		ptxt.setColumns(10);
		ptxt.setBounds(307, 159, 116, 22);
		contentPane.add(ptxt);
		
		JLabel nametxt = new JLabel("User name");
		nametxt.setFont(new Font("Tahoma", Font.BOLD, 12));
		nametxt.setBounds(108, 66, 81, 16);
		contentPane.add(nametxt);
		
		JLabel passtxt = new JLabel("Password");
		passtxt.setFont(new Font("Tahoma", Font.BOLD, 12));
		passtxt.setBounds(108, 162, 81, 16);
		contentPane.add(passtxt);
		
		JButton btnNewButton = new JButton("");
		Image img=new ImageIcon(this.getClass().getResource("/back-icon (1).png")).getImage();
		btnNewButton.setIcon(new ImageIcon(img));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Start s=new Start();
				s.show();
				dispose();
			}
		});
		btnNewButton.setBounds(0, 0, 49, 40);
		contentPane.add(btnNewButton);
		
		JButton login = new JButton("LOG IN");
		login.setFont(new Font("Tahoma", Font.BOLD, 12));
		login.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					error.setText("");
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/airlines","root","Surya72");
				String str=utxt.getText();
				String pass=ptxt.getText();
				PreparedStatement ps1=conn.prepareStatement("select password,user_id from user where user_id=?");
				ps1.setString(1,str);
				ResultSet rs=ps1.executeQuery();
				if(rs.next())
				{
				String opass=rs.getString("password");
				String ouser=rs.getString("user_id");
				if(ouser.equals(str))
				{
				if(pass.equals(opass))
				{
					Main m=new Main(str);
					dispose();
					m.show();
				}
				else
				{
					error.setText("password didn't match");
				}
				}
				else
				{
					error.setText("User name does not exist");
				}
				}
				else 
				{
					error.setText("User name does not exist");
				}
				}
				catch(Exception exception)
				{
					System.out.println(exception);
				}
			}
		});
		login.setBounds(213, 288, 97, 25);
		contentPane.add(login);
		
		signinbtn = new JButton("Sign up");
		signinbtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		signinbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Usersignin as=new Usersignin();
				as.show();
				dispose();
			}
		});
		signinbtn.setBounds(213, 353, 97, 25);
		contentPane.add(signinbtn);
		
		btnNewButton_1 = new JButton("Forgot password");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Forgotpassword f=new Forgotpassword("user");
				f.show();
				dispose();
			}
		});
		btnNewButton_1.setForeground(Color.MAGENTA);
		btnNewButton_1.setBounds(390, 194, 149, 16);
		contentPane.add(btnNewButton_1);
		
		lblNewLabel = new JLabel("DIDN'T HAVE AN ACCOUNT? ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setBounds(189, 324, 178, 16);
		contentPane.add(lblNewLabel);
	}
}