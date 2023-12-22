package regression;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.assertthat.selenium_shutterbug.core.Shutterbug;

import libary.Constants;
import pages.LogIn_Page;


public class LogIn_Page_regression {
	WebDriver driver;
	LogIn_Page result;

	
	@BeforeMethod
	public void setup() throws Exception {
		driver = libary.BrowserLibary.launchBrowser("firefox");
		driver.manage().window().maximize();
		driver.get(Constants.URL);
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		result = new LogIn_Page(driver);
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
	public void ConfirmUserWrongEmail_Testcase_001() throws Exception{
		result = new LogIn_Page(driver);
		result.checkEmail(Constants.EMAIL[0]);
		result.checkEmailValue(Constants.EMAIL[0]);
	}
	@Test
	public void ConfirmUserCorrectEmail_Testcase_002() throws Exception{
		result = new LogIn_Page(driver);
		result.checkEmail(Constants.EMAIL[0]);
		result.checkEmailValue(Constants.EMAIL[0]);
	}
	
	@Test
	public void ConfirmValidEMailFormat_Testcase_003() {
		result = new LogIn_Page(driver);
		result.checkEmail(Constants.EMAIL[0]);
		result.validateEmailFormat();
	}
	
	@Test
	public void ConfirmEmailTakesAphabet_Testcase_004() throws Exception{
		result = new LogIn_Page(driver);
		result.checkEmail(Constants.EMAIL[0]);
		result.checkEmailValue(Constants.EMAIL[0]);
	}
	
	@Test
	public void ConfirmErrorMsgForInvalidData_Testcase_005() throws Exception {
		result = new LogIn_Page(driver);
		result.logIn(Constants.EMAIL[0], Constants.PASSWORD[1]);
		result.checkLogInErrorMessage();
	}
	
}
