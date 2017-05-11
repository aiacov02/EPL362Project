package com.team5.epl362;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.javaworld.sample.helloservice.ClinicalStaff;
import com.javaworld.sample.helloservice.HelloService;

public class Activator implements BundleActivator {

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
ServiceReference ClinicalStaffReference;
	

    public void start(BundleContext context) throws Exception {
       System.out.println("Hello World");
        ClinicalStaffReference= context.getServiceReference(ClinicalStaff.class.getName());
        ClinicalStaff clinicalstaff  = (ClinicalStaff)context.getService(ClinicalStaffReference);
        
        number1 n = new number1(clinicalstaff);
        n.frame.setVisible(true);
        
      

    }
    public void stop(BundleContext context) throws Exception {
       
        context.ungetService(ClinicalStaffReference);
        

    }

}
