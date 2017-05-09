package com.javaworld.sample.helloservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MedicalRecordsImpl implements MedicalRecords {
	
	public Connection connection;

	
	public MedicalRecordsImpl() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("Cannot find the driver in the classpath!", e);
		}

		String url = "jdbc:mysql://127.0.0.1:3306/psychiatry?useUnicode=true&characterEncoding=utf-8";
		String username = "root";
		String password = "";
		
		try (Connection connection = DriverManager.getConnection(url, username, password)) {
			
			
		} catch (SQLException e) {
			throw new IllegalStateException("Cannot connect the database!", e);
		}
		
		connection = DriverManager.getConnection(url, username, password);

	}
	
	public boolean updateRecord(int PatientID, String Name, String Surname, String DOB, String Telephone, String Address,String Sex){
		

		String query = "Select * from patient where ID = ? AND Dead = 1";
		 
	      
		 try {
			PreparedStatement preparedStmt = connection.prepareStatement(query);
			preparedStmt.setInt (1, PatientID);
			
		  

		    ResultSet result = preparedStmt.executeQuery();
		    if(result.next()) return false;
		    
		    
			query = "UPDATE patient SET Name = ? , Surname = ?, DOB = ?,Sex = ?, Telephone = ?, Address = ?, ChangedRecord = ? WHERE ID = ? AND Dead = ?";

			preparedStmt = connection.prepareStatement(query);
			preparedStmt.setString (1, Name);
			preparedStmt.setString (2, Surname);
			preparedStmt.setString (3, DOB);
			preparedStmt.setString (4, Sex);

			preparedStmt.setString (5, Telephone);
			preparedStmt.setString (6, Address);
			preparedStmt.setBoolean(7,true);
			preparedStmt.setInt (8, PatientID);
			preparedStmt.setInt (9, 0);

			preparedStmt.execute();
			
	    
		    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	      
	    return true;
		
	}
	
	
	
}
