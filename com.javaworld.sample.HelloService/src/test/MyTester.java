package test;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import com.javaworld.sample.helloservice.*;

import org.junit.Assert;

public class MyTester {

	
	@Test
	public void test(){
		try {
			Management m = new ManagementImpl();
			Assert.assertFalse(m==null);
			Assert.assertEquals("Error", true,m.getPatient(new ArrayList<Object[]>()));
			Assert.assertEquals("Error", true,m.CalculateStatistics(new int[5], new int[1024], new int[1024], new int[1024], 1));
			HelloService h = new HelloServiceImpl();
			Assert.assertEquals("Error",true,h.checkIfPatientWent(1, "YES"));
			Assert.assertEquals("Error",true,h.getAppointments(new ArrayList<Object[]>()));
			Assert.assertEquals("Error",true,h.insertDropIN(10));
			Assert.assertEquals("Error",true,h.searchPatient(new ArrayList<Object[]>(), "Kostis", "K"));
			Assert.assertEquals("Error",true,h.insertPatient("dg", "sdfsfd", "2000-10-10", "M", "9", "df", false));
			MedicalRecords med = new MedicalRecordsImpl();
			Assert.assertEquals("Error",true,med.updateRecord(1, "sdf", "Asf", "2000-10-10", "55", "asd", "M"));
			ClinicalStaff c = new ClinicalStaffImpl();
			//Next line will result in exception
			Assert.assertEquals("Should be false because of duplicate primary key",false,c.addAllergy(1, "Φάρμακο1"));
			Assert.assertEquals("Error",true,c.changeDiagnosis("Σχιζοφρένεια", 1));
			Assert.assertEquals("Error",true,c.addAccident(1, "2017-12-12", "sdf", "Φάρμακο1"));
			Assert.assertEquals("Error",true,c.addIncident(1, "2000-10-10", "sdf"));
			Assert.assertEquals("Error",true,c.getPatient(new ArrayList<Object[]>()));
			Assert.assertEquals("Error",true,c.getSuicidal(new ArrayList<Object[]>()));
			Assert.assertEquals("Must be true. Patient 1 is allergic",true,c.isAllergic(1, "Φάρμακο1"));
			Assert.assertEquals("Error",true,c.updateLater(1));


			


			







		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
