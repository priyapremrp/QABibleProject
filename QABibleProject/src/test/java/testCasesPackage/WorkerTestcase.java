package testCasesPackage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import constant.Constant;
import elementRepository.LoginPage;
import elementRepository.WorkerPage;
import utilities.ExcelRead;

public class WorkerTestcase extends BaseClass {
	@Test(groups = "Critical")
	public void verifyTheTextOfTheSearchButtonInWorkerPage() throws IOException {
		LoginPage lp = new LoginPage(driver);
		lp.inputUserName(ExcelRead.getStringData(1,0));
		lp.inputPassword(ExcelRead.getStringData(1,1));
		lp.clickLoginButton();

		WorkerPage wp = new WorkerPage(driver);
		wp.navigateToWorkerPage();
		String actual = wp.getSearchButtonText();
		String expected = "Search";
		Assert.assertEquals(actual, expected, Constant.errorMessage);

	}

}
