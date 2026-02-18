package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
	
	private static FileInputStream file;
	private static Properties prop;
	private static String filePath="src/test/resources/Configs/";
	private static String propertyFileName;
	
	public ConfigReader(String fileName)
	{
			try
			{
				propertyFileName=fileName;
				file=new FileInputStream(filePath+propertyFileName);
				prop=new Properties();
				prop.load(file);
				
			}
			catch(Exception e)
			{
				System.out.println("Something went wrong...!!");
	            throw new RuntimeException("Failed to load "+propertyFileName+" file");
			}
	}
	
	public String getPropertyValue(String key)
	{
		String value=prop.getProperty(key);
		if(value!=null)
		{
			return value.trim();
		}
		else
		{
            throw new RuntimeException("Property '" + key + "' not found in "+propertyFileName+" config file");
		}
		
	}
	
	//optional code used to test the utility
//	public static void main(String[] args)  
//	{
//		ConfigReader cr=new ConfigReader("application.properties");
//		String url=cr.getPropertyValue("url");
//		String email=cr.getPropertyValue("email");
//		String password=cr.getPropertyValue("password");
//		
//		System.out.println(url+"\t"+email+"\t"+password);
//	}

}
