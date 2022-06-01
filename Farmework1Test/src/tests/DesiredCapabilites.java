package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DesiredCapabilites {
	static WebDriver driver = null;
 public static void main(String[] args) {
	    String projectPath=System.getProperty("user.dir");
		System.out.println(projectPath);
		//DesiredCapabilities SSLCertificate = DesiredCapabilities.chrome();
		System.setProperty("webdriver.chrome.driver",projectPath+ "\\drivers\\chrome\\chromedriver.exe");
		driver = new ChromeDriver();
	 
}
}
