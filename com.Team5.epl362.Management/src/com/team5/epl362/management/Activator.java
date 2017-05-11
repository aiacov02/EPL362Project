package com.team5.epl362.management;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.javaworld.sample.helloservice.ClinicalStaff;
import com.javaworld.sample.helloservice.HelloService;
import com.javaworld.sample.helloservice.Management;

public class Activator implements BundleActivator {

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	ServiceReference ManagementReference;
	

    public void start(BundleContext context) throws Exception {
       System.out.println("Hello World");
        ManagementReference= context.getServiceReference(Management.class.getName());
        Management management  = (Management)context.getService(ManagementReference);
        MainManagement m = new MainManagement(management);
        m.frame.setVisible(true);
        
    }
    
    public void stop(BundleContext context) throws Exception {
       
        context.ungetService(ManagementReference);
        

    }

}