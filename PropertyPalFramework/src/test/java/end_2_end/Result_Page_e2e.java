package end_2_end;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.assertthat.selenium_shutterbug.core.Shutterbug;

import libary.Constants;
import pages.Result_Page;

public class Result_Page_e2e {
	
	WebDriver driver;
	Result_Page result;
	
	
	@BeforeMethod
	public void setup() throws Exception {
		driver = libary.BrowserLibary.launchBrowser("firefox");
		driver.manage().window().maximize();
		driver.get(Constants.URL);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		result = new Result_Page(driver);
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
	public void CheckFor2Beds_Testcase_001() throws Exception {
		result = new Result_Page(driver);
		result.searchForAPostCode(Constants.POSTCODE[0]);
		result.currencyAndPriceRangeOption(Constants.CURRENCY[1],Constants.MIN_AMOUNTE[1],Constants.MAX_AMOUNTE[6]);
		result.selectABedroomFilter(Constants.MIN_BED[2], Constants.MAX_BED[2]);
		result.propertyTypesOption(Constants.PROPERTY_TYPE[0]);
		result.clickSearch();
		result.verifyResults(Constants.BED_TYPE[2]);
	
	}
	
	@Test
	public void CheckFor3Beds_Testcase_002() throws Exception {
		result = new Result_Page(driver);
		result.searchForAPostCode(Constants.POSTCODE[0]);
		result.currencyAndPriceRangeOption(Constants.CURRENCY[0],Constants.MIN_AMOUNTP[1],Constants.MAX_AMOUNTP[6]);
		result.selectABedroomFilter(Constants.MIN_BED[3], Constants.MAX_BED[3]);
		result.propertyTypesOption(Constants.PROPERTY_TYPE[1]);
		result.clickSearch();
		result.verifyResults(Constants.BED_TYPE[3]);
	
	}
	
	@Test
	public void CheckFor5Beds_Testcase_003() throws Exception {
		result = new Result_Page(driver);
		result.searchForAPostCode(Constants.POSTCODE[0]);
		result.currencyAndPriceRangeOption(Constants.CURRENCY[1],Constants.MIN_AMOUNTE[1],Constants.MAX_AMOUNTE[6]);
		result.selectABedroomFilter(Constants.MIN_BED[5], Constants.MAX_BED[5]);
		result.propertyTypesOption(Constants.PROPERTY_TYPE[1]);
		result.clickSearch();
		result.verifyResults(Constants.BED_TYPE[5]);
	
	}
}
