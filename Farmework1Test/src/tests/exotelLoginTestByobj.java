package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import webpages.ExotelLoginPageObject;

public class exotelLoginTestByobj{
	private static WebDriver driver = null;
	public static void main(String[] args) {
		exotelLoginTest();
	}
	public static void exotelLoginTest() {

		String projectPath=System.getProperty("user.dir");
		System.out.println("dir....."+projectPath);
		System.setProperty("webdriver.chrome.driver",projectPath+ "\\drivers\\chrome\\chromedriver.exe");
		driver = new ChromeDriver();
		ExotelLoginPageObject loginpageObj = new ExotelLoginPageObject(driver);
		driver.get("https://id.accounts.exotel.com/u/login/");
		driver.manage().window().maximize();
		//driver.manage().deleteAllCookies();
		loginpageObj.setTextInUsername("rajgauravraj77@gmail.com");
		loginpageObj.clickContinue();
		loginpageObj.inputPass("@Test007");
		loginpageObj.loginBtn();
		loginpageObj.logoutBtn();

	}

}
