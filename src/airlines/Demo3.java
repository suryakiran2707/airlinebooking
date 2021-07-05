package airlines;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;

public class Demo3 {
	// JDBC driver name and database URL
		 static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
		 static final String DB_URL = "jdbc:mysql://localhost/airlines";
		 
		//  Database credentials
		   static final String USER = "root";
		   static final String PASS = "Surya72";
		   
		   
		   public static int n;
		   public static String[] name;
		   public static String[] gender;
		   public static int[] age;
		   public static int[] seatno;
		   
		   public static String[] fno;
		   public static String[] C_name;

	 	   public static void NameMethod(int i) 
		   {
			   Connection conn = null;
			   Statement stmt = null;
			   java.sql.PreparedStatement pst;
			   
			   
			   try{
			      //STEP 2: Register JDBC driver
			      Class.forName("com.mysql.jdbc.Driver");
	      
			      //STEP 3: Open a connection
			      System.out.println("Connecting to a selected database...");
			      conn = DriverManager.getConnection(DB_URL, USER, PASS);
			      System.out.println("Connected database successfully...");
			      
			      //STEP 4: Execute a query
			      System.out.println("Creating statement...");
			      
			      //stmt = conn.createStatement();
			      pst = conn.prepareStatement("select count(*) from user_flight where uid=? and Booking_no=?");
			      pst.setString(1, Main1.User_id);
		          pst.setLong(2, i);
		          ResultSet rs = pst.executeQuery();

			      //String sql = ("select count(*) from user_flight where User_id=111 and Booking_no=1");
			      //ResultSet rs = stmt.executeQuery(sql);
			      
			      //STEP 5: Extract data from result set
			      while(rs.next()){
			         //Retrieve by column name
			         n = rs.getInt("count(*)"); 
			         
			         //Display values
			         System.out.println("no of passengers: " + n);
			      }
			      if(n!=0)
			      {
			    	//Arrays Declarations
					   name = (String[]) Array.newInstance(String.class, n);
					   gender = (String[]) Array.newInstance(String.class,n);
					   age = (int[]) Array.newInstance(int.class, n);
					   seatno = (int[]) Array.newInstance(int.class, n);
					  
			    	  //sql = "select P_name,P_gender,P_age,seat_no from User_Flight where User_id=111 and Booking_no=1";
				      //rs = stmt.executeQuery(sql);
					   
					   pst = conn.prepareStatement("select P_name,P_gender,P_age,seat_no from User_Flight where uid=? and Booking_no=?");
					   pst.setString(1, Main1.User_id);
				       pst.setLong(2, i);
				       rs = pst.executeQuery();
				          
				      int j=0;
				      while(rs.next())
				      {
				    	  Array.set(name, j,rs.getString("p_name")); 
				    	  Array.set(gender, j,rs.getString("p_gender"));
				    	  Array.set(age, j,rs.getInt("p_age"));
				    	  Array.set(seatno, j,rs.getInt("seat_no"));
				    	  
				    	  j++;
				    	  
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
	 	  public static void CName() 
		   {
			   Connection conn = null;
			   Statement stmt = null;
			   java.sql.PreparedStatement pst;
			   
			   
			   try{
			      //STEP 2: Register JDBC driver
			      Class.forName("com.mysql.jdbc.Driver");
	      
			      //STEP 3: Open a connection
			      System.out.println("Connecting to a selected database...");
			      conn = DriverManager.getConnection(DB_URL, USER, PASS);
			      System.out.println("Connected database successfully...");
			      
			      //STEP 4: Execute a query
			      System.out.println("Creating statement...");
			      
			      if(MyDemo.m!=0)
			      {
			    	  fno = (String[]) Array.newInstance(String.class, MyDemo.m*25);
			    	  C_name = (String[]) Array.newInstance(String.class, MyDemo.m*25);
			    	  
			    	  stmt = conn.createStatement();
				      
			
				      pst = conn.prepareStatement("select Fno from user_flight where Uid=? group by Booking_no");
				      pst.setString(1, Main1.User_id);
				      ResultSet rs = pst.executeQuery();
				      int i=0;
				      while(rs.next())
				      {
				    	  Array.set(fno, i,rs.getString("Fno"));
				    	  System.out.println(fno[i]);
				    	  i++;
				    	  
				      }
				      
				      
				      for(i=0;i<MyDemo.m;i++)
				      {
				    	  pst = conn.prepareStatement("select a.company_name from flight f,airlines a where f.owner = a.user and f.Fno=?");
					      pst.setString(1, fno[i]);
					      rs = pst.executeQuery();
					      while(rs.next())
					      {
					    	  Array.set(C_name, i,rs.getString("a.company_name"));
					    	  System.out.println(C_name[i]);
					      }
				      }
				
			      rs.close();
			   }
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
