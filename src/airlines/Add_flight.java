package airlines;


import java.util.*;
import java.sql.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import cambodia.raven.Time;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;

public class Add_flight extends JFrame {

	private JPanel contentPane;
	private JTextField flightnotxt;
	private JTextField fromtxt;
	private JTextField totxt;
	private JTextField seatstxt;
	private JTextField faretxt;
	private JTextField stimetxt;
	private JTextField etimetxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_flight frame = new Add_flight(null);
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
	public Add_flight(String user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 656);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		flightnotxt = new JTextField();
		flightnotxt.setBackground(Color.WHITE);
		flightnotxt.setBounds(190, 51, 116, 22);
		contentPane.add(flightnotxt);
		flightnotxt.setColumns(10);
		
		fromtxt = new JTextField();
		fromtxt.setColumns(10);
		fromtxt.setBounds(190, 90, 116, 22);
		contentPane.add(fromtxt);
		
		totxt = new JTextField();
		totxt.setColumns(10);
		totxt.setBounds(190, 139, 116, 22);
		contentPane.add(totxt);
		
		seatstxt = new JTextField();
		seatstxt.setColumns(10);
		seatstxt.setBounds(190, 182, 116, 22);
		contentPane.add(seatstxt);
		
		faretxt = new JTextField();
		faretxt.setColumns(10);
		faretxt.setBounds(190, 228, 116, 22);
		contentPane.add(faretxt);
		
		JLabel fno = new JLabel("FLIGHT_NO");
		fno.setFont(new Font("Tahoma", Font.BOLD, 12));
		fno.setBounds(44, 54, 122, 16);
		contentPane.add(fno);
		
		JLabel from = new JLabel("FROM");
		from.setFont(new Font("Tahoma", Font.BOLD, 12));
		from.setBounds(44, 93, 56, 16);
		contentPane.add(from);
		
		JLabel to = new JLabel("TO");
		to.setFont(new Font("Tahoma", Font.BOLD, 12));
		to.setBounds(44, 142, 56, 16);
		contentPane.add(to);
		
		JLabel totalseats = new JLabel("TOTAL NO OF SEATS");
		totalseats.setFont(new Font("Tahoma", Font.BOLD, 12));
		totalseats.setBounds(44, 185, 134, 16);
		contentPane.add(totalseats);
		
		JLabel fare = new JLabel("FARE");
		fare.setFont(new Font("Tahoma", Font.BOLD, 12));
		fare.setBounds(44, 231, 56, 16);
		contentPane.add(fare);
		
		stimetxt = new JTextField();
		stimetxt.setColumns(10);
		stimetxt.setBounds(190, 324, 116, 22);
		contentPane.add(stimetxt);
		
		JLabel error = new JLabel("");
		error.setBounds(356, 231, 187, 16);
		contentPane.add(error);
		
		JLabel date = new JLabel("DATE");
		date.setFont(new Font("Tahoma", Font.BOLD, 12));
		date.setBounds(44, 275, 56, 16);
		contentPane.add(date);
		
		JLabel starttime = new JLabel("START TIME");
		starttime.setFont(new Font("Tahoma", Font.BOLD, 12));
		starttime.setBounds(44, 324, 81, 16);
		contentPane.add(starttime);
		
		JLabel endtime = new JLabel("END TIME");
		endtime.setFont(new Font("Tahoma", Font.BOLD, 12));
		endtime.setBounds(44, 373, 81, 16);
		contentPane.add(endtime);
		
		etimetxt = new JTextField();
		etimetxt.setBounds(190, 370, 116, 22);
		contentPane.add(etimetxt);
		etimetxt.setColumns(10);
		
		JButton btnNewButton = new JButton("");
		Image img=new ImageIcon(this.getClass().getResource("/back-icon (1).png")).getImage();
		btnNewButton.setIcon(new ImageIcon(img));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				selection sel=new selection(user);
				sel.show();
				dispose();
			}
		});
		btnNewButton.setBounds(0, 0, 49, 40);
		contentPane.add(btnNewButton);
		
		JDateChooser datetxt = new JDateChooser();
		datetxt.setBounds(190, 275, 116, 22);
		datetxt.setDateFormatString("YYYY-MM-dd");
		LocalDate dates=java.time.LocalDate.now();
		Date date1 = java.sql.Date.valueOf(dates);
		datetxt.setMinSelectableDate(date1);		
		contentPane.add(datetxt);
		
		JButton addtoflight = new JButton("ADD FLIGHT");
		addtoflight.setBackground(Color.ORANGE);
		addtoflight.setFont(new Font("Tahoma", Font.BOLD, 12));
		addtoflight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					error.setText("");
					if(flightnotxt.getText().matches(""))
					{
						error.setText("Please enter Flight Number");
					}
					else if(fromtxt.getText().matches(""))
					{
						error.setText("please enter from location details");
					}
					else if(totxt.getText().matches(""))
					{
						error.setText("please enter to location details");
					}
					else if(!stimetxt.getText().matches("^[0-9][0-9]:[0-9]{2}:[0-9]{2}$"))
					{
						error.setText("please enter start time in format HH:MM:SS");
					}
					else if(!etimetxt.getText().matches("^[0-9][0-9]:[0-9]{2}:[0-9]{2}$"))
					{
						error.setText("please enter end time in format HH:MM:SS");
					}
					else if(stimetxt.getText().compareTo("24:00:00")>=0)
					{
						error.setText("starttime is incorrect");
					}
					else if(etimetxt.getText().compareTo("24:00:00")>=0)
					{
						error.setText("endtime is incorrect");
					}
					else if(datetxt.getDate().toString().compareTo(java.time.LocalDate.now().toString())<=0)
					{
						error.setText("date is invalid");
					}
					else if(seatstxt.getText().equals("") || Integer.parseInt(seatstxt.getText())<=0)
					{
						error.setText("Number of seats must be integers and positive");
						System.out.println("hai");
					}
					else
					{
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/airlines","root","Surya72");
					PreparedStatement ps=conn.prepareStatement("insert into flight(Fno,arrival,departure,start_time,end_time,total_seats,owner,no_of_seats_available,fare,date) values(?,?,?,?,?,?,?,?,?,?)");
					ps.setString(1,flightnotxt.getText());
					ps.setString(2,fromtxt.getText().toUpperCase());
					ps.setString(3, totxt.getText().toUpperCase());
					ps.setString(4,stimetxt.getText());
					ps.setString(5,etimetxt.getText());
					ps.setString(6, seatstxt.getText());
					ps.setString(7,user);
					ps.setString(8, seatstxt.getText());
					ps.setString(9, faretxt.getText());
					ps.setString(10,dateFormat.format(datetxt.getDate()).toString());
					int x=ps.executeUpdate();
					if(x==1)
					{
						System.out.println("Sucessfull");
						error.setText("SUCCESSFUL");
					}
					else
					{
						System.out.println("failed");
					}
					}
					
				}
				catch(Exception exception)
				{
					System.out.println(exception.getMessage());
					if(exception.getMessage().matches("Cannot add or update a child row: a foreign key constraint fails.*"))
					{
						error.setText("check locations");
					}
					else if(exception.getMessage().matches("For input string: .*"))
					{
						error.setText("Number of seats must be integers and positive");
					}
					else if(exception.getMessage().matches("^Incorrect integer value:.*"))
					{
						error.setText("fare must be positive and integer");
					}
					else if(exception.getMessage().matches("^Data truncation: Incorrect time value: .*for column 'end_time' at row 1$"))
					{
						error.setText("endtime time is incorrect");
					}
					else if(exception.getMessage().matches("^Data truncation: Incorrect time value: .*for column 'start_time' at row 1$"))
					{
						error.setText("starttime time is incorrect");
					}
				}
			}
		});
		addtoflight.setBounds(395, 181, 116, 25);
		contentPane.add(addtoflight);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(airlines.Add_flight.class.getResource("/images/Background12.jpg")));
		lblNewLabel.setBounds(0, 0, 786, 619);
		contentPane.add(lblNewLabel);
	}
}
