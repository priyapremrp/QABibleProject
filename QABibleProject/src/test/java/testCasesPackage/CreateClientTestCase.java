package testCasesPackage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import elementRepository.ClientsPage;
import elementRepository.CreateClientPage;
import elementRepository.LoginPage;
import utilities.ExcelRead;

public class CreateClientTestCase extends BaseClass {
	@Test(groups = "High", retryAnalyzer = retry.Retry.class)
	public void toCheckWhetherRequirePoCheckboxIsCheckedFromCreateClientSubPage() throws IOException {
		LoginPage lp = new LoginPage(driver);
		lp.inputUserName(ExcelRead.getStringData(1,0));
		lp.inputPassword(ExcelRead.getStringData(1,1));
		lp.clickLoginButton();

		ClientsPage cp = new ClientsPage(driver);
		cp.navigateToClientsPage();
		//cp.clickOnCreateWorkerButton();

		CreateClientPage ccp = new CreateClientPage(driver);
		ccp.toCheckTextBox();
		boolean actual = ccp.toCheckWhetherTextBoxIsSelectedOrNot();
		boolean expected = true;
		Assert.assertEquals(actual, expected);
	}
}
