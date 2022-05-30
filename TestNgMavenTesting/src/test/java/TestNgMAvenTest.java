import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNgMAvenTest {
	private static WebDriver driver = null;
	@BeforeTest
	public void setup() {
		String projectPath=System.getProperty("user.dir");
		System.out.println("path----"+projectPath);
		System.setProperty("webdriver.chrome.driver",projectPath+ "\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
	}
    @Test
	public static void runtest() {
		driver.manage().window().maximize(); 
		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("cheese" + Keys.ENTER);
		//Initialize and wait till element(link) became clickable - timeout in 10 seconds
		
		// Print the first result
		
		

	}
	@AfterTest
	public void teardowntest() {
		driver.close();
		driver.quit();
		System.out.println("=---------test run sucessful--------");
		
	}

}
