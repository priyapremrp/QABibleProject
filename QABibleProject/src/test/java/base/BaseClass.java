package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import utilities.CaptureScreenShotForFailedTestCases;

public class BaseClass {

	public WebDriver driver;
	
public static Properties prop;//prop is the ref variable of class Properties
	
	public static void readFromPropertiesFile() throws IOException {
		prop = new Properties();
		FileInputStream ip = new FileInputStream(
		System.getProperty("user.dir") + "//src//test//resources//Properties//Config.properties");
		prop.load(ip);
	}

	@BeforeMethod
	public void beforeMethod() throws IOException {
		
		readFromPropertiesFile();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("baseURL"));
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));

	}

	@AfterMethod
	public void afterMethod(ITestResult itestresult) throws IOException 
	{
		if(itestresult.getStatus()==ITestResult.FAILURE)
		{
			CaptureScreenShotForFailedTestCases ss=new CaptureScreenShotForFailedTestCases();
			ss.captureScreenShotForFailedTestcase(driver, itestresult.getName());
		}
		
		driver.close();
	}

}
