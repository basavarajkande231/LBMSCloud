package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SegmentPage {
	
	public WebDriver driver;
	public SegmentPage(WebDriver driver) {

		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	
	
}
