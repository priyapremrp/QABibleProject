package testCasesPackage;

import org.testng.annotations.Test;
import base.BaseClass;
import elementRepository.DashboardPage;
import elementRepository.LoginPage;
import utilities.ExcelRead;
import utilities.WaitUtility;

import java.io.IOException;
import org.testng.Assert;


public class LoginTestCases extends BaseClass {
	
	WaitUtility wu=new WaitUtility();

	@Test(groups = "Critical")
	public void verifyLoginIsWorkingWithValidUser() throws IOException {
		LoginPage lp = new LoginPage(driver);
		lp.inputUserName(ExcelRead.getStringData(1,0));
		lp.inputPassword(ExcelRead.getStringData(1,1));
		lp.clickLoginButton();

		DashboardPage db = new DashboardPage(driver);
		String actual = db.getDashboardUsersNameDisplayed();
		String expected = "CAROL THOMAS";
		Assert.assertEquals(actual, expected, "UserName Not found on Page");

	}

}
