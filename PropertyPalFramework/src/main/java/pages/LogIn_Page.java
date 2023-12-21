package pages;


import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogIn_Page {
	
	static WebDriver driver;
	 WebDriverWait wait;
	
	public LogIn_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	By logInButtonDropDown = By.xpath("//p[contains(text(), 'Log in')]/..");
	By logInPage= By.xpath("//p[contains(text(), 'Log In')]/..");
	By emailInputField = By.xpath("//input[@id='email']");
	By passwordInputField = By.xpath("//input[@id='password']");
	By submitButton = By.xpath("//input[@id='email']/../../../..//form/..//button/p");
	By agreeButton = By.xpath("//span[contains(text(), 'AGREE')]/..");
	By ErroMessage = By.xpath("//p[contains(text(), 'Sorry')]");
	
	
	public void handleCookiePopup() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(agreeButton));
		driver.findElement(agreeButton).click();
		}
	
	public void logIn(String email, String password) throws Exception {
		driver.findElement(logInButtonDropDown).click();
		driver.findElement(logInPage).click();
		driver.findElement(emailInputField).click();
		driver.findElement(emailInputField).sendKeys(email);
		driver.findElement(passwordInputField).click();
		driver.findElement(passwordInputField).sendKeys(password);
		driver.findElement(submitButton).click();
		Thread.sleep(1000);
		
	}
	
	public void checkEmail(String email) {
		driver.findElement(logInButtonDropDown).click();
		driver.findElement(logInPage).click();
		driver.findElement(emailInputField).click();
		driver.findElement(emailInputField).sendKeys(email);
	}
	
	public void checkEmailValue(String ExpectedEmailValue) {
		
		WebElement emailInput = driver.findElement(emailInputField);
		
		String TextData = emailInput.getAttribute("value");
		
		boolean status = TextData.equals(ExpectedEmailValue);
		assertTrue(status);
		
	}
	
	public void checkLogInErrorMessage() {
		
		WebElement errorMessage = driver.findElement(ErroMessage);
		assertTrue(errorMessage.isDisplayed());
	}

}
