package resources;

import java.io.File;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Random;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BrowserUtils extends base{

	public static String newProgram;


	public static WebElement findAndWaitForElement(WebElement ele) {
		WebElement element = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			element = wait.until(ExpectedConditions.elementToBeClickable(ele));
			Thread.sleep(500);
		} catch (Exception e) {
			System.out.println("element not clickable");
		}
		return element;
	}
	public static List<WebElement> findAndWaitForElements(List<WebElement> list) {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			Thread.sleep(500);
		} catch (Exception e) {
			System.out.println("element not clickable");
		}
		return (List<WebElement>) list;
	}

	public static WebElement findElementByXpath(String ele) throws InterruptedException {
		Thread.sleep(1000);
		WebElement element = null;
		try {			
			return driver.findElement(By.xpath(ele));
		} catch (Exception e) {
			System.out.println("element not clickable");
		} 
		return element;

	}


	public WebElement findAndWaitForElement(By locator) throws InterruptedException {
		Thread.sleep(1000);
		
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			return wait.until(ExpectedConditions.elementToBeClickable(locator));
		} catch (Exception e) {
			// Handle the case where the element was not found or the waiting times out
			e.printStackTrace(); // You can log the error or handle it based on your requirements
			return null;
		}

	}

	public static void clickElement(WebElement ele) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//Thread.sleep(500);
		findAndWaitForElement(ele).click();
	}

	public static void enterText(WebElement ele, String text) throws InterruptedException {

		if (findAndWaitForElement(ele).isDisplayed() || findAndWaitForElement(ele).isEnabled()) {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));					


			findAndWaitForElement(ele).clear();


			findAndWaitForElement(ele).sendKeys(text);			
		}
	}

	public static void ClearAndEnterText(WebElement ele, String text) throws InterruptedException {
		String text2 = ele.getAttribute("value");
		if (text2.length()>0) {
			for (int i = 0; i < text2.length(); i++) {
				findAndWaitForElement(ele).sendKeys(Keys.BACK_SPACE);
			}
			findAndWaitForElement(ele).sendKeys(text);	
		}
		else {
			findAndWaitForElement(ele).sendKeys(text);
		}

	}

	public static void enterTextWithoutWait(WebElement ele, String text) throws InterruptedException {
		findAndWaitForElement(ele).sendKeys(text);			
	}

	public static void submit(WebElement ele) {
		if (findAndWaitForElement(ele).isDisplayed()||findAndWaitForElement(ele).isEnabled()) {
			findAndWaitForElement(ele).sendKeys(Keys.ENTER);
		}

	}

	public static void selectbyvisibletext(WebElement ele, String text) throws InterruptedException {
		Select select = new Select(findAndWaitForElement(ele));
		if (select.isMultiple() == false) {
			select.deselectAll();
			//Thread.sleep(500);
			select.selectByVisibleText(text);
		} else {
			System.out.println("This is not single selection");
		}
	}

	public static void selectByValue(WebElement ele, String text) throws InterruptedException {
		Select select = new Select(findAndWaitForElement(ele));
		if (select.isMultiple() == false) {
			select.deselectAll();
			//Thread.sleep(500);
			select.selectByValue(text);
		} else {
			System.out.println("This is not single selection");
		}

	}

	public static void selectByIndex(WebElement ele, int index) throws InterruptedException {
		Select select = new Select(findAndWaitForElement(ele));
		if (select.isMultiple() == false) {
			select.deselectAll();
			//Thread.sleep(500);
			select.selectByIndex(index);
		} else {
			System.out.println("This is not single selection");
		}

	}

	public static void SwitchToAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (Exception Ex) {

		}
	}
	public static void uploadFile(WebElement fileInput, String filePath) {
		if (fileInput != null) {
			fileInput.sendKeys(filePath);
		} else {
			System.out.println("File input element not found.");
		}
	}

	public static String generateUniqueName() {
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		StringBuilder uniqueName = new StringBuilder();
		Random random = new Random();
		int length = 8; // Change the length as needed

		for (int i = 0; i < length; i++) {
			uniqueName.append(characters.charAt(random.nextInt(characters.length())));
		}

		newProgram = "User" + uniqueName.toString();
		System.out.println("Generated program name: " + newProgram);
		return newProgram;
	}


	public void createNewProgram(WebDriver driver, String programName) {

		System.out.println("Creating a new program: " + programName);
	}

	public static  void clickOnProgram(WebDriver driver, String programName) {
		// Locate and click on the program element based on its name
		WebElement programElement = driver.findElement(By.xpath("//div[contains(text(), '" + programName + "')]"));
		programElement.click();
		System.out.println("Clicked on program: " + programName);

	}
	public static  String verifyProgram(WebDriver driver, String programName) {
		// Locate and click on the program element based on its name
		WebElement programElement = driver.findElement(By.xpath("//div[contains(text(), '" + programName + "')]"));
		System.out.println(programName);
		System.out.println("The selected program name is: "+programElement);
		return programName;

	}
	public static void isFileDownload(String expectedFileName, String fileExtension, int timeout) {

		//downloads folder path
		String folderName=System.getProperty("user.dir")+File.separator+"downloads";
		
		File[] listOfFiles;
		
		String fileName;
		
	//	boolean fileDownloaded=false;
		
		long startTime=Instant.now().toEpochMilli();
		
		long waitTime=startTime+timeout;
		
		while(Instant.now().toEpochMilli()<waitTime) {
			
			//get all the files from downloaded folder
			listOfFiles=new File(folderName).listFiles();

			for(File file:listOfFiles) {
				fileName=file.getName().toLowerCase();

				if(fileName.contains(expectedFileName.toLowerCase()) && fileName.contains(fileExtension.toLowerCase()) 
						&& ! fileName.contains("crdownload") && file.lastModified() > startTime) 

				{
					
				}
	}
			
			
		}
		
}

}

