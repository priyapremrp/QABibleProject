package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class CreateClientPage {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public CreateClientPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "client-require_po")
	WebElement checkBox;

	public void toCheckTextBox() {
		checkBox.click();
	}

	public boolean toCheckWhetherTextBoxIsSelectedOrNot() {
		return gu.isCheckBoxRadioButtonSelected(checkBox);
	}

}
