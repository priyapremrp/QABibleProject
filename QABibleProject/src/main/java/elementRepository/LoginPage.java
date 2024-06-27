package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;
import utilities.WaitUtility;

public class LoginPage {

	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	WaitUtility wu=new WaitUtility();


	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "loginform-username")
	WebElement username;

	@FindBy(id = "loginform-password")
	WebElement password;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement loginButton;

	public void inputUserName(String uname) {
		username.sendKeys(uname);

	}

	public void inputPassword(String pswd) {

		password.sendKeys(pswd);
	}

	public void clickLoginButton() {

		loginButton.click();
	}

	public boolean checkPresenceOfAnElement() {
		
		return gu.getPresenceOnAnElement(username);
	}

}
