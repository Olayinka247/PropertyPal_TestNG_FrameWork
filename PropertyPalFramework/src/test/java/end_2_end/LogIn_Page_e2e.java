package end_2_end;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.assertthat.selenium_shutterbug.core.Shutterbug;

import libary.Constants;
import pages.LogIn_Page;


public class LogIn_Page_e2e {
	
	WebDriver driver;
	LogIn_Page result;
	
	
	@BeforeMethod
	public void setup() {
		driver = libary.BrowserLibary.launchBrowser("firefox");
		driver.manage().window().maximize();
		driver.get(Constants.URL);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void teardown(ITestResult result) {
		if(ITestResult.FAILURE == result.getStatus()) {
			Shutterbug.shootPage(driver).withName(result.getName()).save();
		}
		driver.quit();
	}
	
	@Test
	public void ConfirmUserCanLogIn_Testcase_001() throws Exception{
		result = new LogIn_Page(driver);
		result.handleCookiePopup();
		result.logIn(Constants.EMAIL, Constants.PASSWORD);
		Thread.sleep(1000);
		
	}

}
