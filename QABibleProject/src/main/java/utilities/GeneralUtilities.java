package utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class GeneralUtilities {

	public String getElementText(WebElement element) {
		String text = element.getText();
		return text;

	}

	public String getStylePropertyValue(WebElement element, String propertyType) {
		String propertyValue = element.getCssValue(propertyType);
		return propertyValue;
	}

	public boolean isCheckBoxRadioButtonSelected(WebElement element) {
		element.click();
		boolean flag = element.isSelected();
		return flag;
	}

	public String getTooltipText(WebElement element, String attributeType) {
		String text = element.getAttribute(attributeType);
		return text;

	}

	public boolean getPresenceOnAnElement(WebElement element) {
		boolean verification = element.isDisplayed();
		return verification;
	}

	public String getSelectedTextfromDropDown(WebElement element, int index) {
		element.click();
		Select obj = new Select(element);
		obj.selectByIndex(index);
		WebElement selectedOpt = obj.getFirstSelectedOption();
		return selectedOpt.getText();
	}

}
