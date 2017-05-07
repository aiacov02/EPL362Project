package com.javaworld.sample.helloservice;

import java.util.ArrayList;

public interface HelloService {

	
	public boolean insertPatient(String Name, String Surname, String DOB, String Sex, String Telephone, String Address, Boolean Suicide);

	public boolean getPatient(ArrayList<Object[]> Q);
	
	public boolean searchPatient(ArrayList<Object[]> Q,String Name, String Surname);
	
	public boolean insertAppointment(int PatientID, String ADate,int DoctorID,int Clinic);
	
	public boolean getAppointments(ArrayList<Object[]> Q);

	public boolean checkIfPatientWent(int ID, String went);
	
	public boolean insertDropIN(int PatientID);
}
