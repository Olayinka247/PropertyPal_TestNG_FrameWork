package libary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserLibary {
	
	public static WebDriver launchBrowser(String browser) {
		
		if(browser.equalsIgnoreCase("Chrome")) {
			
			WebDriverManager.chromedriver().setup();
			return new ChromeDriver();
			
		} else if (browser.equalsIgnoreCase("FireFox")) {	
			
			WebDriverManager.firefoxdriver().setup();
			return new FirefoxDriver();
			
		}else if(browser.equalsIgnoreCase("Edge")) {
		
			WebDriverManager.edgedriver().setup();
			return new EdgeDriver();
			
		} else {
			
			WebDriverManager.chromedriver().setup();
			return new ChromeDriver();
		}
	}

}