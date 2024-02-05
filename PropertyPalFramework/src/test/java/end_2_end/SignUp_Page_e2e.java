package end_2_end;

import java.time.Duration;
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
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
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
		result.signUpInformation(Constants.EMAIL[1],Constants.FIRST_NAME[2],Constants.LAST_NAME[2],Constants.TELEPHONE[3], Constants.PASSWORD[0],Constants.CONFIRM_PASSWORD[0]);
		
	}
	
	@Test
 	public void CheckUserAlreadySignedUp_Testcase_001() throws Exception{
		result = new SignUp_Page(driver);
		result.signUp();
		result.signUpInformation(Constants.EMAIL[3],Constants.FIRST_NAME[3],Constants.LAST_NAME[1],Constants.TELEPHONE[1], Constants.PASSWORD[2],Constants.CONFIRM_PASSWORD[2]);
		
	}

}
