import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.reporters.TestHTMLReporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class MavenExtentReportTest {
	private static WebDriver driver = null;
	public static void main(String[] args) {

		ExtentSparkReporter htmlReporter = new ExtentSparkReporter("reports.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		ExtentTest test1 = extent.createTest("Exotel login page test","To test the Exotel login and logout");

		String projectPath=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",projectPath+ "\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		test1.log(Status.INFO,"Stsrting testcase");

		driver.get("https://id.accounts.exotel.com/u/login/");
		test1.pass("Navigated to Exotel login page");
		driver.findElement(By.name("username")).sendKeys("rajgauravraj77@gmail.com");
		test1.pass("Entered username sucesfully");
		driver.findElement(By.name("action")).sendKeys(Keys.RETURN);
		test1.pass("Clicked continue button sucessfully");
		driver.findElement(By.name("password")).sendKeys("@Test007");
		test1.pass("Entered password sucessfully");
		driver.findElement(By.name("action")).sendKeys(Keys.RETURN);
		test1.pass("clicked login button sucessfully");
		driver.findElement(By.xpath("/html/body/div[5]/div/div[1]/div[1]/ul/li[7]/div/a")).sendKeys(Keys.RETURN);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		test1.pass("clicked logout button sucessfully");
		driver.close();
		driver.quit(); 
		test1.pass("closed the browser and driver sucessfully");
		test1.info("test completed");

		//writes everything to log file
		extent.flush();
	}

}
