package end_2_end;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import libary.Constants;

import pages.SignUp_Page;

public class SignUp_Page_e2e {
	WebDriver driver;
	SignUp_Page result;
	
	
	@BeforeMethod
	public void setup() {
		driver = libary.BrowserLibary.launchBrowser("firefox");
		driver.manage().window().maximize();
		driver.get(Constants.URL);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	@Test
	public void CheckUserCanSignUp_Testcase_001() throws Exception{
		result = new SignUp_Page(driver);
		result.handleCookiePopup();
		result.signUp();
		result.signUpInformation(Constants.EMAIL,Constants.FIRST_NAME,Constants.LAST_NAME,Constants.TELEPHONE, Constants.PASSWORD,Constants.CONFIRM_PASSWORD);
		
	}
	
	@Test
	public void CheckUserAlreadyHasAnAccount_Testcase_001() throws Exception{
		result = new SignUp_Page(driver);
		result.handleCookiePopup();
		result.signUp();
		result.signUpInformation(Constants.EMAIL,Constants.FIRST_NAME,Constants.LAST_NAME,Constants.TELEPHONE, Constants.PASSWORD,Constants.CONFIRM_PASSWORD);
		
	}

}
