package Base;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Global.ExtentReporter;


public class Listners extends Base implements ITestListener {
	
	ExtentTest test;
	
	ThreadLocal<ExtentTest> extentTestobj = new ThreadLocal<ExtentTest>(); //thread safe, every testcases will have their unique id

	ExtentReports extent = ExtentReporter.getReportData();

	@Override
	public void onTestStart(ITestResult result) {

		test = extent.createTest(result.getMethod().getMethodName());
		extentTestobj.set(test);
	}

	public void onTestSuccess(ITestResult result) {
		extentTestobj.get().log(Status.PASS, "Pass");
	}

	public void onTestFailure(ITestResult result) {
		extentTestobj.get().fail(result.getThrowable());
		
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String filePath = null; 	
		try {
			 filePath = getScreenshot(result.getMethod().getMethodName(), driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extentTestobj.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
	}

	public void onTestSkipped(ITestResult result) {
		// not implemented
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// not implemented
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		onTestFailure(result);
	}

	public void onStart(ITestContext context) { 
		// not implemented
	}

	public void onFinish(ITestContext context) {
		// not implemented
		extent.flush();
	}

}
