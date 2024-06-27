package testCasesPackage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import elementRepository.ClientsPage;
import elementRepository.LoginPage;
import utilities.ExcelRead;

public class ClientTestCase extends BaseClass {

	@Test(groups = "High")
	public void verifyTheBackgroundColourOfSearchButtonFromClientsPage() throws IOException {
		LoginPage lp = new LoginPage(driver);
		lp.inputUserName(ExcelRead.getStringData(1,0));
		lp.inputPassword(ExcelRead.getStringData(1,1));
		lp.clickLoginButton();

		ClientsPage cp = new ClientsPage(driver);
		cp.navigateToClientsPage();
		String actual = cp.clientsPageSearchButtonColour();
		String expected = "rgba(51, 122, 183, 1)";
		Assert.assertEquals(actual, expected);

	}
	
	@Test(groups = "High")
	public void verifytheTooltipValueOfEditIconInTheClientsPage() {

		LoginPage lp = new LoginPage(driver);
		lp.inputUserName("Carol");
		lp.inputPassword("1q2w3e4r");
		lp.clickLoginButton();

		ClientsPage cp = new ClientsPage(driver);
		cp.navigateToClientsPage();
		String actual = cp.getTextOfEditButton();
		String expected = "Update";
		Assert.assertEquals(actual, expected);
	}
	
}
