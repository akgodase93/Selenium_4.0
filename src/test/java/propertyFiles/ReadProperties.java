package propertyFiles;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Properties;
import java.util.Set;

public class ReadProperties {
	
	public static void main(String[] args) throws IOException{
		
		//1.file path
		FileInputStream file=new FileInputStream("src/test/resources/Configs/application.properties");
		
		//2.load property file into objects
		Properties obj=new Properties();
		obj.load(file);
		
		//3. Reading data from properties file one by one
			String url=obj.getProperty("url");
			String email=obj.getProperty("email");
			String password=obj.getProperty("password");
			
			System.out.println(url+"\t"+email+"\t"+password);
			
		//4. Reading all the keys from properties file
			//Set<Object> allKeys = obj.keySet();
			Set<String> allKeys = obj.stringPropertyNames();
			System.out.println(allKeys);
		
		//5. Reading all the values from properties file
			Collection<Object> allValues = obj.values();
			System.out.println(allValues);
			
		file.close();
	}

}
