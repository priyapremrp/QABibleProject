package utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	
	public void waitForPresenceOfElementLocated(WebDriver driver, String locator)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000)); //Explicit wait - object created for explicit wait.
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(locator)));
	}
	
	public void waitForAlertToBePresent(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000)); //Explicit wait - object created for explicit wait.
		wait.until(ExpectedConditions.alertIsPresent());
	}

}
