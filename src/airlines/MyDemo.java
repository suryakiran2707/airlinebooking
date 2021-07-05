package airlines;

import java.lang.reflect.Array;
import java.sql.*;

public class MyDemo
{
	// JDBC driver name and database URL
	 static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	 static final String DB_URL = "jdbc:mysql://localhost/airlines";
	 
	//  Database credentials
	   static final String USER = "root";
	   static final String PASS = "Surya72";
	   
	   //Variables
	   public static int m;
	   public static String[] strq;
	   public static String[] destq;
	   public static Time[] stimeq;
	   public static Time[] etimeq;
	   public static int[] fareq;
	   public static Date[] dateq;

 	   public static void main(String[] args) 
	   {
		   Connection conn = null;
		   Statement stmt = null;
		   
		   
		   try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");
      
		      //STEP 3: Open a connection
		      System.out.println("Connecting to a selected database...");
		      conn = DriverManager.getConnection(DB_URL, USER, PASS);
		      System.out.println("Connected database successfully...");
		      
		      //STEP 4: Execute a query
		      System.out.println("Creating statement...");
		      stmt = conn.createStatement();

		      PreparedStatement pst = conn.prepareStatement("select max(booking_no) from user_flight where uid=?");
		      pst.setString(1, Main1.User_id);
		      ResultSet rs = pst.executeQuery();
		      
		      //STEP 5: Extract data from result set
		      while(rs.next()){
		         //Retrieve by column name
		         m = rs.getInt("max(booking_no)"); 
		         
		         //Display values
		         System.out.println("no of bookings: " + m);
		      }
		      
		          
		      if(m!=0)
		      {
		    	//Arrays Declarations
				   strq = (String[]) Array.newInstance(String.class,25*m);
				   destq = (String[]) Array.newInstance(String.class,25*m);
				   stimeq = (Time[]) Array.newInstance(Time.class,25*m);
				   etimeq = (Time[]) Array.newInstance(Time.class, m*25);
				   fareq = (int[]) Array.newInstance(int.class, m*25);
				   dateq = (Date[]) Array.newInstance(Date.class, m*25);
				  
		    	  String sql = "select arrival,departure,start_time,end_time,fare,date from User_Flight u,Flight f where u.Fno=f.Fno and Uid=? group by booking_no";
		    	  pst=conn.prepareStatement(sql);
		    	  pst.setString(1, Main1.User_id);
			      rs = pst.executeQuery();
			      int i=0;
			      while(rs.next())
			      {
			    	  Array.set(strq, i,rs.getString("arrival")); 
			    	  Array.set(destq, i,rs.getString("departure"));
			    	  Array.set(stimeq, i,rs.getTime("start_time"));
			    	  Array.set(etimeq, i,rs.getTime("end_time"));
			    	  Array.set(fareq, i,rs.getInt("fare"));
			    	  Array.set(dateq, i,rs.getDate("date"));
			    	  i++;
			    	  
			      }
		      }
		      rs.close();
		   }
		   catch(SQLException se){
			      //Handle errors for JDBC
			      se.printStackTrace();
			   }catch(Exception e){
			      //Handle errors for Class.forName
			      e.printStackTrace();
			   }finally{
			      //finally block used to close resources
			      try{
			         if(stmt!=null)
			            conn.close();
			      }catch(SQLException se){
			      }// do nothing
			      try{
			         if(conn!=null)
			            conn.close();
			      }catch(SQLException se){
			         se.printStackTrace();
			      }//end finally try
			   }//end try
			   System.out.println("Goodbye!");
	   }
}


