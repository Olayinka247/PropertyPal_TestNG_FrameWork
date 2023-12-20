package end_2_end;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import libary.Constants;
import pages.Result_Page;

public class Result_Page_e2e {
	
	WebDriver driver;
	Result_Page result;
	
	
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
	public void testcase_001() throws Exception {
		result = new Result_Page(driver);
		result.handleCookiePopup();
		result.searchForAPostCode(Constants.POSTCODE);
		result.currencyAndPriceRangeOption(Constants.CURRENCY[1],Constants.MIN_AMOUNT[1],Constants.MAX_AMOUNT[6]);
		result.selectABedroomFilter(Constants.MIN_BED[2], Constants.MAX_BED[2]);
		result.propertyTypesOption(Constants.PROPERTY_TYPE[0]);
		result.clickSearch();
		result.verifyResults(Constants.BED_TYPE[2]);
	
	}
}
