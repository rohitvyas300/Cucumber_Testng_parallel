package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropReader {

    

    public static void LoadDeviceData() {
    	Properties Devinfo = new Properties();
        try 
   	    {			       	        	
        	//FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+"/Repository/ObjectRepo.properties");
        	FileInputStream dataFile = new FileInputStream(PropertiesAndConstants.CurrentDirectory+"/Config/DeviceConfig.properties");
        	Devinfo.load(dataFile);	
        	PropertiesAndConstants.Deviceinfo = Devinfo;	 
        	System.out.println("dddd");
        	//return obj;
   	    }		                   
        catch (Exception e) {
        	System.out.println("Error.class.desiredAssertionStatus().");
        	e.printStackTrace();	        
    }
    }
        
        public static void LoadObjectsRepository() {
        	Properties repo = new Properties();
            try 
       	    {	
            	String ObjectRepoName = "ObjectRepoAndroid.properties";
            	System.out.println(PropertiesAndConstants.Deviceinfo.get("APP_TYPE"));
            	if(PropertiesAndConstants.Deviceinfo.get("APP_TYPE").equals("MOBILE ANDROID NATIVE"))
            	{
            		 ObjectRepoName = "ObjectRepoAndroid.properties";
            		 System.out.println("In Android Object Repo");
            	}
            	else
            	{
            		ObjectRepoName = "ObjectRepoiOS.properties";
            		System.out.println("In iOS Object Repo");
            	}
            	FileInputStream dataFile = new FileInputStream(PropertiesAndConstants.CurrentDirectory+"/Config/"+ObjectRepoName);
            	repo.load(dataFile);		
	       	 PropertiesAndConstants.Repository = repo;	   	
       	    }        catch (Exception e) {
            	System.out.println("Error.class.desiredAssertionStatus().");
            	e.printStackTrace();	        
        }
    }
        


    

}
