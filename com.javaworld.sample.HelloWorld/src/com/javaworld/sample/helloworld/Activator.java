package com.javaworld.sample.helloworld;

import java.awt.EventQueue;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.javaworld.sample.helloservice.HelloService;
import com.javaworld.sample.helloservice.HelloServiceImpl;

public class Activator implements BundleActivator {

	/*
	 * (non-Javadoc) 
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	  
	ServiceReference helloServiceReference1;
	

    public void start(BundleContext context) throws Exception {
       
        helloServiceReference1= context.getServiceReference(HelloService.class.getName());
        HelloService helloService1 =(HelloService)context.getService(helloServiceReference1);
        number1 n = new number1(helloService1);
        n.frame.setVisible(true);
        //System.out.println(helloService1.SayHello());
        
      

    }
    public void stop(BundleContext context) throws Exception {
       
        context.ungetService(helloServiceReference1);
        

    }
	
}
