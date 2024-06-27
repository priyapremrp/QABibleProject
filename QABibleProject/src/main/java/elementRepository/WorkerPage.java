package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.GeneralUtilities;

public class WorkerPage {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public WorkerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Workers")
	WebElement workerButton;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement serachButton;

	@FindBy(linkText = "Create Worker")
	WebElement createWorker;

	@FindBy(id = "\"worker-title\"")
	WebElement dropDown;

	public void navigateToWorkerPage() {
		workerButton.click();
	}

	public String getSearchButtonText() {
		return gu.getElementText(serachButton);
	}

	public void clickOnCreateWorkerButton() {
		createWorker.click();
	}

}
