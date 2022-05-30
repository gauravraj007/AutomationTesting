package PhantomJS;

import org.openqa.selenium.phantomjs.PhantomJSDriver;


public class PhantomJSTest {

	public static void main(String[] args) {
        System.setProperty("phantomjs.binary.path", "C:\\Users\\User\\eclipse-workspace\\seleniumTest\\PhantomJSexe\\phantomjs.exe");
        PhantomJSDriver driver = new PhantomJSDriver();
        driver.get("http://seleniumhq.org");
        System.out.println("Web page title is--->>>"+driver.getTitle());
        
        driver.quit();
	}

}
