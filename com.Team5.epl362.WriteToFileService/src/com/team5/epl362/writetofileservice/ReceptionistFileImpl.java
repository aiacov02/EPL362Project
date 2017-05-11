package com.team5.epl362.writetofileservice;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ReceptionistFileImpl implements ReceptionistFile {
	
	public boolean printFile(String name, String surname, String birthday, String adress, String tel,String gender) {
		String x;
		if (gender.compareTo("m") == 0) {
			x = "M";
		} else
			x = "F";
		//File fp = new File("C:\\Users\\andreas\\Documents\\JavaNew\\com.Team5.epl362.WriteToFileService\\Patients.txt");
		try (FileWriter fw = new FileWriter("C:\\Users\\andreas\\Documents\\JavaNew\\com.Team5.epl362.WriteToFileService\\Patients.txt", true);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter out = new PrintWriter(bw)) {
			out.println("Name:         " + name);
			// more code
			out.println("Surnname:     " + surname);
			// more code
			out.println("Birthday:     " + birthday);
			out.println("Adress:       " + adress);
			out.println("Phone Number: " + tel);
			out.println("Gender:       " + x);
			out.println("\n------------------------------------------------------------\n");
			
		
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
		
		
	}

}
