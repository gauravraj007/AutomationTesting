package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import test.testcase;

public class propertiesFile {
	
	public static void main(String[] args) {
		readPropertiesFile();
		writePropertiesfile();
		
		
	}
	static Properties prop = new Properties(); 
	public static void readPropertiesFile() {
		
		try {
			InputStream input = new FileInputStream("C:\\Users\\User\\eclipse-workspace\\seleniumTest\\src\\config\\config.properties");
			prop.load(input);
			prop.getProperty("browser");
			System.out.println(prop.getProperty("browser"));
			testcase.browser = prop.getProperty("browser");
			System.out.println(testcase.browser);
		} catch (Exception e) {
			e.printStackTrace();
		}


	}

	public static void writePropertiesfile() {
		try {
			OutputStream output = new FileOutputStream("C:\\\\Users\\\\User\\\\eclipse-workspace\\\\seleniumTest\\\\src\\\\config\\\\config.properties");
			prop.setProperty("browser", "chrome");
			prop.setProperty("result", "pass");
			prop.store(output,null);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	}
	
	

