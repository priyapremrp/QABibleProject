package testCasesPackage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import elementRepository.CreateWorkerPage;
import elementRepository.LoginPage;
import elementRepository.WorkerPage;
import utilities.ExcelRead;

public class CreateWorkerTestCase extends BaseClass {
	@Test(groups = "Critical", retryAnalyzer = retry.Retry.class)
	public void verificationOfTitleDropDownValueFromCreateWorkerPage() throws IOException {
		LoginPage lp = new LoginPage(driver);
		lp.inputUserName(ExcelRead.getStringData(1,0));
		lp.inputPassword(ExcelRead.getStringData(1,1));
		lp.clickLoginButton();

		WorkerPage wp = new WorkerPage(driver);
		wp.navigateToWorkerPage();
		wp.clickOnCreateWorkerButton();
		CreateWorkerPage cwp = new CreateWorkerPage(driver);
		String actual = cwp.titleDropDownValue();
		String expected = "Ms";
		Assert.assertEquals(actual, expected,"Feature is not working");

	}
}
