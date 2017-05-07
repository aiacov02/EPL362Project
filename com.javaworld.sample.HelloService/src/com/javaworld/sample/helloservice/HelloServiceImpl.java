package com.javaworld.sample.helloservice;
import java.sql.Connection;
import java.util.*;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.sql.*;

public class HelloServiceImpl implements HelloService {

	public Connection connection;

		
	public HelloServiceImpl() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("Cannot find the driver in the classpath!", e);
		}

		String url = "jdbc:mysql://127.0.0.1:3306/psychiatry?useSSL=false";
		String username = "root";
		String password = "";
		
		try (Connection connection = DriverManager.getConnection(url, username, password)) {
			
			
		} catch (SQLException e) {
			throw new IllegalStateException("Cannot connect the database!", e);
		}
		
		connection = DriverManager.getConnection(url, username, password);

	}
	
	public boolean insertDropIN(int PatientID){
		String query = "UPDATE patient SET DropIn = now() WHERE ID = ?";
		
		
		 try {
				PreparedStatement preparedStmt = connection.prepareStatement(query);
				preparedStmt.setInt (1, PatientID);
				


			    preparedStmt.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		      
		     return true;
		
	}
	
	public boolean insertPatient(String Name, String Surname, String DOB, String Sex, String Telephone, String Address, Boolean Suicide){
		String query = "INSERT INTO Patient(Name,Surname,DOB,Sex,Telephone,Address,Suicide) Values (?,?,?,?,?,?,?)";
		
		 
	      
		 try {
			PreparedStatement preparedStmt = connection.prepareStatement(query);
			preparedStmt.setString (1, Name);
			preparedStmt.setString (2, Surname);
		    preparedStmt.setString (3, DOB);
		    preparedStmt.setString (4, Sex);
		    preparedStmt.setString (5, Telephone);
		    preparedStmt.setString (6, Address);
		    preparedStmt.setBoolean (7, Suicide);


		    preparedStmt.execute();
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
				//System.out.println(result.getString("ID")+result.getString("Name")+result.getString("Surname")+ result.getString("DOB")+result.getString("Sex")+ result.getString("Telephone") + result.getString("Address") + result.getString("Suicide"));
				 Q.add(new Object[]{result.getString("ID"),result.getString("Name"),result.getString("Surname"), result.getString("DOB"),result.getString("Sex"), result.getString("Telephone"), result.getString("Address"), result.getString("DropIn")}); 
				 
			 }
			//System.out.println(Q.toString());
			//columns = new String[]{ "Name", "Surname", "DOB", "Sex", "Telephone", "Address", "Suicide"};
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	
		return true;
		 
	}
	
	public boolean searchPatient(ArrayList<Object[]> Q, String Name, String Surname){
		try {
			Statement stm = connection.createStatement();
			 String Query = "Select * from Patient Where Name LIKE ? OR Surname LIKE ?";
			 
			 
			PreparedStatement preparedStmt = connection.prepareStatement(Query);
			preparedStmt.setString (1, "%"+Name+"%");
			preparedStmt.setString (2, "%"+Surname+"%");
			ResultSet result;
			result = preparedStmt.executeQuery();
			 		
			
			while(result.next()){
				//System.out.println(result.getString("ID")+result.getString("Name")+result.getString("Surname")+ result.getString("DOB")+result.getString("Sex")+ result.getString("Telephone") + result.getString("Address") + result.getString("Suicide"));
				 Q.add(new Object[]{result.getString("ID"),result.getString("Name"),result.getString("Surname"), result.getString("DOB"),result.getString("Sex"), result.getString("Telephone"), result.getString("Address"), result.getString("Suicide")}); 
				 
			 }
			//System.out.println(Q.toString());
			//columns = new String[]{ "Name", "Surname", "DOB", "Sex", "Telephone", "Address", "Suicide"};
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	
		return true;
	}
	
	public boolean insertAppointment(int PatientID, String ADate,int DoctorID,int Clinic){
		String query = "Select `Dead` From patient where ID=?";
		
		
		
		
		
	      
		 try {
			 
			 PreparedStatement Stmt = connection.prepareStatement(query);
			Stmt.setInt(1, PatientID);
			ResultSet result = Stmt.executeQuery();
			if(result.next()){
				if(result.getBoolean("Dead")==true){
					return false;
					
				}
			}
			else return false;
			
			 
			 
			 query = "INSERT INTO appointment(PatientID,DateCreated,ADate,DoctorID,Clinic) Values (?,?,?,?,?)";
				
			 SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			 Date dNOW = new Date();
			 String myDate = f.format(dNOW);
			 
			 
			PreparedStatement preparedStmt = connection.prepareStatement(query);
			preparedStmt.setInt(1, PatientID);
			preparedStmt.setString (2, myDate);
			preparedStmt.setString(3, ADate);
		    preparedStmt.setInt(4, DoctorID);
		    preparedStmt.setInt(5, Clinic);


		    


		    preparedStmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	      
	     return true;
	}
	
	public boolean getAppointments(ArrayList<Object[]> Q){
		try {
			Statement stm = connection.createStatement();
			 String Query = "Select * from appointment";
			 ResultSet result;
			result = stm.executeQuery(Query);			
			
			while(result.next()){
				 Q.add(new Object[]{result.getString("AID"),result.getString("PatientID"),result.getString("DateCreated"), result.getString("ADate"),result.getString("DoctorID"), result.getString("Clinic"),result.getString("PatientWent")}); 
				 
			 }
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	
		return true;
	}

	public boolean checkIfPatientWent(int ID, String went){
		String query = "UPDATE appointment SET PatientWent = ? WHERE AID = ?";
		boolean flag;
		
		 if(went.equals("YES")){
			flag = true;
		 }
		 else{
			 flag = false;
		 }
	      
		 try {
			PreparedStatement preparedStmt = connection.prepareStatement(query);
			preparedStmt.setBoolean(1, flag);
			preparedStmt.setInt(2, ID);
			

		    


		    preparedStmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	      
	     return true;
	}
	
	

	
	

}
