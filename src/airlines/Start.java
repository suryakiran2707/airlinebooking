package airlines;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Start extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try 
				{
					Start frame = new Start();
					frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */
	public Start() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Start.class.getResource("/images/ficon1.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 656);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JButton ubtn = new JButton("LOGIN OR SIGNUP AS USER");
		ubtn.setBackground(Color.ORANGE);
		ubtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		ubtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Loginu l=new Loginu();
				l.show();
				dispose();
			}
		});
		ubtn.setBounds(223, 166, 291, 68);
		contentPane.add(ubtn);
		
		JButton btnLoginOrsignupAs = new JButton("LOGIN OR SIGNUP AS AIRLINES COMPANY");
		btnLoginOrsignupAs.setForeground(Color.BLACK);
		btnLoginOrsignupAs.setBackground(Color.ORANGE);
		btnLoginOrsignupAs.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLoginOrsignupAs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login l=new Login();
				l.show();
				dispose();
			}
		});
		btnLoginOrsignupAs.setBounds(223, 305, 306, 68);
		contentPane.add(btnLoginOrsignupAs);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBackground(Color.BLUE);
		lblNewLabel.setBounds(0, 0, 788, 619);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(Start.class.getResource("/images/Background12.jpg")));
		lblNewLabel_1.setBounds(0, 0, 788, 633);
		contentPane.add(lblNewLabel_1);
	}

}