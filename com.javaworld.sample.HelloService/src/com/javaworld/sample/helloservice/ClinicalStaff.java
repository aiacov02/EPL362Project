package com.javaworld.sample.helloservice;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public interface ClinicalStaff {

	
	public boolean getPatient(ArrayList<Object[]> Q);
	
	public boolean isDiagnosisTheSame(String Diagnosis,int PatientID);
	
	public boolean changeDiagnosis(String Diagnosis,int PatientID);
	
	public boolean isPrescriptionTheSame(String Prescription,int PatientID);
	
	public boolean changePrescription(String Prescription,int PatientID);
	
	public boolean viewDrugs(ArrayList<Object[]> Q);
	
	public boolean updateLater(int PatientID);
	
	public boolean getNeedsUpdate(ArrayList<Object[]> Q);
	
	public boolean getSuicidal(ArrayList<Object[]> Q);
	
	public boolean addIncident(int PatientID, String iDate, String Description);
	
	public boolean addAccident(int PatientID, String iDate, String Description, String DrugName);
	
	public boolean getIncidents(ArrayList<Object[]> Q);
	
	public boolean getAccidents(ArrayList<Object[]> Q);
	
	public boolean getAllergies(ArrayList<Object[]> Q);
	
	public boolean isAllergic(int PatientID, String DrugName);
	
	public boolean addAllergy(int PatientID, String DrugName);
	
	
	
	


}