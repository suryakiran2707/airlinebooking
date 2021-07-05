package airlines;
import java.awt.BorderLayout;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JProgressBar;
import javax.swing.JScrollBar;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JDateChooser;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Toolkit;

public class viewdetails extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField fnotxt;
	private JTable table_1;
	private JTable table_2;
	private JScrollPane scrollPane;
	private JComboBox ocubox;
	private JTextField ocutxt;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewdetails frame = new viewdetails("praveen");
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
	public viewdetails(String user) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(viewdetails.class.getResource("/images/ficon1.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1034, 753);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		table = new JTable();
		table.setBounds(518, 408, -480, -210);
		contentPane.add(table);
		
		fnotxt = new JTextField();
		fnotxt.setBounds(48, 74, 116, 22);
		contentPane.add(fnotxt);
		fnotxt.setColumns(10);
		fnotxt.setEditable(false);
		JComboBox datebox = new JComboBox();
		datebox.setBackground(new Color(0, 255, 255));
		datebox.setFont(new Font("Tahoma", Font.BOLD, 12));
		datebox.addItem("Serach by Date");
		datebox.addItem("On or after a Date");
		datebox.addItem("after a Date");
		datebox.addItem("On a Date");
		datebox.addItem("On or before a Date");
		datebox.addItem("before a Date");
		datebox.setModel(new DefaultComboBoxModel(new String[] {"Search by Date", "On or after a Date", "After a Date", "On a Date", "On or before a Date", "Before a Date"}));
		datebox.setSelectedIndex(0);;
		datebox.setBounds(373, 40, 188, 25);
		contentPane.add(datebox);
		JButton searchbtn = new JButton("SEARCH");
		searchbtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		searchbtn.setBounds(268, 123, 97, 25);
		contentPane.add(searchbtn);
		scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 191, 938, 481);
		contentPane.add(scrollPane);
		
		table_2 = new JTable();
		scrollPane.setViewportView(table_2);
		
		JRadioButton Flightnobtn = new JRadioButton("Flight number");
		Flightnobtn.setBackground(Color.WHITE);
		Flightnobtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		Flightnobtn.setBounds(37, 40, 127, 25);
		contentPane.add(Flightnobtn);
		Flightnobtn.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e) {
						if(!Flightnobtn.isSelected())
						{
							fnotxt.setText(null);
							fnotxt.setEditable(false);
						}
						else
						{
							fnotxt.setEditable(true);
						}
					}
				});
		
		JList list = new JList();
		list.setBounds(495, 109, -58, 22);
		contentPane.add(list);
		
		ocubox = new JComboBox();
		ocubox.setFont(new Font("Tahoma", Font.BOLD, 12));
		ocubox.addItem("Search by occupancy %");
		ocubox.addItem("grater than or equal to");
		ocubox.addItem("greater than ");
		ocubox.addItem("equal");
		ocubox.addItem("less than or equal to");
		ocubox.addItem("less than");
		ocubox.setBounds(733, 41, 182, 22);
		contentPane.add(ocubox);
		
		ocutxt = new JTextField();
		ocutxt.setBounds(743, 74, 116, 22);
		contentPane.add(ocutxt);
		ocutxt.setColumns(10);
		
		JLabel exceptiontxt = new JLabel("");
		exceptiontxt.setBounds(108, 162, 453, 16);
		contentPane.add(exceptiontxt);
		
		btnNewButton = new JButton("");
		Image img=new ImageIcon(this.getClass().getResource("/back-icon (1).png")).getImage();
		btnNewButton.setIcon(new ImageIcon(img));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selection sel=new selection(user);
				sel.show();
				dispose();
			}
		});
		btnNewButton.setBounds(0, 0, 50, 38);
		contentPane.add(btnNewButton);
		
		JDateChooser aftertxt = new JDateChooser();
		aftertxt.setBounds(373, 74, 188, 22);
		aftertxt.setDateFormatString("YYYY-MM-dd");
		LocalDate date=java.time.LocalDate.now();
		Date date1 = java.sql.Date.valueOf(date);
		contentPane.add(aftertxt);
		searchbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					exceptiontxt.setText("");
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/airlines","root","Surya72");
				String fno=fnotxt.getText().toString();
				int datesel=datebox.getSelectedIndex();
				int ocu=ocubox.getSelectedIndex();
				if(Flightnobtn.isSelected())
				{
				PreparedStatement ps=conn.prepareStatement("select * from flight where owner=? and Fno=?");
				PreparedStatement psK=conn.prepareStatement("select Fno from flight where owner=? and Fno=?");
				
				// dont forgot to add user
				
				ps.setString(1,user);
				ps.setString(2,fnotxt.getText());
				ResultSet rs=ps.executeQuery();
				psK.setString(1,user);
				psK.setString(2,fnotxt.getText());
				ResultSet rd=psK.executeQuery();
				if(rd.next())
				{
				table_2.setModel(DbUtils.resultSetToTableModel(rs));
					datebox.setSelectedIndex(0);
					ocubox.setSelectedIndex(0);
				}
					else
					{
						exceptiontxt.setText("flight does not exist");
					}
				}
				else if(ocu!=0 || datesel!=0)
				{
					ResultSet rs=null;
					int temp=0;
					String str="select * from flight where owner=? and ";
					if(datesel!=0)
					{
						temp++;
						if(datesel==1)
						str=str+"Date>=? ";
						else if(datesel==2)
						str=str+"Date>?";
						else if(datesel==3)
						str=str+"Date=?";
					    else if(datesel==4)
						str=str+"Date<=?";
						else if(datesel==5)
						str=str+"Date<?";		
					}
					if(ocu!=0)
					{
						if(datesel!=0)
						str=str+"and ";
						temp+=2;
						if(ocu==1)
						str=str+"?<=100*((total_seats - no_of_seats_available)/(total_seats))";
						else if(ocu==2)
					    str=str+"?<100*((total_seats - no_of_seats_available)/(total_seats))";
						else if(ocu==3)
						str=str+"?=100*((total_seats - no_of_seats_available)/(total_seats))";
						else if(ocu==4)
					    str=str+"?>=100*((total_seats - no_of_seats_available)/(total_seats))";
						else if(ocu==5)
						str=str+"?>100*((total_seats - no_of_seats_available)/(total_seats))";
						
					}
					str=str+";";
					PreparedStatement ps=conn.prepareStatement(str);
					ps.setString(1,user);
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					if(temp==1)
					{
						ps.setString(2,dateFormat.format(aftertxt.getDate()).toString());
						rs=ps.executeQuery();
						table_2.setModel(DbUtils.resultSetToTableModel(rs));
					}
					else if(temp==2)
					{
						ps.setInt(2,Integer.parseInt(ocutxt.getText()));
						rs=ps.executeQuery();
						table_2.setModel(DbUtils.resultSetToTableModel(rs));
					}
					else if(temp==3)
					{
						ps.setString(2,dateFormat.format(aftertxt.getDate()).toString());
						ps.setInt(3,Integer.parseInt(ocutxt.getText()));
						rs=ps.executeQuery();
						table_2.setModel(DbUtils.resultSetToTableModel(rs));
					}
				}
				else
				{
					PreparedStatement ps=conn.prepareStatement("select * from flight where Fno is null");
					ResultSet r=ps.executeQuery();
					table_2.setModel(DbUtils.resultSetToTableModel(r));
					datebox.setSelectedIndex(0);
					ocubox.setSelectedIndex(0);
				}
				
				}
				catch(Exception exception)
				{
					try
					{
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/airlines","root","Surya72");
					PreparedStatement ps=conn.prepareStatement("select * from flight where Fno is null");
					datebox.setSelectedIndex(0);
					ocubox.setSelectedIndex(0);
					ResultSet r=ps.executeQuery();
					table_2.setModel(DbUtils.resultSetToTableModel(r));
					//System.out.println(exception.getMessage());
					if(exception.getMessage().matches("Incorrect DATE value:.*"))
					{
						exceptiontxt.setText("Please enter a valid date in format YYYY-MM-DD");
						datebox.setSelectedIndex(0);
					}
					if(exception.getMessage().matches("For input string:.*") ||(Integer.parseInt(ocutxt.getText())>100 && Integer.parseInt(ocutxt.getText())<0))
					{
						exceptiontxt.setText("Please enter a value between 0 to 100");
						ocubox.setSelectedIndex(0);
					}
					}
					catch(Exception exp)
					{
						System.out.println(exp);
					}
				}
			}
		});
	}
}
