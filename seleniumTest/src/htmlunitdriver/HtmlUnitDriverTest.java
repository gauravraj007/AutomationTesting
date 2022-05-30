package htmlunitdriver;

import java.lang.reflect.Field;

import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;

//import org.openqa.selenium.htmlunit.HtmlUnitDriver;
public class HtmlUnitDriverTest {

	public static void main(String[] args) {
		// can set any browser which are supported
		HtmlUnitDriver driver = new HtmlUnitDriver(BrowserVersion.EDGE);
		driver.get("http://seleniumhq.org/");
		System.out.println("Webpage title is --->>"+driver.getTitle());
		try {
			WebClient webClient = (WebClient) get(driver, "webClient");
			
			System.out.println("browser version is-->"+webClient.getBrowserVersion());
			System.out.println("Browser is chrome----->"+webClient.getBrowserVersion().isChrome());
			System.out.println("browser is edge---->"+webClient.getBrowserVersion().isEdge());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.quit();
		
		
	}
	
	private static Object get(Object object, String field) throws Exception {
		  Field f = object.getClass().getDeclaredField(field);
		  f.setAccessible(true);
		  return f.get(object);
		 }

}
