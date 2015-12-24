package com.wallmart.dao;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class WallmartDBConnection {
    public static Connection getConnection() 
    {
        File f =  new File("C:/Users/NODE55/Documents/GitHub/pocrepo1/Wallmart/src/com/wallmart/dao/DBProperties.properties");
        Properties props = new Properties();
        FileInputStream fis = null;
        Connection con = null;
        try 
        {
            fis = new FileInputStream(f);
            props.load(fis);
 
            // load the Driver Class
            Class.forName(props.getProperty("driverclass"));
            System.out.println(props.getProperty("url"));
            System.out.println(props.getProperty("user"));
            System.out.println(props.getProperty("password"));
            System.out.println("driver class load");
 
            // create the connection now
            con = DriverManager.getConnection(props.getProperty("url"),props.getProperty("user"),props.getProperty("password"));
            System.out.println("Connection Successfull");
        } 
        catch (Exception e) 
        {
            // TODO Auto-generated catch block
        	 System.out.println("Connection Failed..");
            e.printStackTrace();
        }
        
        return con;
        
    }
//    public static void main(String as[]){
//    	new WallmartDBConnection().getConnection();    	
//    }

}

