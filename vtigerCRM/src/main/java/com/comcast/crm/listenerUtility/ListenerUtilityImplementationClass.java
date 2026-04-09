package com.comcast.crm.listenerUtility;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.baseClassUtilities.BaseClassUtilities;

public class ListenerUtilityImplementationClass implements ITestListener, ISuiteListener {

	public static ExtentReports report;
	public static ExtentTest test;
	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}

	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("Report configurations");

		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report.html");
		spark.config().setDocumentTitle("ecommerceAPP");
		spark.config().setReportName("EReport");
		spark.config().setTheme(Theme.DARK);

		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-10");
	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test=report.createTest(result.getMethod().getMethodName());
		test.log(Status.INFO, "login Successfull");
		test.log(Status.INFO, "contact added");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println(result.getMethod().getMethodName()+ " success");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		/*String failedMethodName = result.getMethod().getMethodName();
		TakesScreenshot src = (TakesScreenshot) BaseClassUtilities.sdriver;
		File temp = src.getScreenshotAs(OutputType.FILE);
		JavaUtilities jutil = new JavaUtilities();
		String time = jutil.getSystemDate();
		File dest = new File("./Screenshot/" + failedMethodName + "_" + time + ".png");
		try {
			FileUtils.copyFile(temp, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		/** if we use extent report output type shold be Base64 return String**/
		try {
		TakesScreenshot  src=(TakesScreenshot) BaseClassUtilities.sdriver;
		String temp=src.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(temp,result.getMethod().getMethodName()+"Failtest");
		test.log(Status.FAIL, "ScreenShotTaken");
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println(result.getMethod().getMethodName()+ " Skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

}
