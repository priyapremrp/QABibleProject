package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class CreateWorkerPage {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public CreateWorkerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "worker-title")
	WebElement dropDown;

	public String titleDropDownValue() {
		return gu.getSelectedTextfromDropDown(dropDown, 2);
	}

}
