package com.javaworld.sample.helloworld;

import java.awt.EventQueue;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.javaworld.sample.helloservice.HelloService;
import com.javaworld.sample.helloservice.HelloServiceImpl;
import com.team5.epl362.writetofileservice.ReceptionistFile;

public class Activator implements BundleActivator {

	/*
	 * (non-Javadoc) 
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	  
	ServiceReference helloServiceReference1;
	ServiceReference receptionistFileReference;
	

    public void start(BundleContext context) throws Exception {
       
        helloServiceReference1= context.getServiceReference(HelloService.class.getName());
        HelloService helloService1 =(HelloService)context.getService(helloServiceReference1);
        
        receptionistFileReference= context.getServiceReference(ReceptionistFile.class.getName());
        ReceptionistFile receptionistFile =(ReceptionistFile)context.getService(receptionistFileReference);
        
        number1 n = new number1(helloService1, receptionistFile);
        n.frame.setVisible(true);
        //System.out.println(helloService1.SayHello());
        
      

    }
    public void stop(BundleContext context) throws Exception {
       
        context.ungetService(helloServiceReference1);
        

    }
	
}
