package airlines;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.*;  
import java.awt.event.WindowEvent;  
import java.awt.event.WindowListener;
import java.sql.Date;
import java.sql.Time;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JScrollBar;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.border.LineBorder;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ViewSession extends JFrame {

	private JPanel contentPane;
	private JTextField txtKiranAgegenderSeat;
	
	public ViewSession()
	{
		
	}
	static String t;
	public ViewSession(String str)
	{
		t=new String(str);
	}

	/**
	 * Launch the application.
	 */
	public static void Mymethod(int i) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//ViewSession frame1 = new ViewSession(t);
					ViewSession frame = new ViewSession(i);
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
	public ViewSession(int i) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 692, 515);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, "name_55424717037900");
		panel.setLayout(new GridLayout(4, 1, 0, 0));
		
		
		
		//Get the variables
		String src = MyDemo.strq[i];
		String dest = MyDemo.destq[i];
		Time stime = MyDemo.stimeq[i];
		Time etime = MyDemo.etimeq[i];
		int fare = MyDemo.fareq[i];
		Date date = MyDemo.dateq[i];
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 139, 139));
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(3, 2, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("HAPPY JOURNEY !!");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("NEED HELP : 9986958456");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		panel_2.add(lblNewLabel);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setForeground(new Color(0, 0, 0));
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Flight From"+src+" to"+ dest);
		lblNewLabel_2.setBounds(12, 12, 212, 16);
		panel_3.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("INDIGO\r\n");
		lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_3.setBounds(12, 31, 55, 26);
		panel_3.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Buisiness Class\r\n");
		lblNewLabel_4.setBounds(12, 58, 110, 16);
		panel_3.add(lblNewLabel_4);
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.X_AXIS));
		
		txtKiranAgegenderSeat = new JTextField();
		txtKiranAgegenderSeat.setFont(new Font("Dialog", Font.ITALIC, 14));
		txtKiranAgegenderSeat.setText("KIRAN\r\nAGE,GENDER SEAT NO");
		panel_4.add(txtKiranAgegenderSeat);
		txtKiranAgegenderSeat.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("TOTAL PRICE PAID   :     "+fare);
		lblNewLabel_5.setBackground(new Color(255, 255, 255));
		lblNewLabel_5.setBounds(12, 12, 304, 44);
		panel_1.add(lblNewLabel_5);
		
		
		
		   
	}
}
