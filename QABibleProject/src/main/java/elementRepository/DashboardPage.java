package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;
import utilities.WaitUtility;

public class DashboardPage {

	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='#']")
	WebElement dashboardname;

	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	WebElement userProfileButton;

	@FindBy(xpath = "//a[@data-method='post']")
	WebElement logoutButton;

	public String getDashboardUsersNameDisplayed() {
		return gu.getElementText(dashboardname);
	}

	public void toClickOnUserProfile() {
		userProfileButton.click();
	}

	public void toClickOnLogOutButton() {
		logoutButton.click();
	}

}
