package airlines;
import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableColumn;
import javax.swing.text.TableView.TableRow;

import net.proteanit.sql.DbUtils;

import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.Font;

public class Customerdetails extends JFrame {

	private JPanel contentPane;
	private JTextField flightnotxt;
	private JTable tablebox;
	private JScrollPane scrollPane;
	private JLabel search;
	private JComboBox search_box;
	private JTextField searchtxt;
	private JComboBox agebox;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customerdetails frame = new Customerdetails(null);
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
	public Customerdetails(String user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 956, 704);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 204, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		flightnotxt = new JTextField();
		flightnotxt.setBounds(291, 28, 116, 22);
		contentPane.add(flightnotxt);
		flightnotxt.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 191, 842, 417);
		contentPane.add(scrollPane);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(233, 109, 199, 16);
		contentPane.add(lblNewLabel);
		
		search = new JLabel("SEARCH BY");
		search.setFont(new Font("Tahoma", Font.BOLD, 14));
		search.setBounds(257, 125, 97, 16);
		contentPane.add(search);
		
		search_box = new JComboBox();
		search_box.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		search_box.addItem("select attribute");
		search_box.addItem("Name");
		search_box.addItem("age");
		search_box.addItem("phone number");
		search_box.setBounds(388, 123, 122, 22);
		contentPane.add(search_box);
		
		searchtxt = new JTextField();
		searchtxt.setBounds(625, 123, 116, 22);
		contentPane.add(searchtxt);
		searchtxt.setColumns(10);
		agebox = new JComboBox();
		agebox.addItem("=");
		agebox.addItem(">");
		agebox.addItem("<");
		agebox.setBounds(539, 123, 44, 22);
		contentPane.add(agebox);
		agebox.setVisible(false);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		comboBox.addItem("Sort by");
		comboBox.addItem("Age decreasing");
		comboBox.addItem("Age increasing");
		comboBox.addItem("Seat numbers incrasing");
		comboBox.setBounds(622, 28, 139, 22);
		contentPane.add(comboBox);
		search_box.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent arg0) {
						int t=search_box.getSelectedIndex();
						if(t==2)
						{
							agebox.setVisible(true);
						}
						else
						{
							agebox.setVisible(false);
						}
					}
				});
		
		//TableRow sno=new TableRow("1");
		tablebox = new JTable();
		scrollPane.setViewportView(tablebox);
		JButton flightbtn = new JButton("SEARCH");
		flightbtn.setFont(new Font("Tahoma", Font.BOLD, 13));
		flightbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					lblNewLabel.setText("");
					if(flightnotxt.getText().equals(""))
					{
						lblNewLabel.setText("Please enter Flight no");
					}
					else
					{
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/airlines","root","Surya72");
					String str="select uid userid,p_no,p_name,p_age,p_gender,p_phone,seat_no from user_flight where Fno=?";
					String str1="select count(*) from user_flight where Fno=?";	
										
					PreparedStatement ps1=conn.prepareStatement("select * from flight where owner=? and fno=?");					
					// dont forgot to add user
					ps1.setString(1, user);
					ps1.setString(2,flightnotxt.getText());
					ResultSet r;
					r=ps1.executeQuery();
					int x=0;
					int item=comboBox.getSelectedIndex();
					int ser=search_box.getSelectedIndex();
					while(r.next())
						x++;
					
					// dont forgot to change 1 and 2 in below
					if(x==0)
					{
						PreparedStatement p=conn.prepareStatement("select uid userid,p_no,p_name,p_age,p_gender,p_phone,seat_no from user_flight where Fno is null");
						ResultSet rto=p.executeQuery();
						tablebox.setModel(DbUtils.resultSetToTableModel(rto));
						lblNewLabel.setText("Flight does not exist");
						comboBox.setSelectedIndex(0);
						search_box.setSelectedIndex(0);
					}
					if(x==1 && ser==1)
					{
						str=str+" and p_name=?";
					}
					else if(x==1 && ser==2)
					{
						if(agebox.getSelectedIndex()==0)
						str=str+"and p_age=?";
						else if(agebox.getSelectedIndex()==1)
						str=str+"and p_age>?";
						else if(agebox.getSelectedIndex()==2)
						str=str+"and p_age<?";
					}
					else if(x==1 && ser==3)
					{
						str=str+"and p_phone=?";
					}
					if(x==1 && item==1)
					{
						str=str+" order by p_age desc";
					}
					else if(x==1 && item==2)
					{
						str=str+" order by p_age asc";
					}
					else if(x==1 && item==3)
					{
						str=str+" order by seat_no asc";
					}
					str=str+";";
					if(x!=0)
					{
					PreparedStatement ps=conn.prepareStatement(str);
					ps.setString(1,flightnotxt.getText());
					if(ser!=0)
					{
						ps.setString(2, searchtxt.getText());
					}
					ResultSet rs=ps.executeQuery();
					tablebox.setModel(DbUtils.resultSetToTableModel(rs));
					}
					}
					
				}
				catch(Exception exception)
				{
					System.out.println(exception.getMessage());					
				}
			}
		});
		flightbtn.setBounds(370, 71, 97, 25);
		contentPane.add(flightbtn);
		
		btnNewButton = new JButton("");
		Image img=new ImageIcon(this.getClass().getResource("/back-icon (1).png")).getImage();
		btnNewButton.setIcon(new ImageIcon(img));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selection af=new selection(user);
				af.show();
				dispose();
			}
		});
		btnNewButton.setBounds(0, 0, 56, 50);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("FLIGHT NO");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(167, 31, 97, 16);
		contentPane.add(lblNewLabel_1);
	}
}
