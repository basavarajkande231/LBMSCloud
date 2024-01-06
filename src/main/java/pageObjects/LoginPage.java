package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@placeholder='Enter your username']")
	WebElement userName;
	
	@FindBy(xpath="//input[@placeholder='Enter your password']")
	WebElement password;
	
	@FindBy(xpath="//span[@class='sc-aXZVg eppWcJ eui-icon-end']//*[name()='svg']")
	WebElement view_password;
	
	@FindBy(xpath="//span[text()='Sign In']")
	WebElement signIn;
	
	@FindBy(xpath="//img[@alt='Giift LBMS']")
	WebElement LoginValidation;
	
	public WebElement getUserName() {
		return userName;
	}
	
	public WebElement getPassword() {
		return password;
	}
	
	public WebElement getViewPassword()
	{
		return view_password;
	}
	
	public WebElement getSignIn() {
		return signIn;
	}
	
	public WebElement getloginvalidation() {
		return LoginValidation;
	}
		
}
	

	