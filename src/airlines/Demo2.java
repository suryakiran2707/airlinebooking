package airlines;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;



public class Demo2 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void Mymethod(int i) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Demo2 frame = new Demo2(i);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Demo2()
	{
		
	}

	/**
	 * Create the frame.
	 */
	public Demo2(int i) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 693, 584);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, "name_592446592188700");
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 667, 115);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setForeground(new Color(255, 255, 255));
		panel_4.setBackground(new Color(255, 51, 255));
		panel_4.setBounds(0, 0, 667, 77);
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		
		//Get the variables
				String src = MyDemo.strq[i];
				String dest = MyDemo.destq[i];
				Time stime1 = MyDemo.stimeq[i];
				Time etime1 = MyDemo.etimeq[i];
				int fare = MyDemo.fareq[i];
				Date date = MyDemo.dateq[i];
				
				DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");  
		        String stime = dateFormat.format(stime1);
		        String etime = dateFormat.format(etime1);
				
				Demo3.NameMethod(i+1);
				int n = Demo3.n;
				
		//Initialize 
				String name[] = new String[n];
				String gender[] = new String[n];
				int age[] = new int[n];
				int seatno[] = new int[n];
				
		//Get Passenger Details
				for(int k=0;k<n;k++)
				{
					name[k] = Demo3.name[k];
					gender[k] = Demo3.gender[k];
					age[k] = Demo3.age[k];
					seatno[k] = Demo3.seatno[k];
					
					 
				}
				
				
				
				
		JLabel lblNewLabel = new JLabel("HAPPY JOURNEY !!");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(70, 10, 490, 32);
		panel_4.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("NEED HELP : 9685741536");
		lblNewLabel_1.setBackground(new Color(240, 240, 240));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(171, 41, 302, 26);
		panel_4.add(lblNewLabel_1);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 255, 255));
		panel_5.setBounds(0, 76, 667, 38);
		panel_1.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Flight From"+src+" TO "+ dest);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblNewLabel_2.setBounds(10, 0, 358, 38);
		panel_5.add(lblNewLabel_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 122, 667, 255);
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(5, 1, 0, 0));
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(255, 255, 255));
		panel_6.setForeground(new Color(255, 255, 255));
		panel_2.add(panel_6);
		panel_6.setLayout(null);
		
		
		
		JLabel lblNewLabel_3 = new JLabel("NAME");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(10, 10, 152, 31);
		panel_6.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("GENDER");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setBounds(207, 10, 121, 31);
		panel_6.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("AGE");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4_1.setBounds(338, 10, 121, 31);
		panel_6.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_2 = new JLabel("SEAT NO");
		lblNewLabel_4_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4_2.setBounds(491, 10, 121, 31);
		panel_6.add(lblNewLabel_4_2);
		
		if(n>0)
		{
			JPanel panel_7 = new JPanel();
			panel_7.setBackground(new Color(255, 255, 255));
			panel_2.add(panel_7);
			panel_7.setLayout(null);
			
			JLabel lblNewLabel_3_1 = new JLabel(name[0]);
			lblNewLabel_3_1.setFont(new Font("Tahoma", Font.ITALIC, 14));
			lblNewLabel_3_1.setBounds(10, 10, 152, 31);
			panel_7.add(lblNewLabel_3_1);
			
			JLabel lblNewLabel_3_2 = new JLabel(gender[0]);
			lblNewLabel_3_2.setFont(new Font("Tahoma", Font.ITALIC, 14));
			lblNewLabel_3_2.setBounds(206, 10, 101, 31);
			panel_7.add(lblNewLabel_3_2);
			
			JLabel lblNewLabel_3_2_1 = new JLabel(String.valueOf(age[0]));
			lblNewLabel_3_2_1.setFont(new Font("Tahoma", Font.ITALIC, 14));
			lblNewLabel_3_2_1.setBounds(337, 10, 101, 31);
			panel_7.add(lblNewLabel_3_2_1);
			
			JLabel lblNewLabel_3_2_2 = new JLabel(String.valueOf(seatno[0]));
			lblNewLabel_3_2_2.setFont(new Font("Tahoma", Font.ITALIC, 14));
			lblNewLabel_3_2_2.setBounds(494, 10, 101, 31);
			panel_7.add(lblNewLabel_3_2_2);
		}
		
		if(n>1)
		{
			JPanel panel_8 = new JPanel();
			panel_8.setBackground(Color.WHITE);
			panel_2.add(panel_8);
			panel_8.setLayout(null);
			
			JLabel lblNewLabel_3_1_1 = new JLabel(name[1]);
			lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.ITALIC, 14));
			lblNewLabel_3_1_1.setBounds(10, 10, 152, 31);
			panel_8.add(lblNewLabel_3_1_1);
			
			JLabel lblNewLabel_3_2_3 = new JLabel(gender[1]);
			lblNewLabel_3_2_3.setFont(new Font("Tahoma", Font.ITALIC, 14));
			lblNewLabel_3_2_3.setBounds(205, 10, 101, 31);
			panel_8.add(lblNewLabel_3_2_3);
			
			JLabel lblNewLabel_3_2_1_1 = new JLabel(String.valueOf(age[1]));
			lblNewLabel_3_2_1_1.setFont(new Font("Tahoma", Font.ITALIC, 14));
			lblNewLabel_3_2_1_1.setBounds(331, 10, 101, 31);
			panel_8.add(lblNewLabel_3_2_1_1);
			
			JLabel lblNewLabel_3_2_2_1 = new JLabel(String.valueOf(seatno[1]));
			lblNewLabel_3_2_2_1.setFont(new Font("Tahoma", Font.ITALIC, 14));
			lblNewLabel_3_2_2_1.setBounds(494, 10, 101, 31);
			panel_8.add(lblNewLabel_3_2_2_1);
		}
		
		if(n>2)
		{
			JPanel panel_9 = new JPanel();
			panel_9.setBackground(new Color(255, 255, 255));
			panel_2.add(panel_9);
			panel_9.setLayout(null);
			
			JLabel lblNewLabel_3_1_2 = new JLabel(name[2]);
			lblNewLabel_3_1_2.setFont(new Font("Tahoma", Font.ITALIC, 14));
			lblNewLabel_3_1_2.setBounds(10, 10, 152, 31);
			panel_9.add(lblNewLabel_3_1_2);
			
			JLabel lblNewLabel_3_2_4 = new JLabel(gender[2]);
			lblNewLabel_3_2_4.setFont(new Font("Tahoma", Font.ITALIC, 14));
			lblNewLabel_3_2_4.setBounds(203, 10, 101, 31);
			panel_9.add(lblNewLabel_3_2_4);
			
			JLabel lblNewLabel_3_2_1_2 = new JLabel(String.valueOf(age[2]));
			lblNewLabel_3_2_1_2.setFont(new Font("Tahoma", Font.ITALIC, 14));
			lblNewLabel_3_2_1_2.setBounds(332, 10, 101, 31);
			panel_9.add(lblNewLabel_3_2_1_2);
			
			JLabel lblNewLabel_3_2_2_2 = new JLabel(String.valueOf(seatno[2]));
			lblNewLabel_3_2_2_2.setFont(new Font("Tahoma", Font.ITALIC, 14));
			lblNewLabel_3_2_2_2.setBounds(491, 10, 101, 31);
			panel_9.add(lblNewLabel_3_2_2_2);
		}
		
		if(n>3)
		{
			JPanel panel_10 = new JPanel();
			panel_10.setBackground(Color.WHITE);
			panel_2.add(panel_10);
			panel_10.setLayout(null);
			
			JLabel lblNewLabel_3_1_3 = new JLabel(name[3]);
			lblNewLabel_3_1_3.setFont(new Font("Tahoma", Font.ITALIC, 14));
			lblNewLabel_3_1_3.setBounds(10, 10, 152, 31);
			panel_10.add(lblNewLabel_3_1_3);
			
			JLabel lblNewLabel_3_2_5 = new JLabel(gender[3]);
			lblNewLabel_3_2_5.setFont(new Font("Tahoma", Font.ITALIC, 14));
			lblNewLabel_3_2_5.setBounds(201, 10, 101, 31);
			panel_10.add(lblNewLabel_3_2_5);
			
			JLabel lblNewLabel_3_2_1_3 = new JLabel(String.valueOf(age[3]));
			lblNewLabel_3_2_1_3.setFont(new Font("Tahoma", Font.ITALIC, 14));
			lblNewLabel_3_2_1_3.setBounds(332, 10, 101, 31);
			panel_10.add(lblNewLabel_3_2_1_3);
			
			JLabel lblNewLabel_3_2_2_3 = new JLabel(String.valueOf(seatno[3]));
			lblNewLabel_3_2_2_3.setFont(new Font("Tahoma", Font.ITALIC, 14));
			lblNewLabel_3_2_2_3.setBounds(492, 10, 101, 31);
			panel_10.add(lblNewLabel_3_2_2_3);
		}
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBounds(0, 387, 667, 148);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel(src);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(10, 10, 108, 36);
		panel_3.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel(dest);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(232, 10, 128, 36);
		panel_3.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("TOTAL FARE : "+String.valueOf(fare) +"/-");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_7.setForeground(new Color(0, 0, 0));
		lblNewLabel_7.setBounds(10, 71, 404, 67);
		panel_3.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel(stime);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_8.setBounds(10, 48, 88, 26);
		panel_3.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel(etime);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_9.setBounds(232, 48, 88, 26);
		panel_3.add(lblNewLabel_9);
		
		 
		
	}
}
