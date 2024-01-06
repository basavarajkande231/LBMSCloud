package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class UserManagementPage {

	
	public WebDriver driver;
	
	public UserManagementPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
}
