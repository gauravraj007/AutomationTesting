package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import webpages.GoogleSearches;

public class googleSearchTest {
	private static WebDriver driver = null;
public static void main(String[] args) {
	googlesearch();
	}
	public static void googlesearch() {
	    
		String projectPath=System.getProperty("user.dir");
		System.out.println("dir....."+projectPath);
		System.setProperty("webdriver.chrome.driver",projectPath+ "\\drivers\\chrome\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://id.accounts.exotel.com/u/login/");
		GoogleSearches.testbox_username(driver).sendKeys("rajgauravraj77@gmail.com");
		GoogleSearches.next(driver).sendKeys(Keys.RETURN);
		GoogleSearches.password(driver).sendKeys("@Test007");
		GoogleSearches.login(driver).sendKeys(Keys.RETURN);
		
	
	}
}
