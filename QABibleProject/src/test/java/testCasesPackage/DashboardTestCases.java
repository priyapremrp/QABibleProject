package testCasesPackage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import constant.Constant;
import elementRepository.DashboardPage;
import elementRepository.LoginPage;
import utilities.ExcelRead;

public class DashboardTestCases extends BaseClass {
	

	@Test(groups = "Critical")
	public void verificationOfLogoutFeature() throws IOException {
		LoginPage lp = new LoginPage(driver);
		lp.inputUserName(ExcelRead.getStringData(1,0));
		lp.inputPassword(ExcelRead.getStringData(1,1));
		
		lp.clickLoginButton();

		DashboardPage db = new DashboardPage(driver);
		db.toClickOnUserProfile();
		db.toClickOnLogOutButton();
		boolean actual = lp.checkPresenceOfAnElement();
		boolean expected = true;
		Assert.assertEquals(actual, expected, Constant.errorMessageForLogoutFeature);
	}
  
}
