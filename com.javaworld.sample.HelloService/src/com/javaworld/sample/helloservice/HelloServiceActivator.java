package com.javaworld.sample.helloservice;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class HelloServiceActivator implements BundleActivator  {
	
    ServiceRegistration helloServiceRegistration;
    ServiceRegistration ClinicalStaffRegistration;
    ServiceRegistration ManagementRegistration;
    ServiceRegistration MedicalRecordsRegistration;
    
    public void start(BundleContext context) throws Exception {
        HelloService helloService = new HelloServiceImpl();
        helloServiceRegistration =context.registerService(HelloService.class.getName(), helloService, null);
        
        ClinicalStaff clinicalstaff = new ClinicalStaffImpl();
        ClinicalStaffRegistration = context.registerService(ClinicalStaff.class.getName(),clinicalstaff,null);
    
        Management management = new ManagementImpl();
        ManagementRegistration = context.registerService(Management.class.getName(),management,null);
        
        MedicalRecords medicalrecords = new MedicalRecordsImpl();
        MedicalRecordsRegistration = context.registerService(MedicalRecords.class.getName(),medicalrecords,null);
        
    }
    public void stop(BundleContext context) throws Exception {
        helloServiceRegistration.unregister();
        ClinicalStaffRegistration.unregister();
        ManagementRegistration.unregister();
        MedicalRecordsRegistration.unregister();
    }
}
