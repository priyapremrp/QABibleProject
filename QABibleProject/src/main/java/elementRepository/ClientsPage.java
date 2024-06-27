package elementRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ClientsPage {

	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public ClientsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Clients")
	WebElement clientsButton;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement clientsSearchButton;

	@FindBy(xpath = "//span[@class='glyphicon glyphicon-pencil']")
	WebElement editButton;

	@FindBy(linkText = "Create Client")
	WebElement createClient;

	public void navigateToClientsPage() {
		clientsButton.click();
	}

	public String clientsPageSearchButtonColour() {
		return gu.getStylePropertyValue(clientsSearchButton, "background-color");

	}

	public String getTextOfEditButton() {
		return gu.getTooltipText(editButton, "title");
	}

	public void clickOnCreateWorkerButton() {
		createClient.click();
	}

}
