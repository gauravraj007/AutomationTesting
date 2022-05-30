package webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleSearches {
	
		private static WebElement element=null;
		public static WebElement testbox_username(WebDriver driver ) {
			element = driver.findElement(By.name("username"));
			return element;
			//
			//public static WebElement textbox_search
			
		}
		public static WebElement next(WebDriver driver ) {
			element = driver.findElement(By.name("action"));
			return element;
			//
			//public static WebElement textbox_search
			
		}
		public static WebElement password(WebDriver driver ) {
			element = driver.findElement(By.name("password"));
			return element;
			//
			//public static WebElement textbox_search
			
		}
		public static WebElement login(WebDriver driver ) {
			element = driver.findElement(By.name("action"));
			return element;
			//
			//public static WebElement textbox_search
			
		}
	
}
