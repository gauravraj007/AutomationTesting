package webpages;

import java.time.Duration;
//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class ExotelLoginPageObject {
	WebDriver driver=null;
	By username_Input_box = By.name("username");
	By continue_btn = By.name("action");
	By password_box = By.name("password");
	By login_btn = By.name("action");
	
	public ExotelLoginPageObject (WebDriver driver) {
	 this.driver=driver;
	}
	public void setTextInUsername(String username) {
		driver.findElement(username_Input_box).sendKeys(username);
		
	}
	public void clickContinue() {
		driver.findElement(continue_btn).sendKeys(Keys.RETURN);
		
	}
	public void inputPass(String pass) {
		driver.findElement(password_box).sendKeys(pass);
		
	}
	public void loginBtn() {
		driver.findElement(password_box).sendKeys(Keys.RETURN);
		
	}
	public void logoutBtn() {
		driver.findElement(By.xpath("/html/body/div[5]/div/div[1]/div[1]/ul/li[7]/div/a")).sendKeys(Keys.RETURN);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.close();
	}

}
