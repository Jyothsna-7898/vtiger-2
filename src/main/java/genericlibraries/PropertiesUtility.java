package genericlibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtility {
	private Properties property;
	/**
	 * This method is used to initialize properties file
	 * @param filepath
	 * @throws FileNotFoundException 
	 */
	public void propertiesInitialization(String filepath) 
	{
		//FileInputStream fis=new FileInputStream(filepath);
		FileInputStream fis=null;
		try 
		{
		fis=new FileInputStream(filepath);
	    }
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		 property=new Properties();
		try {
			property.load(fis);
			}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	/**
	 * This method is used to read the data from properties
	 * @parameter key
	 * @return
	 */

    public String readFromProperties(String key)
		{
		 return property.getProperty(key);
	    }
	
}
