package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUp_Page {
	

	static WebDriver driver;
	 WebDriverWait wait;
	
	public SignUp_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	By logInButtonDropDown = By.xpath("//p[contains(text(), 'Log in')]/..");
	By signUpPage = By.xpath("//p[contains(text(), 'Sign Up')]/..");
	By emailInputField = By.xpath("//input[@id='email']");
	By firstNameInput = By.xpath("//input[@id='firstName']");
	By lastNameInput = By.xpath("//input[@id='lastName']");
	By phoneNumberInput = By.xpath("//input[@id='phoneNumber']");
	By passwordConfirmInput = By.xpath("//input[@id='passwordConfirm']");
	By termsCheckBox = By.xpath("//input[@id='terms']");
	By signUpSubmitButton = By.xpath("//p[contains(text(), 'Sign up with your email')]/..");
	By agreeButton = By.xpath("//span[contains(text(), 'AGREE')]/..");
	By passwordInputField = By.xpath("//input[@id='password']");
	
	
	
	
	public void handleCookiePopup() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(agreeButton));
		driver.findElement(agreeButton).click();
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
				Thread.sleep(500);
				driver.findElement(signUpSubmitButton).click();
				Thread.sleep(1000);
				
	}


}
