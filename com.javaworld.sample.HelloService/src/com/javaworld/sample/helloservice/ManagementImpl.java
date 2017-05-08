package com.javaworld.sample.helloservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ManagementImpl implements Management {
	
public Connection connection;

	
	public ManagementImpl() throws SQLException {
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
	
	public boolean CalculateStatistics(int patientsPerDay[], int conditions[],int Drugs[], int Allpatients[],int myClinic){
	
		//Bipolar Disorder
		String Query = "Select COUNT(*) from patient where Diagnosis = ?";
		
		 try {
				PreparedStatement preparedStmt = connection.prepareStatement(Query);
				String c = "Διπολική Διαταραχή";
				preparedStmt.setString (1, c);
				
				ResultSet result = preparedStmt.executeQuery();
			    if(result.next()){
			    	conditions[0] = result.getInt("COUNT(*)");
			    	

			    }
			    
			    
			    //Schizo
			    preparedStmt = connection.prepareStatement(Query);
				preparedStmt.setString (1, "Σχιζοφρένεια" );
				
				result = preparedStmt.executeQuery();
			    if(result.next()){
			    	conditions[1] = result.getInt("COUNT(*)");
			    }
			    
			    //Stress Disorder
			    preparedStmt = connection.prepareStatement(Query);
				preparedStmt.setString (1, "Αγχώδεις Διαταραχή" );
				
				result = preparedStmt.executeQuery();
			    if(result.next()){
			    	conditions[2] = result.getInt("COUNT(*)");
			    }
			    
			    //Insomnia
			    preparedStmt = connection.prepareStatement(Query);
				preparedStmt.setString (1, "Αϋπνία" );
				
				result = preparedStmt.executeQuery();
			    if(result.next()){
			    	conditions[3] = result.getInt("COUNT(*)");
			    }
			    
			    //Depression
			    preparedStmt = connection.prepareStatement(Query);
				preparedStmt.setString (1, "Κατάθλιψη" );
				
				result = preparedStmt.executeQuery();
			    if(result.next()){
			    	conditions[4] = result.getInt("COUNT(*)");
			    }
			    
			    //Drug1
			    Query = "Select COUNT(*) from patient where Prescription = ? ";
			    
			    preparedStmt = connection.prepareStatement(Query);
				preparedStmt.setString (1, "Φάρμακο1" );
				
				result = preparedStmt.executeQuery();
			    if(result.next()){
			    	Drugs[0] = result.getInt("COUNT(*)");
			    }
			    
			    //Drug2
			    Query = "Select COUNT(*) from patient where Prescription = ? ";
			    
			    preparedStmt = connection.prepareStatement(Query);
				preparedStmt.setString (1, "Φάρμακο2" );
				
				result = preparedStmt.executeQuery();
			    if(result.next()){
			    	Drugs[1] = result.getInt("COUNT(*)");
			    }
			    
			    
			  //Drug3
			    Query = "Select COUNT(*) from patient where Prescription = ? ";
			    
			    preparedStmt = connection.prepareStatement(Query);
				preparedStmt.setString (1, "Φάρμακο3" );
				
				result = preparedStmt.executeQuery();
			    if(result.next()){
			    	Drugs[2] = result.getInt("COUNT(*)");
			    }
			    
			  //Drug4
			    Query = "Select COUNT(ID) from patient where Prescription = ? ";
			    
			    preparedStmt = connection.prepareStatement(Query);
				preparedStmt.setString (1, "Φάρμακο4" );
				
				result = preparedStmt.executeQuery();
			    if(result.next()){
			    	
			    	Drugs[3] = result.getInt("COUNT(ID)");
			    	
			    }
			    
			  //Drug5
			    Query = "Select COUNT(*) from patient where Prescription = ? ";
			    
			    preparedStmt = connection.prepareStatement(Query);
				preparedStmt.setString (1, "Φάρμακο5" );
				
				result = preparedStmt.executeQuery();
			    if(result.next()){
			    	Drugs[4] = result.getInt("COUNT(*)");
			    }
			    
			    //
			    
			    
			    
			    
			    Query = "SELECT DISTINCT COUNT(PatientID) FROM appointment WHERE  DATE(ADate) = DATE_SUB(CURDATE(), INTERVAL 4 DAY) AND PatientWent = 1 AND Clinic = ?";
			    
			    preparedStmt = connection.prepareStatement(Query);
				preparedStmt.setInt (1, myClinic);
			    result = preparedStmt.executeQuery();
			    if(result.next()){
			    	patientsPerDay[0] = result.getInt("COUNT(PatientID)");
			    }
			    
			    Query = "SELECT DISTINCT COUNT(PatientID) FROM appointment WHERE  DATE(ADate) = DATE_SUB(CURDATE(), INTERVAL 3 DAY) AND PatientWent = 1 AND Clinic = ?";
			    
			    preparedStmt = connection.prepareStatement(Query);
				preparedStmt.setInt (1, myClinic);
			    result = preparedStmt.executeQuery();
			    if(result.next()){
			    	patientsPerDay[1] = result.getInt("COUNT(PatientID)");
			    }
			    
			    Query = "SELECT DISTINCT COUNT(PatientID) FROM appointment WHERE  DATE(ADate) = DATE_SUB(CURDATE(), INTERVAL 2 DAY) AND PatientWent = 1 AND Clinic = ?";
			    
			    preparedStmt = connection.prepareStatement(Query);
				preparedStmt.setInt (1, myClinic);
			    result = preparedStmt.executeQuery();
			    if(result.next()){
			    	patientsPerDay[2] = result.getInt("COUNT(PatientID)");
			    }
			    
			    Query = "SELECT DISTINCT COUNT(PatientID) FROM appointment WHERE  DATE(ADate) = DATE_SUB(CURDATE(), INTERVAL 1 DAY) AND PatientWent = 1 AND Clinic = ?";
			    
			    preparedStmt = connection.prepareStatement(Query);
				preparedStmt.setInt (1, myClinic);
			    result = preparedStmt.executeQuery();
			    if(result.next()){
			    	patientsPerDay[3] = result.getInt("COUNT(PatientID)");
			    }
			    
			    Query = "SELECT DISTINCT COUNT(PatientID) FROM appointment WHERE  DATE(ADate) = DATE_SUB(CURDATE(), INTERVAL 0 DAY) AND PatientWent = 1 AND Clinic = ?";
			    
			    preparedStmt = connection.prepareStatement(Query);
				preparedStmt.setInt (1, myClinic);
			    result = preparedStmt.executeQuery();
			    if(result.next()){
			    	patientsPerDay[4] = result.getInt("COUNT(PatientID)");
			    }
			    
			    Query = "Select DISTINCT COUNT(PatientID) from appointment WHERE ADate >= curdate() - INTERVAL DAYOFWEEK(curdate())+6 DAY AND ADate < curdate() - INTERVAL DAYOFWEEK(curdate())-1 DAY";
			    preparedStmt = connection.prepareStatement(Query);
			    result = preparedStmt.executeQuery();
			    if(result.next()){
			    	Allpatients[0] = result.getInt("COUNT(PatientID)");
			    }
			    
			    
			    
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
		}
		 
		 return true;
		
		
	}
	
	public boolean getPatient(ArrayList<Object[]> Q){
		 
		try {
			Statement stm = connection.createStatement();
			 String Query = "Select * from Patient";
			 ResultSet result;
			result = stm.executeQuery(Query);			
			
			while(result.next()){
				 Q.add(new Object[]{result.getString("ID"),result.getString("Name"),result.getString("Surname"), result.getString("Diagnosis"),result.getString("Prescription")}); 
				 
			 }
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	
		return true;
		 
	}

}
