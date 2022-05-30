package test;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import config.propertiesFile;

public class testcase {
	
	public static String browser;
	static WebDriver driver;
	public static void main(String[] args) {
		//String projectlocation = System.getProperty("user.dir");
		//setbrowser();
		propertiesFile.readPropertiesFile();
		browserconfig();
		runtest();
		propertiesFile.writePropertiesfile();
	}
	public static void setbrowser() {
		browser= "edge";
	}
	
public static void browserconfig() {
	if (browser.contains("chrome")) {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\eclipse-workspace\\seleniumTest\\webDrivers\\chrome\\chromedriver.exe");
	driver = new ChromeDriver();
	}
	if (browser.contains("firefox")) {
	System.setProperty("webdriver.geko.driver", "C:\\Users\\User\\eclipse-workspace\\seleniumTest\\webDrivers\\firefoxGeko\\geckodriver.exe");
	driver = new FirefoxDriver();
	}
	if (browser.contains("edge")) {
		System.setProperty("webdriver.edge.driver","C:\\Users\\User\\eclipse-workspace\\seleniumTest\\webDrivers\\edge\\msedgedriver.exe");
		driver = new EdgeDriver();
		}
	}

public static void runtest() {
	driver.manage().window().maximize(); 
	driver.get("https://google.com");
	driver.findElement(By.name("q")).sendKeys("cheese" + Keys.ENTER);
	//Initialize and wait till element(link) became clickable - timeout in 10 seconds
	WebElement firstResult = new WebDriverWait(driver, Duration.ofSeconds(10))
			.until(ExpectedConditions.elementToBeClickable(By.xpath("//a/h3")));
	// Print the first result
	System.out.println(firstResult.getText());
	driver.quit();

}
}



