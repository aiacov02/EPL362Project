package com.javaworld.sample.helloservice;

import java.util.ArrayList;

public interface Management {

	public boolean getPatient(ArrayList<Object[]> Q);
	public boolean CalculateStatistics(int patientsPerDay[], int conditions[],int Drugs[], int Allpatients[], int myClinic);
}

