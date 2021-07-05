package airlines;
import java.awt.BorderLayout;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Toolkit;

public class selection extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					selection frame = new selection(null);
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
	public selection(String username) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(selection.class.getResource("/images/ficon1.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 656);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("ADD A NEW FLIGHT");
		btnNewButton.setBackground(Color.ORANGE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Add_flight af=new Add_flight(username);
				af.show();
				dispose();
			}
		});
		btnNewButton.setBounds(157, 119, 169, 25);
		contentPane.add(btnNewButton);
		
		JButton btnSeeCurrectStatus = new JButton("SEE CURRECT STATUS OF REGISTERED FLIGHTS");
		btnSeeCurrectStatus.setBackground(Color.ORANGE);
		btnSeeCurrectStatus.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSeeCurrectStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				viewdetails vd=new viewdetails(username);
				vd.show();
				dispose();
			}
		});
		btnSeeCurrectStatus.setBounds(94, 189, 336, 25);
		contentPane.add(btnSeeCurrectStatus);
		
		JButton btnNewButton_1 = new JButton("GET USER DETAILS\r\n");
		btnNewButton_1.setBackground(Color.ORANGE);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Customerdetails cs=new Customerdetails(username);
				cs.show();
				dispose();
			}
		});
		btnNewButton_1.setBounds(181, 258, 160, 25);
		contentPane.add(btnNewButton_1);
		
		JButton logout = new JButton("LOG OUT");
		logout.setBackground(Color.ORANGE);
		logout.setFont(new Font("Tahoma", Font.BOLD, 12));
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login l=new Login();
				l.show();
				dispose();
			}
		});
		logout.setBounds(12, 13, 97, 25);
		contentPane.add(logout);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(selection.class.getResource("/images/Background12.jpg")));
		lblNewLabel.setBounds(0, 0, 786, 619);
		contentPane.add(lblNewLabel);
	}
}

