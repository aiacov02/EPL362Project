package com.javaworld.sample.helloservice;

public interface MedicalRecords {

	public boolean updateRecord(int PatientID, String Name, String Surname, String DOB, String Telephone, String Address,String Sex);
}
