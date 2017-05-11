package com.javaworld.sample.helloservice;

import java.util.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.sql.*;

public class ClinicalStaffImpl implements ClinicalStaff {

	public Connection connection;

	
	public ClinicalStaffImpl() throws SQLException {
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
	
	
	public boolean getPatient(ArrayList<Object[]> Q){
		 
		try {
			Statement stm = connection.createStatement();
			 String Query = "Select * from Patient where Dead=0";
			 ResultSet result;
			result = stm.executeQuery(Query);			
			
			while(result.next()){
				 Q.add(new Object[]{result.getString("ID"),result.getString("Name"),result.getString("Surname"), result.getString("DOB"),result.getString("Sex"), result.getString("Suicide"),result.getString("Diagnosis"),result.getString("Prescription"),result.getString("NeedsUpdate"),result.getString("DropIn")}); 
				 
			 }
			
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	
		return true;
		 
	}
	
	public boolean isDiagnosisTheSame(String Diagnosis,int PatientID){
		
		String query = "Select * from patient where Diagnosis=? AND ID=?";
		
		 
	      
		 try {
			PreparedStatement preparedStmt = connection.prepareStatement(query);
			preparedStmt.setString (1, Diagnosis);
			preparedStmt.setInt (2, PatientID);
		  

		    ResultSet result = preparedStmt.executeQuery();
		    if(result.next()){
		    	return true;
		    }
		    else{
		    	return false;
		    }
		    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	      
	    
		
		
	}
	
public boolean changeDiagnosis(String Diagnosis,int PatientID){
		
		String query = "UPDATE patient SET Diagnosis = ? , NeedsUpdate = 0 WHERE ID = ? AND Dead = 0";

		
		 
	      
		 try {
			PreparedStatement preparedStmt = connection.prepareStatement(query);
			preparedStmt.setString (1, Diagnosis);
			preparedStmt.setInt (2, PatientID);
		  

		    preparedStmt.execute();
		    
		    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	      
	    return true;
		
		
	}


	public boolean isPrescriptionTheSame(String Prescription,int PatientID){
		String query = "Select * from patient where Prescription=? AND ID=?";
		
		 
	      
		 try {
			PreparedStatement preparedStmt = connection.prepareStatement(query);
			preparedStmt.setString (1, Prescription);
			preparedStmt.setInt (2, PatientID);
		  

		    ResultSet result = preparedStmt.executeQuery();
		    if(result.next()){
		    	return true;
		    }
		    else{
		    	return false;
		    }
		    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean changePrescription(String Prescription,int PatientID){
		
		String query = "UPDATE patient SET Prescription = ?, NeedsUpdate = 0 WHERE ID = ?";

		
		 
	      
		 try {
			PreparedStatement preparedStmt = connection.prepareStatement(query);
			preparedStmt.setString (1, Prescription);
			preparedStmt.setInt (2, PatientID);
		  

		    preparedStmt.execute();
		    
		    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		 
		 return true;
	      
	    
		
		
	}
	
	public boolean viewDrugs(ArrayList<Object[]> Q){
		
		
		try {
			Statement stm = connection.createStatement();
			String Query = "Select * from drug";
			ResultSet result;
			result = stm.executeQuery(Query);

			while (result.next()) {
				Q.add(new Object[] { result.getString("DrugName"), result.getString("SideEffects")});

			}
		} catch (SQLException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;
		    
		
	      
	}
	
	public boolean updateLater(int PatientID){
		String query = "UPDATE patient SET NeedsUpdate = ? WHERE ID = ?";

		
		 
	      
		 try {
			PreparedStatement preparedStmt = connection.prepareStatement(query);
			preparedStmt.setBoolean (1, true);
			preparedStmt.setInt (2, PatientID);
		  

		    preparedStmt.execute();
		    
		    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		 
		 return true;
	}
	
	public boolean getNeedsUpdate(ArrayList<Object[]> Q){
		try {
			Statement stm = connection.createStatement();
			String Query = "Select * from patient where NeedsUpdate = 1";
			ResultSet result;
			result = stm.executeQuery(Query);

			while (result.next()) {
				Q.add(new Object[] {result.getString("ID"), result.getString("Name"),result.getString("Surname"), result.getString("DOB"),result.getString("Sex"), result.getString("Suicide"),result.getString("Diagnosis"), result.getString("Prescription")});

			}
		} catch (SQLException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;
		    
	}
	
	public boolean getSuicidal(ArrayList<Object[]> Q){
		try {
			Statement stm = connection.createStatement();
			String Query = "Select * from patient where Suicide = 1 ";
			ResultSet result;
			result = stm.executeQuery(Query);

			while (result.next()) {
				Q.add(new Object[] {result.getString("ID"), result.getString("Name"),result.getString("Surname"), result.getString("Suicide"),result.getString("Diagnosis"), result.getString("Prescription")});

			}
		} catch (SQLException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;
		    
	}
		
	
	
	public boolean addIncident(int PatientID, String iDate, String Description){
		String query = "INSERT INTO incident(PatientID,IncidentDate,Description) Values (?,?,?)";
		
		 
	      
		 try {
			PreparedStatement preparedStmt = connection.prepareStatement(query);
			preparedStmt.setInt (1, PatientID);
			preparedStmt.setString (2, iDate);
		    preparedStmt.setString (3, Description);
		   


		    preparedStmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	      
	     return true;
	}
	
	public boolean addAccident(int PatientID, String iDate, String Description, String DrugName){
		String query = "INSERT INTO accidentalIncident(PatientID,IncidentDate,Description,DrugName) Values (?,?,?,?)";
		
		 
	      
		 try {
			PreparedStatement preparedStmt = connection.prepareStatement(query);
			preparedStmt.setInt (1, PatientID);
			preparedStmt.setString (2, iDate);
		    preparedStmt.setString (3, Description);
		    preparedStmt.setString (4, DrugName);
		   


		    preparedStmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	      
	     return true;
	}
	
	public boolean getIncidents(ArrayList<Object[]> Q){
		try {
			Statement stm = connection.createStatement();
			String Query = "Select * from incident";
			ResultSet result;
			result = stm.executeQuery(Query);

			while (result.next()) {
				Q.add(new Object[] {result.getString("IncidentID"),result.getString("PatientID"),result.getString("IncidentDate"),result.getString("Description")});

			}
		} catch (SQLException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;
	}
	
	public boolean getAccidents(ArrayList<Object[]> Q){
		try {
			Statement stm = connection.createStatement();
			String Query = "Select * from accidentalIncident";
			ResultSet result;
			result = stm.executeQuery(Query);

			while (result.next()) {
				Q.add(new Object[] {result.getString("IncidentID"),result.getString("PatientID"),result.getString("IncidentDate"),result.getString("Description"),result.getString("DrugName")});

			}
		} catch (SQLException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;
	}
	
	public boolean getAllergies(ArrayList<Object[]> Q){
		try {
			Statement stm = connection.createStatement();
			String Query = "Select * from allergy";
			ResultSet result;
			result = stm.executeQuery(Query);

			while (result.next()) {
				Q.add(new Object[] {result.getString("PatientID"),result.getString("DrugName")});

			}
		} catch (SQLException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;
	}
	
	public boolean isAllergic(int PatientID, String DrugName){
		
			
			String Query = "Select * from allergy where PatientID = ? AND DrugName = ?";
			
			
			 try {
					PreparedStatement preparedStmt = connection.prepareStatement(Query);
					preparedStmt.setInt (1, PatientID);
					preparedStmt.setString (2, DrugName);
				    


				    ResultSet result = preparedStmt.executeQuery();
				    if(result.next()){
				    	return true;
				    }
				    else{
				    	return false;
				    }
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return false;
			}
			 
			
			      
			     
	}
	
	public boolean addAllergy(int PatientID, String DrugName){
		String query = "INSERT INTO allergy(PatientID,DrugName) Values (?,?)";
		
		 
	      
		 try {
			PreparedStatement preparedStmt = connection.prepareStatement(query);
			preparedStmt.setInt (1, PatientID);
			preparedStmt.setString (2, DrugName);
		    


		    preparedStmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	      
	     return true;
	}
	
	
	

}
