package pages;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Result_Page {
	
	static WebDriver driver;
	 WebDriverWait wait;
	
	public Result_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	By agreeButton = By.xpath("//span[contains(text(), 'AGREE')]/..");
	By searchField = By.xpath("//input[@type='search']");
	By searchTitle = By.xpath("//h1[@id='search-title']");
	By bedFilterButton = By.xpath("//span[contains(text(), 'Bedrooms')]/..");
	By minBedDropdown = By.xpath("//span[contains(text(), 'Minimum Beds')]");
	By minBedList = By.cssSelector("li[id*='minBedsSelectOption']");
	By maxBedDropdown = By.xpath("//span[contains(text(), 'Maximum Beds')]");
	By maxBedList = By.cssSelector("li[id*='maxBedsSelectOption']"); 
	By searchButton = By.xpath("//p[contains(text(), 'Search')]/..");
	By resultPageList = By.xpath("//h1[@id='search-title']/../../../div[5]//h2/../p[2]");
	By currencyFilter = By.xpath("//span[contains(text(), 'Price Range')]/..");
	By currencySign = By.cssSelector("button[role*='radio']");
	By minRangeDropdown = By.xpath("//span[contains(text(), 'Minimum Price')]/..");
	By minPriceList = By.cssSelector("li[id*='selectMinPriceOption']");
	By maxRangeDropdown = By.xpath("//span[contains(text(), 'Maximum Price')]/..");
	By maxPriceList = By.cssSelector("li[id*='selectMaxPriceOption']"); 
	By propertyTypeList = By.cssSelector("button[role*='checkbox']"); 
	By propertyTypeDropdown = By.xpath("//span[contains(text(), 'Property Type')]/..");
	By submitButton = By.xpath("//input[@id='email']/../../../..//form/..//button/p");
	By logInButtonDropDown = By.xpath("//p[contains(text(), 'Log in')]/..");
	By logInPage= By.xpath("//p[contains(text(), 'Log In')]/..");
	By emailInputField = By.xpath("//input[@id='email']");
	By passwordInputField = By.xpath("//input[@id='password']");
	By signUpPage = By.xpath("//p[contains(text(), 'Sign Up')]/..");
	By firstNameInput = By.xpath("//input[@id='firstName']");
	By lastNameInput = By.xpath("//input[@id='lastName']");
	By phoneNumberInput = By.xpath("//input[@id='phoneNumber']");
	By passwordConfirmInput = By.xpath("//input[@id='passwordConfirm']");
	By termsCheckBox = By.xpath("//input[@id='terms']");
	By signUpSubmitButton = By.xpath("//p[contains(text(), 'Sign up with your email')]/..");
	By signUpPageL = By.xpath("//button[contains(text(), 'Sign up')]");
	By tabPanel = By.xpath("//div[@role='tabpanel']/..");
	By emailDetails = By.id("email");
	
	
	
	
	
	
	
	
			
			
	
	public void handleCookiePopup() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(agreeButton));
		driver.findElement(agreeButton).click();
		}
	
	
	public void logIn(String email, String password) throws Exception {
		driver.findElement(logInButtonDropDown).click();
		driver.findElement(logInPage).click();
		
		driver.findElement(emailInputField).click();
		
		driver.findElement(emailInputField).click();
		driver.findElement(emailInputField).sendKeys(email);
		driver.findElement(passwordInputField).click();
		driver.findElement(passwordInputField).sendKeys(password);
		
		driver.findElement(submitButton).click();
		Thread.sleep(1000);
		
	}
	
	public void signUp() throws Exception {
	
		driver.findElement(logInButtonDropDown).click();
		driver.findElement(signUpPage).click();
		
		List<WebElement> emailField = driver.findElements(emailInputField);
		for(int i = 0; i < emailField.size(); i++) {
			int x = emailField.get(i).getLocation().getX();
			if(x != 0) {	
				Thread.sleep(500);
				emailField.get(i).click();
				break;	
			}
			
		}	
		
	
	}
	
	public void signUpInformation(String email,String firstName,String lastName,String phoneNumber,String password,String confirmPassword) throws Exception {
				
				List<WebElement> emailField = driver.findElements(emailInputField);
				for(int i = 0; i < emailField.size(); i++) {
					int x = emailField.get(i).getLocation().getX();
					if(x != 0) {				
						emailField.get(i).click();
						emailField.get(i).sendKeys(email);
						break;	
					}
					
				}	
				
				List<WebElement> firstNameField = driver.findElements(firstNameInput);
				for(int i = 0; i < firstNameField.size(); i++) {
					int x = firstNameField.get(i).getLocation().getX();
					if(x != 0) {				
						firstNameField.get(i).click();
						Thread.sleep(500);
						firstNameField.get(i).sendKeys(firstName);
						break;	
					}
					
				}
				
				driver.findElement(lastNameInput).click();
				driver.findElement(lastNameInput).sendKeys(lastName);
				driver.findElement(phoneNumberInput).click();
				driver.findElement(phoneNumberInput).sendKeys(phoneNumber);
				Thread.sleep(500);
				List<WebElement> passwordField = driver.findElements(passwordInputField);
				for(int i = 0; i < passwordField.size(); i++) {
					int x = passwordField.get(i).getLocation().getX();
					if(x != 0) {				
						passwordField.get(i).click();
						Thread.sleep(500);
						passwordField.get(i).sendKeys(password);
						break;	
					}
				}
				Thread.sleep(500);
				driver.findElement(passwordConfirmInput).click();
				driver.findElement(passwordConfirmInput).sendKeys(confirmPassword);
				driver.findElement(termsCheckBox).click();
				Thread.sleep(1000);
				driver.findElement(signUpSubmitButton).click();
	}

		public void searchForAPostCode(String postcode) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		driver.findElement(searchField).click();
		driver.findElement(searchField).sendKeys(postcode);
		driver.findElement(searchField).sendKeys(Keys.ENTER);
		wait.until(ExpectedConditions.visibilityOfElementLocated(searchTitle));
		}
		
		public void currencyAndPriceRangeOption(String currency, String minPrice, String maxPrice ) throws Exception {
		driver.findElement(currencyFilter).click();
		Thread.sleep(500);
		List<WebElement> currencyOptions = driver.findElements(currencySign);
		for (int i =0; i < currencyOptions.size(); i++) {
			String text = currencyOptions.get(i).getText();
			System.out.println(text);
			if(text.equals(currency)) {
				currencyOptions.get(i).click();
				break;
			}
		}
		
		driver.findElement(minRangeDropdown).click();
		List<WebElement> minPriceOptions = driver.findElements(minPriceList);
		
		for (int i = 0; i < minPriceOptions.size(); i++ ) {
			String text = minPriceOptions.get(i).getText();
			System.out.println(text);
			
			if(text.equals(minPrice)) {
				minPriceOptions.get(i).click();
				break;
			}
			
		}
		
		driver.findElement(maxRangeDropdown).click();
		List<WebElement> maxPriceOptions = driver.findElements(maxPriceList);
		
		for (int i = 0; i < maxPriceOptions.size(); i++ ) {
			String text = maxPriceOptions.get(i).getText();
			System.out.println(text);
			
			if(text.equals(maxPrice)) {
				maxPriceOptions.get(i).click();
				break;
			}
		}
		}

		public void selectABedroomFilter(String minBedOption, String maxBedOption) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		driver.findElement(bedFilterButton).click();
		driver.findElement(minBedDropdown).click();

		List<WebElement> minBedOptions = driver.findElements(minBedList);

		int count = minBedOptions.size();

		for(int i=0; i < count; i++) {
		String text = minBedOptions.get(i).getText();
		System.out.println(text);
		if(text.equals(minBedOption)) {
		minBedOptions.get(i).click();
		break;
		}
		}

		driver.findElement(maxBedDropdown).click();

		List<WebElement> maxBedOptions = driver.findElements(maxBedList);

		int count1 = maxBedOptions.size();

		for(int i=0; i < count1; i++) {
		String text = maxBedOptions.get(i).getText();
		System.out.println(text);
		if(text.equals(maxBedOption)) {
		maxBedOptions.get(i).click();
		break;
		   }
		}

		wait.until(ExpectedConditions.visibilityOfElementLocated(searchTitle));

		}
		
		public void propertyTypesOption(String property) {
		driver.findElement(propertyTypeDropdown).click();
		List<WebElement> propertyTypes = driver.findElements(propertyTypeList);
		for(int i = 0; i < propertyTypes.size(); i++ ) {
			String text = propertyTypes.get(i).getText();
			System.out.println(text);
			if(text.equals(property)) {
				propertyTypes.get(i).click();
				break;
			}
			
		}
			
		}
		
		public void clickSearch() {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
			driver.findElement(searchButton).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(searchTitle));
		}

		public void verifyResults(String bedResult) throws Exception{
		WebElement saleHeader = driver.findElement(searchTitle);

		List<WebElement> resultList = driver.findElements(resultPageList);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView();", saleHeader);
		Thread.sleep(1000);

		for (int i = 0; i < resultList.size(); i++) {

		Thread.sleep(500);

		String text = resultList.get(i).getText();

		boolean status = text.contains(bedResult);
		assertTrue(status);

		System.out.println(status);
		}
		}
		
		

}
