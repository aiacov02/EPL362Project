package com.team5.epl362.writetofileservice;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;



public class Activator implements BundleActivator  {
	
    ServiceRegistration ReceptionistFileRegistration;
    
    
    public void start(BundleContext context) throws Exception {
        ReceptionistFile receptionistfile = new ReceptionistFileImpl();
        ReceptionistFileRegistration =context.registerService(ReceptionistFile.class.getName(), receptionistfile, null);
       
        
    }
    public void stop(BundleContext context) throws Exception {
        ReceptionistFileRegistration.unregister();
       
    }
}
