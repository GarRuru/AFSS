package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Date_data extends Connect_data {
	  private String dropdbSQL = "DROP TABLE  Date"; 
	  
	  private String createdbSQL = "CREATE TABLE Date (" + 
			    "    Date_id            INTEGER " +
			    "  , Date_time          VARCHAR(20) )"
		       ; 
	  private String insertdbSQL = "insert into Date(Date_id,Date_time) " + 
	      "select ifNULL(max(Date_id),0)+1,? FROM Date"; 
	  private String selectCountSQL = "SELECT COUNT(*) FROM Date";   
	  private String selectSQL = "select * from Date "; 
	  private String setPrimaryKey="ALTER TABLE Date ADD PRIMARY KEY(Date_id)";
	  private String selectDate="";
	  public Date_data() 
	  {  
		  connect_data();
	  } 
	  //«Ø¥ßtableªº¤è¦¡ 
	  public void createTable() 
	  { 
	    try 
	    { 
	      stat = con.createStatement(); 
	      stat.executeUpdate(createdbSQL); 
	      stat.executeUpdate(setPrimaryKey); 
	    } 
	    catch(SQLException e) 
	    { 
	      System.out.println("CreateDB  DateTable createTable Exception :" + e.toString()); 
	    } 
	    finally 
	    { 
	      Close(); 
	    } 
	  } 
	  //·s¼W¸ê®Æ 
	  public void insertTable(String Date_time) 
	  { 
	    try 
	    { 
	      pst = con.prepareStatement(insertdbSQL); 
	      
	      pst.setString(1,Date_time); 
	      
	      
	      pst.executeUpdate(); 
	    } 
	    catch(SQLException e) 
	    { 
	      System.out.println("InsertDB DateTable insertTable Exception :" + e.toString()); 
	    } 
	    finally 
	    { 
	      Close(); 
	    } 
	  } 
	  
	  public int SelectDate(String Date) {
		  selectDate="select Date_id from Date where Date_time='"+Date+"'";
		  int DateID=0;
		  try 
		    { 
			
		      stat = con.createStatement(); 
		      rs = stat.executeQuery(selectDate); 
		     // System.out.println(selectDate);	
		      while(rs.next()){
		    	    DateID=rs.getInt("Date_id");
		    	//    System.out.println("Date_id="+rs.getInt("Date_id"));	
				  }
		     
		    } 
		    catch(SQLException e) 
		    { 
		      System.out.println("DropDB  DateTable SelectDate Exception :" + e.toString()); 
		    } 
		    finally 
		    { 
		      Close(); 
		    } 
		  return DateID;
	  } 
	  
	  
	  
	  // count¸ê®Æªº¸ê®Æ
	  public int CountData() 
	  { 
		int count=0;
	    try 
	    { 
	      int temp=0;
	      stat = con.createStatement(); 
	      rs = stat.executeQuery(selectCountSQL); 
	      
	      while(rs.next()){
	    	    count=rs.getInt("COUNT(*)");
	    	    System.out.println("COUNT(*)="+rs.getInt("COUNT(*)"));	
			  }
	     
	    } 
	    catch(SQLException e) 
	    { 
	      System.out.println("DropDB DateTable CountData Exception :" + e.toString()); 
	    } 
	    finally 
	    { 
	      Close(); 
	    } 
	     return count;
	  } 
	  // §R°£table¤ºªº©Ò¦³¸ê®Æ
	  public void deleteData() 
	  { 
	    try 
	    { 
	      stat = con.createStatement(); 
	      stat.executeUpdate("DELETE  FROM Date"); 
	    } 
	    catch(SQLException e) 
	    { 
	      System.out.println("DropDB  DateTable deleteData Exception :" + e.toString()); 
	    } 
	    finally 
	    { 
	      Close(); 
	    } 
	  } 
	  // ¿ï¾Ü¸ê®Æ
	  public void SelectData(int[] a) 
	  { 
		  try 
		    { 
			  int temp=0;
		      stat = con.createStatement(); 
		      rs = stat.executeQuery(selectSQL); 
		      System.out.println("Date_ID\t\tDateTime"); 
		      while(rs.next()) 
		      { 
		        System.out.println(rs.getInt("Date_id")+"\t\t"+ 
		            rs.getString("Date_time")); 
		       // a[temp]=rs.getInt("Day");   
	            //temp++;
		      } 
		    } 
		    catch(SQLException e) 
		    { 
		      System.out.println("DropDB DateTable SelectData Exception :" + e.toString()); 
		    } 
		    finally 
		    { 
		      Close(); 
		    } 
		  } 
	     
	  //§R°£Table, 
	  public void dropTable() 
	  { 
	    try 
	    { 
	      stat = con.createStatement(); 
	      stat.executeUpdate(dropdbSQL); 
	    } 
	    catch(SQLException e) 
	    { 
	      System.out.println("DropDB  DateTable dropTable Exception :" + e.toString()); 
	    } 
	    finally 
	    { 
	      Close(); 
	    } 
	  } 
	  //¬d¸ß¸ê®Æ 
	  public void SelectTable() 
	  { 
	    try 
	    { 
	      stat = con.createStatement(); 
	      rs = stat.executeQuery(selectSQL); 
	      System.out.println("Date_ID\t\tDateTime"); 
	      while(rs.next()) 
	      { 
	        System.out.println(rs.getInt("Date_id")+"\t\t"+ 
	            rs.getString("Date_time")); 
	      } 
	    } 
	    catch(SQLException e) 
	    { 
	      System.out.println("DropDB  DateTable SelectTable Exception :" + e.toString()); 
	    } 
	    finally 
	    { 
	      Close(); 
	    } 
	  } 
}
