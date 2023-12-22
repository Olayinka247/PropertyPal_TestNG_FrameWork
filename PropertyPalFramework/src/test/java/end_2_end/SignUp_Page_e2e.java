package end_2_end;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.assertthat.selenium_shutterbug.core.Shutterbug;

import libary.Constants;

import pages.SignUp_Page;

public class SignUp_Page_e2e {
	WebDriver driver;
	SignUp_Page result;
	
	
	@BeforeMethod
	public void setup() throws Exception {
		driver = libary.BrowserLibary.launchBrowser("firefox");
		driver.manage().window().maximize();
		driver.get(Constants.URL);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		result = new SignUp_Page(driver);
		result.handleCookiePopup();
	}
	
	@AfterMethod
	public void teardown(ITestResult result) {
		if(ITestResult.FAILURE == result.getStatus()) {
			Shutterbug.shootPage(driver).withName(result.getName()).save();
		}
		driver.quit();
	}
	
	@Test
 	public void CheckUserCanSignUp_Testcase_001() throws Exception{
		result = new SignUp_Page(driver);
		result.signUp();
		result.signUpInformation(Constants.EMAIL[2],Constants.FIRST_NAME[2],Constants.LAST_NAME[2],Constants.TELEPHONE[2], Constants.PASSWORD[2],Constants.CONFIRM_PASSWORD[2]);
		
	}

}
