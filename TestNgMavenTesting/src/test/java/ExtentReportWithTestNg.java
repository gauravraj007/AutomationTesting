import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportWithTestNg {
	private static WebDriver driver = null;
	static ExtentSparkReporter htmlReporter;
	ExtentReports extent;
	//runs before multiple tests not as @beforetest annotin which runs only one for one test
	@BeforeSuite
	public  void setup() {
		htmlReporter = new ExtentSparkReporter("ExtentTestNgRepo.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}
	@BeforeTest
	public void setupTest() {
		String projectPath=System.getProperty("user.dir");
		System.out.println("path----"+projectPath);
		System.setProperty("webdriver.chrome.driver",projectPath+ "\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	@Test
	public void tests() {
		ExtentTest test1 = extent.createTest("Exotel login page test","To test the Exotel login and logout");
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
		test1.log(Status.INFO, "This step shows usage of log(status, details)");
		test1.info("This step shows usage of info(details)");
		// log with snapshot
		test1.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
		// test with snapshot
		test1.addScreenCaptureFromPath("screenshot.png");
	}
	@AfterTest
	public void teardowntest() {
		driver.close();
		driver.quit();
		System.out.println("=---------test run sucessful--------");
		
	}
	////runs before multiple tests not as @aftertest annotin which runs only one for one test
	@AfterSuite
	public void TearDown() {
		extent.flush();
	}
}
