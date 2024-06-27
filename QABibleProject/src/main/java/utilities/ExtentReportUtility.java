package utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportUtility implements ITestListener {   //ITestListener-listener interface
	
	ExtentSparkReporter sparkReporter; //library class of extent report and its reference variable
	ExtentReports reports; //library class of extent report and its reference variable
	ExtentTest test; //library class of extent report and its reference variable

	//to add core configurations
	public void configureReport() {

	String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());//date & time capture using java

	File reportPath=new File(System.getProperty("user.dir")+"//ExtentReport");

	if(!reportPath.exists()) {
	reportPath.mkdir(); //create folder using java for storing extent Report
	}

	//create file //empty html file created
	sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"//ExtentReport//"+"ExtentReport_" + timeStamp + ".html");
	reports = new ExtentReports();
	reports.attachReporter(sparkReporter);

	//System details
	reports.setSystemInfo("PC Name", "ALViNs"); // to add system info
	reports.setSystemInfo("OS", "Windows 10");
	sparkReporter.config().setDocumentTitle("Extent Report Sample"); 
	sparkReporter.config().setReportName("Report Summary");
	sparkReporter.config().setTheme(Theme.DARK);
	}

	public void onTestStart(ITestResult result) {

	}

    //2.if test case is a success, control comes here
	public void onTestSuccess(ITestResult result) {
	test = reports.createTest(result.getName());
	test.log(Status.PASS,
	MarkupHelper.createLabel("Name of the Passed Test Case is : " + result.getName(), ExtentColor.GREEN));

	}

	//3.if test case is a fail, control comes here
	public void onTestFailure(ITestResult result) {
	test = reports.createTest(result.getName());
	test.log(Status.FAIL,
	MarkupHelper.createLabel("Name of the Failed Test Case is : " + result.getName(), ExtentColor.RED));

	}

	//4.if test case is skipped, control comes here
	public void onTestSkipped(ITestResult result) {
	test = reports.createTest(result.getName());
	test.log(Status.SKIP,
	MarkupHelper.createLabel("Name of the skipped test case is : " + result.getName(), ExtentColor.YELLOW));

	}


	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}


	public void onTestFailedWithTimeout(ITestResult result) {

	}

    //1.control comes here 1st (onStart) when execution start-creating folder
	public void onStart(ITestContext context) {
	configureReport();
	}

    //control comes here after all executions are over
	public void onFinish(ITestContext context) {
	reports.flush(); //flush generates final output report
	}



}
