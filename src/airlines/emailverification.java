package airlines;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class emailverification extends JFrame {

	private JPanel contentPane;
	private JTextField otptxt;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					emailverification frame = new emailverification(null,null,null,null,null);
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
	public emailverification(String str,String u,String p,String c,String e) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 656);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		otptxt = new JTextField();
		otptxt.setBounds(240, 162, 116, 22);
		contentPane.add(otptxt);
		otptxt.setColumns(10);
		
		JButton btn = new JButton("check");
		btn.setFont(new Font("Tahoma", Font.BOLD, 12));
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(otptxt.getText().equals(str))
				{
					try
					{
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/airlines","root","Surya72");
						PreparedStatement ps=conn.prepareStatement("insert into airlines values(?,?,?,?)");
						ps.setString(1,u);
						ps.setString(2, p);
						ps.setString(3,c);
						ps.setString(4,e);
						int x=ps.executeUpdate();
						if(x==1)
						{
							System.out.println("verified sucessfully");
							Login ln=new Login();
							ln.show();
							dispose();
						}
						else
						{
							System.out.println("failed");
						}
					}
					catch(Exception e)
					{
						System.out.println(e);
					}
				}
				else
				{
					System.out.println("not matched");
				}
			}
		});
		btn.setBounds(246, 267, 97, 25);
		contentPane.add(btn);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(emailverification.class.getResource("/images/Background12.jpg")));
		lblNewLabel.setBounds(0, 0, 786, 619);
		contentPane.add(lblNewLabel);
	}

}

