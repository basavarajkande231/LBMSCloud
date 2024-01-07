package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class base {

	public static Logger log = LogManager.getLogger();	
	public static WebDriver driver;
	public static Properties prop;
	public static String Username;
	public static String Password;
	public static String View_password;

	public static WebDriver initializeDriver() throws IOException, InterruptedException {

		//Getting the browser name from properties file
		prop= new Properties();
		log.info("looging using log4j2");
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/resources/data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		Username = prop.getProperty("username");
		Password = prop.getProperty("password");
		View_password = prop.getProperty("Viewpassword");
		System.out.println(browserName);

		if (browserName.equals("chrome")) {

			WebDriverManager.chromedriver().setup();
			
			// Use this code if you wnat to hide the "Chrome is being controlled by automated test software"
			ChromeOptions options = new ChromeOptions(); 
			options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"}); 
			
		// use this code to hide the Save password popup
			options.addArguments("--disable-save-password-bubble");
			Map<String, Object> prefs = new HashMap<String, Object>();
		     prefs.put("credentials_enable_service", false);
		     prefs.put("profile.password_manager_enabled", false);
		     options.setExperimentalOption("prefs", prefs);
			
		     //use the below code if you want to run the code in headless mode
		     options.addArguments("headless");
			
			driver= new ChromeDriver(options);
			
		
			
		}else if (browserName.equals("firefox")) {

			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
			
		}else if (browserName.equals("safari")) {
			WebDriverManager.safaridriver().setup();
			driver=new SafariDriver();
			
		}else if (browserName.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			
			// Use this code if you wnat to hide the "Microsoft Edge is being controlled by automated test software"
			
			EdgeOptions options = new EdgeOptions(); 
			options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"}); 
			driver=new EdgeDriver(options);
			
		}

		driver.manage().window().maximize();
	
		/*
		driver.get("chrome://settings/clearBrowserData"); 
		Thread.sleep(3000);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		WebElement clearData =  (WebElement) jse.executeScript("return document.querySelector(\"body > settings-ui\").shadowRoot.querySelector(\"#main\").shadowRoot.querySelector(\"settings-basic-page\").shadowRoot.querySelector(\"#basicPage > settings-section:nth-child(9) > settings-privacy-page\").shadowRoot.querySelector(\"settings-clear-browsing-data-dialog\").shadowRoot.querySelector(\"#clearBrowsingDataConfirm\")");
		Thread.sleep(3000);
		clearData.click();
		Thread.sleep(5000);
        */
		
		String applicationURL = prop.getProperty("url");
		driver.get(applicationURL);
		String title = driver.getTitle();
		System.out.println(title);
		return driver;
	}

	public static String getusername() {
		return Username;
	}
	public static String getpassword() {
		return Password;
	}

	public static String getViewpassword() {
		return View_password;
	}
}
