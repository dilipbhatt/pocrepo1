package com.wallmart.authenticationfilter;

import java.sql.ResultSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.wallmart.dao.WallmartDBConnection;
import com.wallmart.dto.WallmartDTO;

public class Autthentication {
	private Connection connection;
	//String QUERY_PART1 = "SELECT USER_NAME, USER_ID, PASSWORD FROM  USER_CREDENTIAL  WHERE"; 
	String QUERY_PART1 = "SELECT USER_NAME, USER_ID, PASSWORD FROM USER_CREDENTIAL" + " WHERE USER_ID >= 101 ";
	
	public void Autthentication(){
		System.out.println("---------------- In Autthentication --------------");
		
		
		connection = (Connection)WallmartDBConnection.getConnection();
		
		//	 Statement stmt = (Statement)connection.createStatement();
		

     //    ResultSet totalCountRS = stmt.executeQuery("select count(*) from MIGRATION_TEST1_BKP");
	}
public static boolean userAuthentication(String userID, String password){
	boolean validation_flag = false;
	String userCredential_ID = "dilip";
	String userCredential_Password = "abcd";
	
	
	if(userCredential_ID.equalsIgnoreCase(userID) && userCredential_Password.equals(password)){
		System.out.println("--------- Valid userID --------"+userID);
		System.out.println("--------- Valid userID --------"+password);
		// ResultSet rset = stmt.executeQuery("SELECT USER_NAME, USER_ID, PASSWORD FROM " + "USER_CREDENTIAL" + " WHERE USER_ID = "  + "'"+currentData1+"'" +  " AND " +"'"+currentData2+"'");
			
		validation_flag = true;
	}
	else{
		validation_flag = false;
	}
	
	
	return validation_flag;
}
}
