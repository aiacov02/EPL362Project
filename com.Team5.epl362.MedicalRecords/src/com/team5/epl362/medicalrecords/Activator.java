package com.team5.epl362.medicalrecords;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.javaworld.sample.helloservice.ClinicalStaff;
import com.javaworld.sample.helloservice.HelloService;
import com.javaworld.sample.helloservice.Management;
import com.javaworld.sample.helloservice.MedicalRecords;

public class Activator implements BundleActivator {

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	ServiceReference MedicalRecordsReference;
	

    public void start(BundleContext context) throws Exception {
       
        MedicalRecordsReference= context.getServiceReference(MedicalRecords.class.getName());
        MedicalRecords medicalrecords  = (MedicalRecords)context.getService(MedicalRecordsReference);
        //MainManagement m = new MainManagement(management);
        //m.frame.setVisible(true);
        hj mainPage = new hj(medicalrecords);
        mainPage.frame.setVisible(true);
    }
    
    public void stop(BundleContext context) throws Exception {
       
        context.ungetService(MedicalRecordsReference);
        

    }

}