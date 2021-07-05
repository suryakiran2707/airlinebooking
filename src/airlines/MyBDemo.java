package airlines;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import java.awt.CardLayout;
import javax.swing.JTabbedPane;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;

public class MyBDemo extends JFrame {
	
	MyDemo obj = new MyDemo();
	
	int i,j;
	int m;
	String s;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		MyDemo.main(new String[0]);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyBDemo frame = new MyBDemo();
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
	public MyBDemo() {
		setForeground(Color.BLUE);
		setTitle("MYBOOKINGS\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 702, 512);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, "name_87052165831800");
		
		m=MyDemo.m;

		String src[] = new String[m];
		String dest[] = new String[m];
		Time stime[] = new Time[m];
		Time etime[] = new Time[m];
		int fare[] = new int[m];
		Date date[] = new Date[m];
		Demo3.CName();
		String C_Name[] = new String[m];
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("UPCOMING", null, panel, null);
		panel.setLayout(new GridLayout(m, 1, 0, 0));
		
		JPanel panel_1[] = new JPanel[m];
		JLabel lblNewLabel[] = new JLabel[m];
		JLabel lblNewLabel_1[] = new JLabel[m];
		JLabel lblNewLabel_2[] = new JLabel[m];
		JLabel lblNewLabel_3[] = new JLabel[m];
		JLabel lblNewLabel_4[] = new JLabel[m];
		
		for(i=0;i<m;i++)
		{
			panel_1[i] = new JPanel();
			s=String.valueOf(i);
			panel_1[i].setName(s);
			panel_1[i].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					Object source = e.getSource();
		            if(source instanceof JPanel)
		            {
		            	JPanel panelPressed = (JPanel) source;
		            	j=Integer.parseInt(panelPressed.getName());
		            }
					Demo2 jf = new Demo2();
					jf.Mymethod(j);
				}
			});
			panel_1[i].setBorder(new CompoundBorder(new CompoundBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 204, 255)), new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 51, 51))), null));
			panel_1[i].setBackground(SystemColor.window);
			panel.add(panel_1[i]);
			panel_1[i].setLayout(null);
			
			//Get the variables
			src[i] = MyDemo.strq[i];
			dest[i] = MyDemo.destq[i];
			date[i] = MyDemo.dateq[i];
			SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");  
		    String strDate = formatter.format(date[i]);  
		    
		    C_Name[i] = Demo3.C_name[i]; 
			
			lblNewLabel[i] = new JLabel(" "+src[i]+" ");
			lblNewLabel[i].setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel[i].setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel[i].setBounds(53, 10, 115, 41);
			panel_1[i].add(lblNewLabel[i]);
			
			lblNewLabel_1[i] = new JLabel(" "+dest[i]+" ");
			lblNewLabel_1[i].setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1[i].setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel_1[i].setBounds(326, 10, 134, 41);
			panel_1[i].add(lblNewLabel_1[i]);
			
			lblNewLabel_2[i] = new JLabel("to");
			lblNewLabel_2[i].setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel_2[i].setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2[i].setBounds(178, 10, 94, 41);
			panel_1[i].add(lblNewLabel_2[i]);
			
			lblNewLabel_3[i] = new JLabel(C_Name[i]);
			lblNewLabel_3[i].setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_3[i].setFont(new Font("Tahoma", Font.ITALIC, 14));
			lblNewLabel_3[i].setBounds(53, 49, 99, 33);
			panel_1[i].add(lblNewLabel_3[i]);
			
			lblNewLabel_4[i] = new JLabel(strDate);
			lblNewLabel_4[i].setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_4[i].setForeground(new Color(0, 0, 0));
			lblNewLabel_4[i].setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblNewLabel_4[i].setBounds(63, 92, 105, 29);
			panel_1[i].add(lblNewLabel_4[i]);
			
		}
	}
}
