package com.wallmart.authenticationfilter;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.wallmart.dao.WallmartDBConnection;
import com.wallmart.dto.WallmartDTO;

public class Autthentication {
	private  Connection connection;
	private  Statement stmt;
	//String QUERY_PART1 = "SELECT USER_NAME, USER_ID, PASSWORD FROM  USER_CREDENTIAL  WHERE"; 
	String QUERY_PART1 = "SELECT USER_NAME, USER_ID, PASSWORD FROM USER_CREDENTIAL" + " WHERE USER_ID >= 101 ";
	
	public void Autthentication(){
		
		

	}

public boolean userAuthentication(String userID, String password){
	boolean validation_flag = false;
	String userCredential_ID = "dilip";
	String userCredential_Password = "abcd";
	
	System.out.println(">>>>>>>>>>>>>>>>>>> In userAuthentication --------------"+WallmartDBConnection.getConnection());
	
	try{
	connection = (Connection)WallmartDBConnection.getConnection();
	System.out.println("connection :: "+connection);
	
	}
	catch(Exception e){
		e.printStackTrace();
	}
	
	if(userCredential_ID.equalsIgnoreCase(userID) && userCredential_Password.equals(password)){
		System.out.println("--------- Valid userID --------"+userID);
		System.out.println("--------- Valid userID --------"+password);
		try{
			if(connection != null){
				 stmt = (Statement)connection.createStatement();	
				 if(stmt != null){
					// ResultSet rset = stmt.executeQuery("SELECT USER_NAME, USER_ID, PASSWORD FROM " + "USER_CREDENTIAL" + " WHERE USER_ID = "  + "'"+currentData1+"'" +  " AND " +"'"+currentData2+"'");
					 ResultSet	rset =stmt.executeQuery( "select user_name,user_id, password from user_credentials where password='walcome1' and user_id='msajid122@nile';");
					   while (rset.next())
	                    {
	                   
	                    String uID = rset.getString("user_id");
	                    String pwd = rset.getString(password);
	                    System.out.println("----------- uID -------------::"+uID);
	                    System.out.println("----------- pwd -------------::"+pwd);
	                   
	                    }
				 }
			}
			else
				System.out.print("Connection is null>>>>>>>::");
			}
			catch(SQLException e){
				e.printStackTrace();
			}
			
		validation_flag = true;
	}
	else{
		validation_flag = false;
	}
	
	
	return validation_flag;
}
}
