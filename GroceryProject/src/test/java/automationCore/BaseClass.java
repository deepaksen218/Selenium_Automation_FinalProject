package automationCore;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constant.Constants;
import utilities.ScreenshotUtility;

public class BaseClass {
	Properties prop;
	FileInputStream file;
	
	public WebDriver driver;
	
	// here we are doing parameterization
	
	@BeforeMethod(alwaysRun = true) // (alwaysRun = true) to run for grouping
	@Parameters("browser")
	public void browserLaunch(String browser) throws Exception {
		prop = new Properties();
		file= new FileInputStream(Constants.configFile);
		prop.load(file);
		
		if (browser.equalsIgnoreCase("Chrome")) {
			// on the aboveequalsIgnore is used to avoid Case sensitive for browser Chrome or chrome
			driver = new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("Firefox")) {

			driver = new FirefoxDriver();
			
		}
		else if (browser.equalsIgnoreCase("Edge")) {

			driver = new EdgeDriver();
			
		} 
		else {
			throw new Exception ("Invalid Browser");
		}
	
		//driver.get("https://groceryapp.uniqassosiates.com/admin/login");
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // implicitly Wait
	}
	
	@AfterMethod(alwaysRun = true) // (alwaysRun = true) to run for grouping
	public void browserClose(ITestResult itest) throws IOException {
		if (itest.getStatus() == ITestResult.FAILURE){
			ScreenshotUtility screenshot = new ScreenshotUtility();
			screenshot.getScreenshot(driver, itest.getName());
		}
		driver.quit();
	}

}
